package net.rubberduck.redgundust.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.rubberduck.redgundust.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PrimedRgd extends PrimedTnt {


    public PrimedRgd(Level pLevel, double pX, double pY, double pZ, @Nullable LivingEntity pOwner) {
        super(pLevel, pX, pY, pZ, pOwner);
    }



    private static final EntityDataAccessor<Integer> DATA_FUSE_ID = SynchedEntityData.defineId(PrimedTnt.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<BlockState> DATA_BLOCK_STATE_ID = SynchedEntityData.defineId(PrimedTnt.class, EntityDataSerializers.BLOCK_STATE);
    private static final int DEFAULT_FUSE_TIME = 80;
    private static final String TAG_BLOCK_STATE = "block_state";
    public static final String TAG_FUSE = "fuse";
    private boolean usedPortal;
    private static final ExplosionDamageCalculator USED_PORTAL_DAMAGE_CALCULATOR = new ExplosionDamageCalculator() {
        @Override
        public boolean shouldBlockExplode(Explosion p_345242_, BlockGetter p_343858_, BlockPos p_345073_, BlockState p_343662_, float p_344776_) {
            return p_343662_.is(Blocks.NETHER_PORTAL) ? false : super.shouldBlockExplode(p_345242_, p_343858_, p_345073_, p_343662_, p_344776_);
        }

        @Override
        public Optional<Float> getBlockExplosionResistance(Explosion p_342148_, BlockGetter p_342177_, BlockPos p_342771_, BlockState p_344877_, FluidState p_343569_) {
            return p_344877_.is(Blocks.NETHER_PORTAL) ? Optional.empty() : super.getBlockExplosionResistance(p_342148_, p_342177_, p_342771_, p_344877_, p_343569_);
        }
    };


    @Override
    protected void explode() {
        float f = 26.0F;
        this.level()
                .explode(
                        this,
                        Explosion.getDefaultDamageSource(this.level(), this),
                        this.usedPortal ? USED_PORTAL_DAMAGE_CALCULATOR : null,
                        this.getX(),
                        this.getY(0.825),
                        this.getZ(),
                        16.0F,
                        false,
                        Level.ExplosionInteraction.TNT
                );
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        pBuilder.define(DATA_FUSE_ID, 80);
        pBuilder.define(DATA_BLOCK_STATE_ID, ModBlocks.RGD.get().defaultBlockState());
    }


}
