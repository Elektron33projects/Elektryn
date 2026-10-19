package pl.elektryn.mixin;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.render.Frustum;
import org.spongepowered.asm.mixin.Coerce;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pl.elektryn.ElektrynConfig;

@Mixin(EntityRenderDispatcher.class)
public abstract class EntityRendererMixin {
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private void elektryn$cull(Entity entity, @Coerce Object frustum,
                               double x, double y, double z,
                               CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof PlayerEntity) return;
        double distance = ElektrynConfig.entityCullDistance;
        if (entity.squaredDistanceTo(x, y, z) > distance * distance) {
            cir.setReturnValue(false);
        }
    }
}
