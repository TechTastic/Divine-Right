package net.techtastic.divineright.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CustomItem extends Item {
    public CustomItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack original = user.getStackInHand(hand);
        ItemStack prize = new ItemStack(Items.DIAMOND);

        original.decrement(1);
        user.giveItemStack(prize);

        return super.use(world, user, hand);
    }
}
