package net.techtastic.divineright.block.model;

import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.impl.client.indigo.renderer.helper.TextureHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.texture.TextureStitcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.techtastic.divineright.DivineRight;
import net.techtastic.divineright.block.ModBlocks;
import net.techtastic.divineright.block.entity.TestStatueBlockEntity;

import java.util.UUID;

public class TestStatueBlockEntityRenderer implements BlockEntityRenderer<TestStatueBlockEntity> {
    public TestStatueBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(TestStatueBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        UUID worshipped = entity.getWorshipped();
        PlayerEntity player = world.getPlayerByUuid(worshipped);
        Identifier skin;

        matrices.push();

        if (player != null) {
            skin = ((AbstractClientPlayerEntity) player).getSkinTexture();
        } else {
            skin = new Identifier("divineright:textures/blocks/test_statue.png");
        }

        matrices.pop();
    }
}
