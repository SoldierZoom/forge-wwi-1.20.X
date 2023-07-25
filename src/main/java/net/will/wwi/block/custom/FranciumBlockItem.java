package net.will.wwi.block.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.will.wwi.effect.ModEffects;
import net.will.wwi.item.custom.FranciumItemEntity;
import org.jetbrains.annotations.Nullable;

public class FranciumBlockItem extends BlockItem {
    float ExplodeRadius;
    public FranciumBlockItem(float pExplodeRadius,Block pBlock, Item.Properties pProperties) {
        super(pBlock,pProperties);
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
