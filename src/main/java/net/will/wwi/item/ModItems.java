package net.will.wwi.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.will.wwi.block.ModBlocks;
import net.will.wwi.wwi;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, wwi.MOD_ID);

    public static final RegistryObject<Item> FRANCIUM_INGOT = ITEMS.register("francium_ingot",
            () -> new Item(new Item.Properties()));

    //gemstones
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PINK_TOURMALINE = ITEMS.register("pink_tourmaline",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PINK_TOURMALINE_POWDER = ITEMS.register("pink_tourmaline_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY_POWDER = ITEMS.register("ruby_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_POWDER = ITEMS.register("sapphire_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ_POWDER = ITEMS.register("topaz_powder",
            () -> new Item(new Item.Properties()));
    //food
    public static final RegistryObject<Item> KFC_BUCKET = ITEMS.register("kfc_bucket",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(16)
                            .saturationMod(7f)
                            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION,1200,49,false,false,false),1f)
                            .build())
                    .rarity(Rarity.RARE)));
    public static final RegistryObject<Item> KFC_BUCKET_SEEDS = ITEMS.register("kfc_bucket_seeds",
            () -> new ItemNameBlockItem(ModBlocks.KFC_BUCKET_CROP.get(),new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
