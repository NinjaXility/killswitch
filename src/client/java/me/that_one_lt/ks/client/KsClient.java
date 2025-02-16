package me.that_one_lt.ks.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.gui.screen.DisconnectedScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KsClient implements ClientModInitializer {
    private static KeyBinding killSwitchKey;

    @Override
    public void onInitializeClient() {
        // Register the keybindings
        killSwitchKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Kill Switch (Leave Game)",
                GLFW.GLFW_KEY_K,
                "Kill Switch"
        ));
        // Listen for key press actions
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (killSwitchKey.wasPressed()) {
                System.exit(0); // Instantly closes the game
            }
        });
    }
};