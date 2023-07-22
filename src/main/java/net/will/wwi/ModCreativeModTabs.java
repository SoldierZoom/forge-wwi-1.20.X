package net.will.wwi;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.will.wwi.block.ModBlocks;
import net.will.wwi.item.ModItems;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, wwi.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FRANCIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                        pOutput.accept(ModItems.PINK_TOURMALINE.get());
                        pOutput.accept(ModItems.RUBY.get());
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.TOPAZ.get());
                        pOutput.accept(ModItems.FRANCIUM_NUGGET.get());
                        pOutput.accept(ModItems.FRANCIUM_INGOT.get());
                        pOutput.accept(ModItems.PINK_TOURMALINE_POWDER.get());
                        pOutput.accept(ModItems.RUBY_POWDER.get());
                        pOutput.accept(ModItems.SAPPHIRE_POWDER.get());
                        pOutput.accept(ModItems.TOPAZ_POWDER.get());

                        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.FRANCIUM_BLOCK.get());

                        pOutput.accept(ModItems.KFC_BUCKET.get());
                        pOutput.accept(ModItems.KFC_BUCKET_SEEDS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
