package pl.elektryn;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;

/** Applies the preset once, when the client starts. */
public final class OptionsApplier {
    private OptionsApplier() {}

    public static void apply(GameOptions options, MinecraftClient client) {
        if (ElektrynConfig.uncapFps) {
            options.getMaxFps().setValue(260);
            options.getEnableVsync().setValue(false);
            client.getWindow().setVsync(false);
        }

        if (ElektrynConfig.disableEntityShadows) {
            options.getEntityShadows().setValue(false);
        }

        if (ElektrynConfig.reduceParticles) {
            // Select the second available enum value when the option is an enum.
            var particleOption = options.getParticles();
            Object current = particleOption.getValue();
            if (current instanceof Enum<?> enumValue) {
                Object[] constants = enumValue.getDeclaringClass().getEnumConstants();
                if (constants != null && constants.length > 1) {
                    @SuppressWarnings({"rawtypes", "unchecked"})
                    var rawOption = (net.minecraft.client.option.SimpleOption) particleOption;
                    rawOption.setValue(constants[1]);
                }
            }
        }

        if (ElektrynConfig.noBiomeBlend) {
            options.getBiomeBlendRadius().setValue(0);
        }

        if (ElektrynConfig.noMipmaps) {
            options.getMipmapLevels().setValue(0);
        }

        // Reduce entity render distance scaling without changing chunk render distance.
        options.getEntityDistanceScaling().setValue(0.75);
    }
}
