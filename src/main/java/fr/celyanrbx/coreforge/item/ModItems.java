package fr.celyanrbx.coreforge.item;

import fr.celyanrbx.coreforge.Coreforge;
import fr.celyanrbx.coreforge.item.custom.ChiselItem;
import fr.celyanrbx.coreforge.item.custom.HammerItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Coreforge.MOD_ID);

    public static final DeferredItem<Item> STEEL = ITEMS.register("steel",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(100)));

    public static final DeferredItem<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.STEEL, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STEEL, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.STEEL, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.STEEL, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.STEEL, 0F, -3.0f))));
    public static final DeferredItem<HammerItem> STEEL_HAMMER = ITEMS.register("steel_hammer",
            () -> new HammerItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STEEL, 7F, -3.5f))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
