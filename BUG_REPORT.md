# Bug Report for mygemmod

This document lists all the bugs and issues found in the codebase.

---

## 🔴 Critical Bugs

### 1. **RepairItemRecipeMixin.java** - Incomplete Mixin Implementation
**File:** `src/main/java/com/myapps/mymod/mixin/RepairItemRecipeMixin.java`  
**Lines:** 19-31  
**Severity:** HIGH

**Issue:**
The mixin method `assemble()` creates variables but never uses them and doesn't set a return value:
```java
@Inject(method = "assemble...", at = @At("HEAD"), cancellable = true)
public void assemble(CraftingInput craftingInput, HolderLookup.Provider provider, CallbackInfoReturnable<ItemStack> cir) {
    ItemStack itemStack3;     // Declared but never assigned
    ItemStack itemStack;      // Declared but never used
    ArrayList<ItemStack> list = Lists.newArrayList();
    for (int i = 0; i < craftingInput.ingredientCount(); ++i) {
        ItemStack itemStack2; // Declared inside loop but never used
        itemStack = craftingInput.getItem(i);
        if (itemStack.isEmpty())
            continue;
        list.add(itemStack);
    }
    // No return value set! The method is cancellable but never cancels or returns
}
```

**Impact:**
- Dead code that does nothing
- Populates a list that is never used
- Cancellable injection point that never cancels or sets a return value
- Wasted CPU cycles on every recipe assembly

**Fix Needed:** Either complete the implementation or remove this mixin entirely.

---

### 2. **PiglinAiMixin.java** - Empty Loop Implementation
**File:** `src/main/java/com/myapps/mymod/mixin/PiglinAiMixin.java`  
**Lines:** 15-19  
**Severity:** HIGH

**Issue:**
The method has an empty for-each loop that does nothing:
```java
@Inject(method = "isWearingSafeArmor...", at = @At("HEAD"), cancellable = true)
public static void isWearingSafeArmor(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
    for (EquipmentSlot equipmentslot : EquipmentSlotGroup.ARMOR) {
        // Loop body is empty - does nothing!
    }
    // Never sets a return value despite being cancellable
}
```

**Impact:**
- Dead code that serves no purpose
- Iterates through armor slots but doesn't check anything
- Could affect Piglin AI behavior unpredictably
- Wastes CPU cycles

**Fix Needed:** Either implement the armor check logic or remove this mixin.

---

### 3. **LivingEntityMixin.java** - Empty Conditional Block
**File:** `src/main/java/com/myapps/mymod/mixin/LivingEntityMixin.java`  
**Lines:** 31-36  
**Severity:** MEDIUM

**Issue:**
The `swing()` method has an empty if-statement:
```java
@Inject(method = "swing(Lnet/minecraft/world/InteractionHand;Z)V", at = @At("HEAD"))
public void swing(InteractionHand hand, boolean updateSelf, CallbackInfo ci) {
    ItemStack stack = ((LivingEntity) (Object) this).getItemInHand(hand);
    if (!stack.isEmpty()) {
        // Empty block - no logic implemented!
    }
}
```

**Impact:**
- Wastes CPU checking if stack is empty for no reason
- Unclear intent - was something supposed to happen here?
- Dead code that could confuse future maintainers

**Fix Needed:** Either implement the intended logic or remove the method.

---

### 4. **LivingEntityMixin.java** - Potential Null Pointer Exception
**File:** `src/main/java/com/myapps/mymod/mixin/LivingEntityMixin.java`  
**Lines:** 74-77  
**Severity:** HIGH

**Issue:**
Calls `itemEntity.getOwner()` which can return `null`, but the result is passed directly to the event handler:
```java
@Inject(method = "onItemPickup(Lnet/minecraft/world/entity/item/ItemEntity;)V", at = @At("HEAD"))
public void onItemPickup(ItemEntity itemEntity, CallbackInfo ci) {
    LivingEntityEvents.ENTITY_PICKUP_ITEM.invoker().onEntityPickupItem(
        itemEntity.getOwner(),  // Can be NULL!
        itemEntity.getItem()
    );
}
```

**Impact:**
- Potential NullPointerException if item has no owner
- Could crash the game when picking up items
- Event handlers receiving null entity parameter

**Fix Needed:** Add null check before invoking the event.

---

### 5. **ItemStackMixin.java** - Potential Null Pointer Exception
**File:** `src/main/java/com/myapps/mymod/mixin/ItemStackMixin.java`  
**Lines:** 19-29  
**Severity:** HIGH

**Issue:**
Assumes `context.getPlayer()` is never null:
```java
@Inject(method = "useOn...", at = @At("TAIL"), cancellable = true)
public void useOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
    Player player = context.getPlayer();  // Can be NULL!
    ItemStack copy = context.getItemInHand().copy();
    BlockState placedAgainst = player.level().getBlockState(...);  // NPE if player is null!
    if (!player.level().isEmptyBlock(...)) {  // NPE if player is null!
        // ...
    }
}
```

**Impact:**
- NullPointerException when items are used without a player (e.g., dispensers, command blocks)
- Game crash in certain automation scenarios
- Mod incompatibility with other mods that use items programmatically

**Fix Needed:** Add null check for player before using it.

---

### 6. **BlockItemMixin.java** - Potential Null Pointer Exception
**File:** `src/main/java/com/myapps/mymod/mixin/BlockItemMixin.java`  
**Lines:** 18-25  
**Severity:** HIGH

**Issue:**
Similar to ItemStackMixin, assumes player is never null:
```java
@Inject(method = "useOn...", at = @At("HEAD"), cancellable = true)
public void useOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
    BlockPlaceContext placeContext = new BlockPlaceContext(context);
    boolean result = BlockEvents.BLOCK_PLACE.invoker().onBlockPlaced(
        context.getClickedPos(), 
        (Entity) placeContext.getPlayer(),  // Can be NULL!
        ((BlockItem) placeContext.getItemInHand().getItem()).getBlock().defaultBlockState(),
        placeContext.getPlayer().level().getBlockState(context.getClickedPos())  // NPE if player is null!
    );
    // ...
}
```

**Impact:**
- NullPointerException when blocks are placed without a player
- Crash with automated block placing systems
- Mod incompatibility issues

**Fix Needed:** Add null check for player.

---

### 7. **AmethystSwordEntitySwingsItemProcedure.java** - Wrong Effect Applied
**File:** `src/main/java/com/myapps/mymod/procedures/AmethystSwordEntitySwingsItemProcedure.java`  
**Lines:** 9-15  
**Severity:** MEDIUM-HIGH

**Issue:**
The procedure applies INVISIBILITY effect to the target when the attacker swings the Amethyst Sword:
```java
public static void execute(Entity target, Entity attacker) {
    if (target == null)
        return;
    if (target instanceof LivingEntity living && !living.level().isClientSide()) {
        living.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 1));
    }
}
```

**Impact:**
- Unexpected behavior: makes enemies invisible when you hit them
- Makes combat harder instead of easier
- This is likely a logic error - should probably apply a negative effect like WEAKNESS, SLOWNESS, or POISON
- Or it might be intended for the attacker, not the target

**Fix Needed:** Clarify the intended behavior and apply the correct effect to the correct entity.

---

### 8. **ServerPlayerMixin.java** - Invalid Method Descriptor
**File:** `src/main/java/com/myapps/mymod/mixin/ServerPlayerMixin.java`  
**Lines:** 14-21  
**Severity:** CRITICAL

**Issue:**
The mixin target has an invalid method descriptor that includes the class name:
```java
@Inject(method = "Lnet/minecraft/server/level/ServerPlayer;drop(Z)Z", at = @At("HEAD"), cancellable = true)
public void drop(boolean dropStack, CallbackInfoReturnable<Boolean> cir) {
    // ...
}
```

**Impact:**
- Incorrect mixin syntax - method descriptor shouldn't include the class name
- This mixin will likely fail to apply at runtime
- Could cause the entire mod to fail loading
- Should be just `"drop(Z)Z"` not `"Lnet/minecraft/server/level/ServerPlayer;drop(Z)Z"`

**Fix Needed:** Remove the class name from the method descriptor.

---

## ⚠️ Medium Priority Issues

### 9. **MymodModTrades.java** - Incorrect Trade Implementation
**File:** `src/main/java/com/myapps/mymod/init/MymodModTrades.java`  
**Lines:** 33-37  
**Severity:** MEDIUM

**Issue:**
The trade constructor uses `ItemStack` directly but only extracts the item, losing count information:
```java
private record BasicTrade(ItemStack price, ItemStack price2, ItemStack offer, int maxTrades, int xp, float priceMult) implements VillagerTrades.ItemListing {
    @Override
    public @NotNull MerchantOffer getOffer(Entity entity, RandomSource random) {
        return new MerchantOffer(
            new ItemCost(price.getItem()),  // Lost count! Should be price.getItem(), price.getCount()
            Optional.of(new ItemCost(price2.getItem())),  // Lost count!
            offer, maxTrades, xp, priceMult
        );
    }
}
```

**Impact:**
- Trades always require only 1 item regardless of the stack count specified
- Trade prices don't match what was configured
- The trade at line 29 specifies 5 amethyst shards but this will be ignored

**Fix Needed:** Use the ItemCost constructor that accepts both item and count.

---

### 10. **MymodModTabs.java** - Missing AMETHYST_SHOVEL in Tab
**File:** `src/main/java/com/myapps/mymod/init/MymodModTabs.java`  
**Lines:** 26-44  
**Severity:** LOW

**Issue:**
The custom creative tab is missing `AMETHYST_SHOVEL`:
```java
tabData.accept(MymodModItems.AMETHYST_AXE);
tabData.accept(MymodModItems.AMETHYST_PICKAXE);
tabData.accept(MymodModItems.AMETHYST_HOE);
tabData.accept(MymodModItems.AMETHYST_SWORD);
// AMETHYST_SHOVEL is missing!
```

But it IS added to the vanilla Combat tab at line 59, showing inconsistency.

**Impact:**
- Item not visible in custom creative tab
- Inconsistent item availability
- Poor user experience

**Fix Needed:** Add `tabData.accept(MymodModItems.AMETHYST_SHOVEL);` to the custom tab.

---

### 11. **Inconsistent Naming Convention** - "Amythest" vs "Amethyst"
**Files:** Multiple files throughout the codebase  
**Severity:** LOW (but widespread)

**Issue:**
There's a consistent misspelling of "Amethyst" as "Amythest" in class names:
- `AmythestArmorItem.java` (should be `AmethystArmorItem.java`)
- `AmythestArmorArmor.java` (should be `AmethystArmorArmor.java`)
- Variable names: `AMYTHEST_ARMOR_HELMET`, etc.
- Tag: `"mymod:amythest_armor_repair_items"` (should be "amethyst")

Meanwhile, the amethyst tools are spelled correctly:
- `AmethystSwordItem.java` ✓
- `AmethystPickaxeItem.java` ✓
- etc.

**Impact:**
- Confusing inconsistency
- Difficult to search/find related code
- Unprofessional appearance
- Could cause issues if trying to match with Minecraft's built-in amethyst items

**Fix Needed:** Refactor to use consistent "Amethyst" spelling throughout.

---

## 💡 Code Quality Issues

### 12. **Gem_tools* Class Naming** - Non-standard Naming Convention
**Files:** `Gem_toolsPickaxeItem.java`, `Gem_toolsAxeItem.java`, etc.  
**Severity:** LOW

**Issue:**
Class names use underscore `Gem_tools*` which violates Java naming conventions. Should be camelCase like `GemToolsPickaxeItem`.

**Impact:**
- Violates Java style guidelines
- Inconsistent with other class names in the project (like `AmethystPickaxeItem`)
- Makes code harder to read

**Recommendation:** Rename to `GemToolsPickaxeItem`, `GemToolsAxeItem`, etc.

---

### 13. **Overpowered Tool Stats**
**Files:** Various tool item files  
**Severity:** LOW (game balance issue)

**Issue:**
Some tools have extremely high stats:
- `AmethystSwordItem`: 74 attack damage, 16 attack speed (line 14)
  - For comparison, diamond sword is 7 damage, 1.6 speed
- `AmethystAxeItem`: 99 attack damage (line 15)
- `AmethystPickaxeItem`: 39 attack damage (line 14)
- `AmethystShovelItem`: 39 attack damage (line 15)

**Impact:**
- Game balance issues
- Makes game too easy
- Not consistent with Minecraft's progression

**Recommendation:** Review and balance tool stats to reasonable values.

---

### 14. **Unused Imports and Variables**
**Files:** Multiple files  
**Severity:** LOW

**Issue:**
Several files contain unused imports or variables:
- `RepairItemRecipeMixin.java`: unused variables `itemStack3`, `itemStack2`
- Various files import classes that aren't used

**Impact:**
- Code clutter
- Increased compilation time (minimal)
- Confusing for code readers

**Recommendation:** Clean up unused imports and variables.

---

### 15. **Missing Error Handling in clientPlayer()**
**File:** `MymodMod.java`  
**Lines:** 70-87  
**Severity:** LOW

**Issue:**
Uses reflection to get client player but only logs errors:
```java
public static Player clientPlayer() {
    if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
        try {
            // ... reflection code ...
            return (Player) playerHandle.invoke(minecraft);
        } catch (Throwable e) {
            LOGGER.error("Failed to get client player", e);
            return null;  // Silently returns null
        }
    }
    // ...
}
```

**Impact:**
- Callers might not expect null returns
- Errors are logged but not handled
- Could lead to NPE in calling code

**Recommendation:** Document that this method can return null and ensure all callers handle it.

---

## 🔧 Build Configuration Issue

### 16. **Fabric Loom Version Issue**
**File:** `build.gradle`  
**Line:** 2  
**Severity:** HIGH (prevents building)

**Issue:**
Uses SNAPSHOT version of fabric-loom which is not available:
```gradle
plugins {
    id 'fabric-loom' version '1.11-SNAPSHOT'
}
```

**Impact:**
- Project cannot build
- Cannot test the mod
- Development is blocked

**Recommendation:** Use a stable version like `1.11` or `1.10` instead of `1.11-SNAPSHOT`.

---

## 📊 Summary

**Total Bugs Found:** 16

**By Severity:**
- 🔴 Critical: 5 bugs (null pointers, invalid mixins, dead code)
- ⚠️ Medium: 4 bugs (logic errors, missing features)
- 💡 Low: 7 issues (naming, code quality, balance)

**Most Critical Issues to Fix:**
1. Fix null pointer exceptions in mixins (Issues #4, #5, #6)
2. Fix invalid method descriptor in ServerPlayerMixin (Issue #8)
3. Complete or remove incomplete mixin implementations (Issues #1, #2, #3)
4. Fix build configuration (Issue #16)
5. Fix trade implementation to respect item counts (Issue #9)

---

## 🎯 Recommended Fix Priority

**Phase 1 - Critical Crashes:**
1. Add null checks in LivingEntityMixin.onItemPickup()
2. Add null checks in ItemStackMixin.useOn()
3. Add null checks in BlockItemMixin.useOn()
4. Fix ServerPlayerMixin method descriptor
5. Fix build.gradle fabric-loom version

**Phase 2 - Dead Code:**
6. Complete or remove RepairItemRecipeMixin
7. Complete or remove PiglinAiMixin
8. Complete or remove empty swing() method

**Phase 3 - Logic Errors:**
9. Review and fix AmethystSword invisibility effect
10. Fix trade item count handling
11. Add missing AMETHYST_SHOVEL to creative tab

**Phase 4 - Code Quality:**
12. Fix "Amythest" spelling throughout
13. Rename Gem_tools* classes to proper camelCase
14. Balance overpowered tool stats
15. Clean up unused code
16. Improve error handling documentation

---

*Report generated on: 2025-12-11*
*Mod Version: 1.0*
*Minecraft Version: 1.21.8*
