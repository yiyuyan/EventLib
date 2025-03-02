package cn.ksmcbrigade.el.events.social;

import com.mojang.authlib.yggdrasil.request.AbuseReportRequest;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class ReportingAbuseEvent extends Event implements ICancellableEvent {
    public AbuseReportRequest value;

    public ReportingAbuseEvent(AbuseReportRequest value){
        this.value = value;
    }
}
