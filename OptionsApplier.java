package pl.elektryn;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;

/** 1.14.x: tylko najbardziej podstawowe ustawienia. */
public final class OptionsApplier {
    private OptionsApplier() {}

    public static void apply(Options o, Minecraft mc) {
        if (ElektrynConfig.uncapFps) {
            o.framerateLimit = 260;
            o.enableVsync = false;
        }
        if (ElektrynConfig.disableEntityShadows) o.entityShadows = false;
    }
}
