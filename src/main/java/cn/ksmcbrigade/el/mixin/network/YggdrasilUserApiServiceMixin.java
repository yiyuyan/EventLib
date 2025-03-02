package cn.ksmcbrigade.el.mixin.network;

import cn.ksmcbrigade.el.events.social.*;
import com.mojang.authlib.minecraft.report.AbuseReportLimits;
import com.mojang.authlib.yggdrasil.YggdrasilUserApiService;
import com.mojang.authlib.yggdrasil.request.AbuseReportRequest;
import com.mojang.authlib.yggdrasil.response.KeyPairResponse;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(YggdrasilUserApiService.class)
public class YggdrasilUserApiServiceMixin {
    @Inject(method = "isBlockedPlayer",at = @At("RETURN"),cancellable = true)
    public void isBlocked(UUID playerID, CallbackInfoReturnable<Boolean> cir){
        BlockedPlayerEvent event = new BlockedPlayerEvent(playerID,cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }

    @Inject(method = "canSendReports",at = @At("RETURN"),cancellable = true)
    public void canSendReports(CallbackInfoReturnable<Boolean> cir){
        CanSendReportsEvent event = new CanSendReportsEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }

    @Inject(method = "reportAbuse",at = @At("HEAD"),cancellable = true)
    public void reporting(AbuseReportRequest request, CallbackInfo ci){
        ReportingAbuseEvent event = new ReportingAbuseEvent(request);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }

    @Inject(method = "getAbuseReportLimits",at = @At("RETURN"),cancellable = true)
    public void getAbuseReportLimits(CallbackInfoReturnable<AbuseReportLimits> cir){
        GetAbuseReportLimitsEvent event = new GetAbuseReportLimitsEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }

    @Inject(method = "getKeyPair",at = @At("RETURN"),cancellable = true)
    public void getKeyPairs(CallbackInfoReturnable<KeyPairResponse> cir){
        GetKeyPairEvent event = new GetKeyPairEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }
}
