package net.will.wwi.item.custom;



import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FranciumItemEntity extends ItemEntity {
    float ExplodeRadius;
    public FranciumItemEntity(float pExplodeRadius,Level pLevel, double pPosX, double pPosY, double pPosZ, ItemStack pItemStack) {
        super(pLevel, pPosX, pPosY, pPosZ, pItemStack);
        this.ExplodeRadius=pExplodeRadius;
    }
    @Override
    public void tick() {
        super.tick();
        if(this.isInWater()) {
            double[] pos = {this.getX(),this.getY(),this.getZ()};
            //BlockPos bpos = new BlockPos((int)pos[0],(int)pos[0],(int)pos[0]);

            this.discard();
            this.getCommandSenderWorld().explode(null,null,new IgnoreExplosionResistance(),pos[0],pos[1],pos[2],ExplodeRadius,false,Level.ExplosionInteraction.TNT);
        }
    }
}
