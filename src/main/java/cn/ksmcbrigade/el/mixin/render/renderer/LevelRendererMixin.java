package cn.ksmcbrigade.el.mixin.render.renderer;

import cn.ksmcbrigade.el.events.render.RenderEntityEvent;
import cn.ksmcbrigade.el.events.render.RenderEntityPreEvent;
import cn.ksmcbrigade.el.events.render.RenderedEntityEvent;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {

    @Unique
    private boolean simpleClientBase$cancel = false;

    @Inject(method = "renderEntity",at = @At("HEAD"),cancellable = true)
    private void render(Entity p_109518_, double p_109519_, double p_109520_, double p_109521_, float p_109522_, PoseStack p_109523_, MultiBufferSource p_109524_, CallbackInfo ci){
        RenderEntityEvent event = new RenderEntityEvent(p_109518_);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()){
            this.simpleClientBase$cancel = true;
            ci.cancel();
        }
        else{
            NeoForge.EVENT_BUS.post(new RenderEntityPreEvent(p_109518_));
        }
    }

    @Inject(method = "renderEntity",at = @At("TAIL"))
    private void rendered(Entity p_109518_, double p_109519_, double p_109520_, double p_109521_, float p_109522_, PoseStack p_109523_, MultiBufferSource p_109524_, CallbackInfo ci){
        if(!simpleClientBase$cancel){
            NeoForge.EVENT_BUS.post(new RenderedEntityEvent(p_109518_));
        }
        simpleClientBase$cancel = false;
    }
}
