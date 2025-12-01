package com.dragn0007.deadlydinos.mixin;

import com.dragn0007.deadlydinos.entities.velociraptor.VelociraptorOnShoulderLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerRenderer.class)
public abstract class PlayerRendererMixin {

    @Inject(method = "<init>", at = @At("RETURN"))
    private void addCustomShoulderLayer(EntityRendererProvider.Context ctx, boolean slim, CallbackInfo ci) {
        PlayerRenderer self = (PlayerRenderer) (Object) this;
        self.addLayer(new VelociraptorOnShoulderLayer<>(self, ctx));
    }
}
