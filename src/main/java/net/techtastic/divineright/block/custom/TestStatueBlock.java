package net.techtastic.divineright.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.techtastic.divineright.block.entity.TestStatueBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class TestStatueBlock extends BlockWithEntity implements BlockEntityProvider {
    public TestStatueBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        TestStatueBlockEntity statue = (TestStatueBlockEntity) world.getBlockEntity(pos);
        statue.setWorshipped(placer.getUuid());
        statue.markDirty();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        UUID worshipped = ((TestStatueBlockEntity) world.getBlockEntity(pos)).getWorshipped();
        PlayerEntity worshippedPlayer = world.getPlayerByUuid(worshipped);

        player.sendMessage(Text.of("This is a statue of " + worshippedPlayer.getDisplayName().getString()));

        return ActionResult.SUCCESS;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TestStatueBlockEntity(pos, state);
    }
}
