package pl.elektryn.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pl.elektryn.OptionsApplier;

import java.nio.file.Files;
import java.nio.file.Path;

@Mixin(MinecraftClient.class)
public abstract class MinecraftMixin {
    @Shadow @Final public GameOptions options;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void elektryn$init(CallbackInfo ci) {
        Path flag = FabricLoader.getInstance().getConfigDir().resolve("elektryn-applied.flag");
        try {
            if (Files.exists(flag)) return;
            OptionsApplier.apply(options, (MinecraftClient) (Object) this);
            options.write();
            Files.write(flag, new byte[0]);
        } catch (Throwable t) {
            System.err.println("[Elektryn] Failed to apply settings: " + t);
        }
    }
}
