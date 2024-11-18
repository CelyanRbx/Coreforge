package fr.celyanrbx.coreforge.datagen;

import fr.celyanrbx.coreforge.Coreforge;
import fr.celyanrbx.coreforge.block.ModBlocks;
import fr.celyanrbx.coreforge.block.custom.SteelLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Coreforge.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.STEEL_BLOCK);

        blockWithItem(ModBlocks.STEEL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_STEEL_ORE);
        blockWithItem(ModBlocks.END_STEEL_ORE);
        blockWithItem(ModBlocks.NETHER_STEEL_ORE);

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.STEEL_LAMP.get()).forAllStates(state -> {
            if(state.getValue(SteelLampBlock.LIT)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("steel_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(Coreforge.MOD_ID, "block/" + "steel_lamp_on")))};
            } else {
                    return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("steel_lamp_off",
                            ResourceLocation.fromNamespaceAndPath(Coreforge.MOD_ID, "block/" + "steel_lamp_off")))};
                }
            });

        simpleBlockItem(ModBlocks.STEEL_LAMP.get(), models().cubeAll("steel_lamp_on",
                ResourceLocation.fromNamespaceAndPath(Coreforge.MOD_ID, "block/" + "steel_lamp_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("coreforge:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("coreforge:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
