package fr.celyanrbx.coreforge.init;

import fr.celyanrbx.coreforge.client.gui.CrusherGUIScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens {
    @SubscribeEvent
    public static void clientLoad(RegisterMenuScreensEvent event) {
        event.register(ModMenus.CRUSHER_GUI.get(), CrusherGUIScreen::new);
    }
}
