package fr.celyanrbx.coreforge.item;

import fr.celyanrbx.coreforge.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier STEEL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL,
            1400, 4f, 3f, 28, () -> Ingredient.of(ModItems.STEEL));
}
