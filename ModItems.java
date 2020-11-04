package com.jou.projectsao.item;

import com.jou.projectsao.ProjectSAOMod;
import com.jou.projectsao.util.Registration;
import net.minecraft.item.*;
import net.minecraft.item.Food.Builder;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    //----------------------ITEMS--------------------------\\

    public static final RegistryObject<Item> STEEL_INGOT =
            Registration.ITEMS.register("steel_ingot",
                    () -> new Item(new Item.Properties().group(ProjectSAOMod.SAO_ITEMS)));

    public static final RegistryObject<Item> CRYSTALLITE_INGOT =
            Registration.ITEMS.register("crystallite_ingot",
                    () -> new Item(new Item.Properties().group(ProjectSAOMod.SAO_ITEMS)));

    //----------------------FOOD--------------------------\\

    //----------------------Carrots-----------------------\\

    public static final RegistryObject<Item> D_CARROT =
            Registration.ITEMS.register("d_carrot",
                    () -> new Item(new Item.Properties().group(ProjectSAOMod.SAO_FOOD).food(new Food.Builder().hunger(1).saturation(1.0f).build())));

    public static final RegistryObject<Item> C_CARROT =
            Registration.ITEMS.register("c_carrot",
                    () -> new Item(new Item.Properties().group(ProjectSAOMod.SAO_FOOD).food(new Food.Builder().hunger(2).saturation(2.0f).build())));

    public static final RegistryObject<Item> B_CARROT =
            Registration.ITEMS.register("b_carrot",
                    () -> new Item(new Item.Properties().group(ProjectSAOMod.SAO_FOOD).food(new Food.Builder().hunger(3).saturation(3.0f).build())));

    public static final RegistryObject<Item> A_CARROT =
            Registration.ITEMS.register("a_carrot",
                    () -> new Item(new Item.Properties().group(ProjectSAOMod.SAO_FOOD).food(new Food.Builder().hunger(4).saturation(4.0f).build())));

    public static final RegistryObject<Item> S_CARROT =
            Registration.ITEMS.register("s_carrot",
                    () -> new  Item(new Item.Properties().group(ProjectSAOMod.SAO_FOOD).food(new Food.Builder().hunger(4).saturation(4.0f)
                            .effect(() -> new EffectInstance(Effects.NIGHT_VISION, 2, 10)).build())));

    //----------------------TOOLS--------------------------\\

    public static final RegistryObject<Item> STEEL_SHOVEL =
            Registration.ITEMS.register("steel_shovel",
                    () -> new ShovelItem(ModItemTier.STEEL, 2, 0.0f, new Item.Properties()
                            .defaultMaxDamage(150).addToolType(ToolType.SHOVEL, 3).group(ProjectSAOMod.SAO_TOOLS)));

    public static final RegistryObject<Item> STEEL_AXE =
            Registration.ITEMS.register("steel_axe",
                    () -> new AxeItem(ModItemTier.STEEL, 8, 0.0f, new Item.Properties()
                            .defaultMaxDamage(150).addToolType(ToolType.AXE, 3).group(ProjectSAOMod.SAO_TOOLS)));

    public static final RegistryObject<Item> STEEL_PICKAXE =
            Registration.ITEMS.register("steel_pickaxe",
                    () -> new PickaxeItem(ModItemTier.STEEL, 2, 0.0f, new Item.Properties()
                            .defaultMaxDamage(150).addToolType(ToolType.PICKAXE, 3).group(ProjectSAOMod.SAO_TOOLS)));

    public static final RegistryObject<Item> STEEL_HOE =
            Registration.ITEMS.register("steel_hoe",
                    () -> new HoeItem(ModItemTier.STEEL, 1, 0.0f, new Item.Properties()
                            .defaultMaxDamage(150).addToolType(ToolType.HOE, 3).group(ProjectSAOMod.SAO_TOOLS)));

    //----------------------WEAPONS--------------------------\\

    public static final RegistryObject<Item> STEEL_SWORD =
            Registration.ITEMS.register("steel_sword",
                    () -> new SwordItem(ModItemTier.STEEL, 6, 0.0f, new Item.Properties()
                            .defaultMaxDamage(1000).group(ProjectSAOMod.SAO_Weapons)));

    public static final RegistryObject<Item> ELUCIDATOR =
            Registration.ITEMS.register("elucidator",
                    () -> new SwordItem(ModItemTier.SAO_WEAPONS, 11, 0.0f, new Item.Properties()
                            .defaultMaxDamage(1000).group(ProjectSAOMod.SAO_Weapons)));

    public static final RegistryObject<Item> SHADOW_ESTOC =
            Registration.ITEMS.register("shadow_estoc",
                    () -> new SwordItem(ModItemTier.SAO_WEAPONS, 7, 1.0f, new Item.Properties()
                            .defaultMaxDamage(1000).group(ProjectSAOMod.SAO_Weapons)));

    public static final RegistryObject<Item> MATE_CHOPPER =
            Registration.ITEMS.register("mate_chopper",
                    () -> new SwordItem(ModItemTier.SAO_WEAPONS, 15, -2.0f, new Item.Properties()
                            .defaultMaxDamage(1000).group(ProjectSAOMod.SAO_Weapons)));

    public static final RegistryObject<Item> GUILTY_THORN =
            Registration.ITEMS.register("guilty_thorn",
                    () -> new SwordItem(ModItemTier.SAO_WEAPONS, 9, 0.0f, new Item.Properties()
                            .defaultMaxDamage(1000).group(ProjectSAOMod.SAO_Weapons)));

    public static void  register( ) {}



    public enum ModItemTier implements IItemTier
    {
        //----------------------TOOL_TIERS--------------------------\\

        STEEL(2, 150, 10.0f, 0f, 15, Ingredient.fromStacks(new ItemStack(ModItems.STEEL_INGOT.get()))),
        SAO_WEAPONS(0, 1000, 0.0f, 0f, 0, Ingredient.fromStacks(new ItemStack(ModItems.STEEL_INGOT.get())));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int entchantability;
        private final Ingredient repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int entchantability, Ingredient repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.entchantability = entchantability;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return entchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }
    }
}
