package net.techtastic.divineright.block.entity;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class TestStatueBlockEntity extends BlockEntity {
    private UUID worshipped = UUID.randomUUID();

    public TestStatueBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TEST_STATUE, pos, state);
    }

    public void setWorshipped(UUID uuid) {
        this.worshipped = uuid;
    }

    public UUID getWorshipped() {
        return this.worshipped;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        worshipped = nbt.getUuid("worshipped");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);

        nbt.putUuid("worshipped", worshipped);
    }
}
