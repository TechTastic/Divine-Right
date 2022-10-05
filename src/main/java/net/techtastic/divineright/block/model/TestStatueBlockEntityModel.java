package net.techtastic.divineright.block.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.client.Model;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public abstract class TestStatueBlockEntityModel extends Model {
    public TestStatueBlockEntityModel() {
        super(RenderLayer::getEntityTranslucent);
    }
}
