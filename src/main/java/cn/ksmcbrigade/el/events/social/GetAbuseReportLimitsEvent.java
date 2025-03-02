package cn.ksmcbrigade.el.events.social;

import com.mojang.authlib.minecraft.report.AbuseReportLimits;
import net.neoforged.bus.api.Event;

public class GetAbuseReportLimitsEvent extends Event {
    public AbuseReportLimits value;

    public GetAbuseReportLimitsEvent(AbuseReportLimits value){
        this.value = value;
    }
}
