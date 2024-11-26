package fr.celyanrbx.coreforge.init;

import fr.celyanrbx.coreforge.Coreforge;
import fr.celyanrbx.coreforge.world.inventory.CrusherGUIMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENU = DeferredRegister.create(Registries.MENU, Coreforge.MOD_ID);
    public static final DeferredHolder<MenuType<?>, MenuType<CrusherGUIMenu>> CRUSHER_GUI = MENU.register("crusher_gui", () -> IMenuTypeExtension.create(CrusherGUIMenu::new));

    public static void register(IEventBus eventBus) {
        MENU.register(eventBus);
    }
}
