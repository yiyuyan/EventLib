package cn.ksmcbrigade.el.mixin.misc;

import cn.ksmcbrigade.el.events.misc.ApplyClientBrandEvent;
import net.minecraft.client.ClientBrandRetriever;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientBrandRetriever.class)
public class ClientBrandMixin {
    @Inject(method = "getClientModName",at = @At("RETURN"),cancellable = true)
    private static void brand(CallbackInfoReturnable<String> cir){
        ApplyClientBrandEvent event = new ApplyClientBrandEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }
}
