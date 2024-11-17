package fr.celyanrbx.coreforge.item;

import fr.celyanrbx.coreforge.Coreforge;
import fr.celyanrbx.coreforge.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Coreforge.MOD_ID);

    public static final Supplier<CreativeModeTab> STEEL_ITEMS_TAB = CREATIVE_MODE_TAB.register("steel_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL.get()))
                    .title(Component.translatable("creativetab.coreforge.steel_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.STEEL);
                    }).build());

    public static final Supplier<CreativeModeTab> STEEL_BLOCK_TAB = CREATIVE_MODE_TAB.register("steel_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STEEL_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Coreforge.MOD_ID, "steel_items_tab"))
                    .title(Component.translatable("creativetab.coreforge.steel_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.STEEL_BLOCK);
                        output.accept(ModBlocks.RAW_STEEL_BLOCK);
                        output.accept(ModBlocks.STEEL_ORE);
                        output.accept(ModBlocks.DEEPSLATE_STEEL_ORE);
                        output.accept(ModBlocks.END_STEEL_ORE);
                        output.accept(ModBlocks.NETHER_STEEL_ORE);


                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
