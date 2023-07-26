package net.will.wwi.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.will.wwi.wwi;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, wwi.MOD_ID);

    public static final RegistryObject<MobEffect> CANCER = MOB_EFFECTS.register("cancer",
            () -> new CancerEffect(MobEffectCategory.HARMFUL,0));
    public static final RegistryObject<MobEffect> RADIOACTIVE_POISONING = MOB_EFFECTS.register("radioactive_poisoning",
            () -> new RadioactivePoisoningEffect(MobEffectCategory.HARMFUL,0));
    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
