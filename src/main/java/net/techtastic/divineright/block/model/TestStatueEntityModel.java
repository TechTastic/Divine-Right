package net.techtastic.divineright.block.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class TestStatueEntityModel extends TestStatueBlockEntityModel{
    private final ModelPart root;

    public TestStatueEntityModel(ModelPart root) {
        this.root = root;
    }

    public static ModelData getModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        return modelData;
    }

    public static TexturedModelData getHeadTexturedModelData() {
        ModelData modelData = getModelData();
        ModelPartData modelPartData = modelData.getRoot();
        return TexturedModelData.of(modelData, 64, 64);
    }

    public static TexturedModelData getSkullTexturedModelData() {
        ModelData modelData = getModelData();
        return TexturedModelData.of(modelData, 64, 32);
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
