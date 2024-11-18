package fr.celyanrbx.coreforge.datagen;

import fr.celyanrbx.coreforge.Coreforge;
import fr.celyanrbx.coreforge.item.ModItems;
import fr.celyanrbx.coreforge.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Coreforge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.STEEL.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.SWORDS)
                .add(ModItems.STEEL_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.STEEL_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.STEEL_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(ModItems.STEEL_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.STEEL_HOE.get());
    }
}
