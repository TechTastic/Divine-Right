package net.techtastic.divineright.block.model;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.dynamic.DynamicSerializableUuid;
import net.techtastic.divineright.block.entity.TestStatueBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class TestStatueBlockEntityRenderer implements BlockEntityRenderer<TestStatueBlockEntity> {
    private final TestStatueEntityModel model;

    public TestStatueBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.model = new TestStatueEntityModel(ctx.getLayerRenderDispatcher().getModelPart(EntityModelLayers.PLAYER));
    }

    @Override
    public void render(TestStatueBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        GameProfile player = entity.getWorshipped();
        RenderLayer skin;

        if (player != null) {
            skin = getRenderLayer(player);
        } else {
            skin = RenderLayer.getEntityCutoutNoCull(DefaultSkinHelper.getTexture(DynamicSerializableUuid.getUuidFromProfile(player)));
        }

        matrices.push();

        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(skin);
        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();
    }

    public static RenderLayer getRenderLayer(@Nullable GameProfile profile) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = minecraftClient.getSkinProvider().getTextures(profile);

        if (map.containsKey(com.mojang.authlib.minecraft.MinecraftProfileTexture.Type.SKIN)) {
            return RenderLayer.getEntityTranslucent(minecraftClient.getSkinProvider().loadSkin((MinecraftProfileTexture)map.get(com.mojang.authlib.minecraft.MinecraftProfileTexture.Type.SKIN),
                    com.mojang.authlib.minecraft.MinecraftProfileTexture.Type.SKIN));
        } else {
            return RenderLayer.getEntityCutoutNoCull(DefaultSkinHelper.getTexture(DynamicSerializableUuid.getUuidFromProfile(profile)));
        }
    }
}
