package fr.celyanrbx.coreforge.init;

import fr.celyanrbx.coreforge.Coreforge;
import fr.celyanrbx.coreforge.block.ModBlocks;
import fr.celyanrbx.coreforge.block.entity.CrusherBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<BlockEntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Coreforge.MOD_ID);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> CRUSHER = register("crusher", ModBlocks.CRUSHER, CrusherBlockEntity::new);

    private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
        return ENTITIES.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CRUSHER.get(), (blockEntity, side) -> ((CrusherBlockEntity) blockEntity).getItemHandler());
    }

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}


