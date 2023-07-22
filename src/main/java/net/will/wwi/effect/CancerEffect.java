package net.will.wwi.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import java.util.Random;

public class CancerEffect extends MobEffect{
    Random rand = new Random();
    final int upper_bound = 20*3;
    int time;
    //need to keep timer
    protected CancerEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
        time = rand.nextInt(upper_bound+1)+1;
    }
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        time-=1;
        if(time==0) {
            //need to add cancer damage source
            pLivingEntity.kill();
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
