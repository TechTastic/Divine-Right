package net.techtastic.divineright;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.techtastic.divineright.block.entity.ModBlockEntities;
import net.techtastic.divineright.block.model.TestStatueBlockEntityRenderer;

public class DivineRightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlockEntities.TEST_STATUE, TestStatueBlockEntityRenderer::new);
    }
}
