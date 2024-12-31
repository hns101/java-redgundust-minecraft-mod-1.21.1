package net.rubberduck.redgundust.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Interaction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.rubberduck.redgundust.block.ModBlocks;
import net.rubberduck.redgundust.item.ModItems;

import javax.annotation.Nullable;
import java.util.Properties;

public class CustomTNTBlock extends TntBlock {


    public CustomTNTBlock(Properties properties ) {
        super(properties);

    }



    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                               Player pPlayer, BlockHitResult pHitResult) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.REDSTONE_TORCH_BURNOUT, SoundSource.BLOCKS,1f,1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level plevel, BlockPos pPos, BlockState pState, Entity pEntity ) {
        if(pEntity instanceof ItemEntity itemEntity){
            if(itemEntity.getItem().getItem() == ModItems.REDGUNDUST.get()){
             itemEntity.setItem(new ItemStack(ModBlocks.RGD.get(), itemEntity.getItem().getCount()));

            }
        }
        super.stepOn(plevel, pPos, pState, pEntity);
    }




}
