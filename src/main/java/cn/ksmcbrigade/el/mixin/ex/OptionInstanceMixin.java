package cn.ksmcbrigade.el.mixin.ex;

import cn.ksmcbrigade.el.events.misc.GetOptionValueEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.function.Consumer;

@Mixin(OptionInstance.class)
public class OptionInstanceMixin<T> {

    @Shadow
    T value;

    @Shadow @Final private Consumer<T> onValueUpdate;

    @Shadow @Final private OptionInstance.TooltipSupplier<T> tooltip;

    @Shadow @Final
    Component caption;

    @Inject(method = "set",at = @At("HEAD"),cancellable = true)
    public void set(T p_231515_, CallbackInfo ci){
        ci.cancel();
        if (!Minecraft.getInstance().isRunning()) {
            this.value = p_231515_;
        } else {
            if (!Objects.equals(this.value, p_231515_)) {
                this.value = p_231515_;
                this.onValueUpdate.accept(this.value);
            }
        }
    }

    @Inject(method = "get",at = @At("RETURN"), cancellable = true)
    public void get(CallbackInfoReturnable<T> cir){
        GetOptionValueEvent event = new GetOptionValueEvent(this.value,this.caption.getString());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue((T) event.value);
    }
}
