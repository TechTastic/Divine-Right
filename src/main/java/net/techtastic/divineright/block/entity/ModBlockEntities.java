package net.techtastic.divineright.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.techtastic.divineright.DivineRight;
import net.techtastic.divineright.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<TestStatueBlockEntity> TEST_STATUE;

    public static void registerBlockEntities() {
        TEST_STATUE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(DivineRight.MOD_ID, "test_statue"),
                FabricBlockEntityTypeBuilder.create(TestStatueBlockEntity::new,
                        ModBlocks.TEST_STATUE).build(null));
    }
}
