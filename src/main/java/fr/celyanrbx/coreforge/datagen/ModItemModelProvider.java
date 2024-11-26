package fr.celyanrbx.coreforge.datagen;

import fr.celyanrbx.coreforge.Coreforge;
import fr.celyanrbx.coreforge.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Coreforge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STEEL.get());
        basicItem(ModItems.CHISEL.get());

        handheldItem(ModItems.STEEL_SWORD);
        handheldItem(ModItems.STEEL_PICKAXE);
        handheldItem(ModItems.STEEL_SHOVEL);
        handheldItem(ModItems.STEEL_AXE);
        handheldItem(ModItems.STEEL_HOE);
        handheldItem(ModItems.STEEL_HAMMER);
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Coreforge.MOD_ID,"item/" + item.getId().getPath()));
    }
}
