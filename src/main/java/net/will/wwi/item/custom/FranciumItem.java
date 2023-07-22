package net.will.wwi.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.will.wwi.effect.ModEffects;
import org.jetbrains.annotations.Nullable;

public class FranciumItem extends Item {
    public FranciumItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        LivingEntity entity = (LivingEntity) pEntity;
        entity.addEffect(new MobEffectInstance(ModEffects.CANCER.get(),60,99,false,false,false));
    }

    @Override
    public @Nullable Entity createEntity(Level level, Entity location, ItemStack stack) {
        return (new FranciumItemEntity(level,location.getX(),location.getY(),location.getZ(),stack));
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }
}
