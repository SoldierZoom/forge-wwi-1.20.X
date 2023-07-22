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
    float ExplodeRadius;
    public FranciumItem(float pExplodeRadius,Properties pProperties) {
        super(pProperties);
        this.ExplodeRadius=pExplodeRadius;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        LivingEntity entity = (LivingEntity) pEntity;
        entity.addEffect(new MobEffectInstance(ModEffects.CANCER.get(),60,99,false,false,false));
    }

    @Override
    public @Nullable Entity createEntity(Level level, Entity location, ItemStack stack) {
        //need to get player var
        final float distance = 1.5f;
        double dx = location.getX() + location.getLookAngle().x()*distance;
        double dy = location.getY() + location.getEyeHeight();
        double dz = location.getZ() + location.getLookAngle().y()*distance;

        return (new FranciumItemEntity(ExplodeRadius,level,dx,dy,dz,stack));
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }
}
