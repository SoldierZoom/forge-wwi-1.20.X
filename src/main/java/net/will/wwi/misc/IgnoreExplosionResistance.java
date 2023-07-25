package net.will.wwi.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class IgnoreExplosionResistance extends ExplosionDamageCalculator {
    @Override
    public @NotNull Optional<Float> getBlockExplosionResistance(Explosion pExplosion, BlockGetter pReader, BlockPos pPos, BlockState pState, FluidState pFluid) {
        return Optional.empty();
    }
}
