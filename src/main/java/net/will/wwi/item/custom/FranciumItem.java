package net.will.wwi.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
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
        entity.addEffect(new MobEffectInstance(ModEffects.CANCER.get(),60,0,false,false,false));
        entity.addEffect(new MobEffectInstance(ModEffects.RADIOACTIVE_POISONING.get(),60,0));
    }
    @Override
    public @Nullable Entity createEntity(Level level, Entity location, ItemStack stack) {
        Entity player = ((ItemEntity) location).getOwner();
        final float distance = 1.5f;
        double dx,dy,dz;

        if (player!=null) {
            dx = player.getX() + player.getLookAngle().x()*distance;
            dy = player.getY() + player.getEyeHeight();
            dz = player.getZ() + player.getLookAngle().z()*distance;
        } else {
            dx = location.getX();
            dy = location.getY();
            dz = location.getZ();
        }
        FranciumItemEntity item_entity=new FranciumItemEntity(ExplodeRadius,level,dx,dy,dz,stack);
        item_entity.setPickUpDelay(30);

        return (item_entity);
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }
}
