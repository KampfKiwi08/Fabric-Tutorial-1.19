package net.kiwi.tutorialmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallItem extends Item {
    public EightBallItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            //output a random number
            outputRandomNuber(user);
            //add a cooldown
            user.getItemCooldownManager().set(this, 20);
        }

        return super.use(world, user, hand);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Right Click to get a random number from 0 to 9").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.literal("Press shift for more info").formatted(Formatting.YELLOW));
        }


        super.appendTooltip(stack, world, tooltip, context);
    }

    private void outputRandomNuber(PlayerEntity player){
        player.sendMessage(Text.literal("Your Number is "+ getRandomNuber()));
    }

    private int getRandomNuber() {
        return Random.createLocal().nextInt(10);
    }

}
