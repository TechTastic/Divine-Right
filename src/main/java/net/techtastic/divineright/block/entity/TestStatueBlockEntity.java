package net.techtastic.divineright.block.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class TestStatueBlockEntity extends BlockEntity {
    private GameProfile worshipped = new GameProfile((UUID) null, "none");

    public TestStatueBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TEST_STATUE, pos, state);
    }

    public void setWorshipped(GameProfile profile) {
        this.worshipped = profile;
    }

    public GameProfile getWorshipped() {
        return this.worshipped;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        if (nbt.contains("DivineRight$Worshipped")) {
            this.setWorshipped(NbtHelper.toGameProfile(nbt.getCompound("DivineRight$Worshipped")));
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);

        NbtCompound profile = new NbtCompound();
        NbtHelper.writeGameProfile(profile, this.worshipped);
        nbt.put("DivineRight$Worshipped", profile);
    }
}
