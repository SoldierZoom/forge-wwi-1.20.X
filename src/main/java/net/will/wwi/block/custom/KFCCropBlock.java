package net.will.wwi.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.will.wwi.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class KFCCropBlock extends CropBlock {
    static final int MAX_AGE = 11;
    public static final IntegerProperty AGE = IntegerProperty.create("age",0,MAX_AGE);
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};;

    public KFCCropBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return ModItems.KFC_BUCKET_SEEDS.get();
    }

    @Override
    protected @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_AGE[this.getAge(pState)];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }
}
