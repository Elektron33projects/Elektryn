package pl.elektryn;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.ParticleStatus;

/** 1.15 - 1.18.2: ustawienia to zwykle pola. */
public final class OptionsApplier {
    private OptionsApplier() {}

    public static void apply(Options o, Minecraft mc) {
        if (ElektrynConfig.uncapFps) {
            o.framerateLimit = 260;
            o.enableVsync = false;
            mc.getWindow().updateVsync(false);
        }
        if (ElektrynConfig.disableEntityShadows) o.entityShadows = false;
        if (ElektrynConfig.reduceParticles) o.particles = ParticleStatus.DECREASED;
        if (ElektrynConfig.noMipmaps) o.mipmapLevels = 0;
    }
}
