package net.will.wwi.item.custom;



import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FranciumItemEntity extends ItemEntity {

    public FranciumItemEntity(Level pLevel, double pPosX, double pPosY, double pPosZ, ItemStack pItemStack) {
        super(pLevel, pPosX, pPosY, pPosZ, pItemStack);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.isInWater()) {
            double[] pos = {this.getX(),this.getY(),this.getZ()};
            this.discard();
            this.getCommandSenderWorld().explode(null,pos[0],pos[1],pos[2],5f,Level.ExplosionInteraction.TNT);
        }
    }
}
