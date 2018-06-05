package com.zhou.wise.common.filter;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.zhou.wise.common.utils.TraceIDUtils;
import org.slf4j.MDC;

/**
 *
 */
//@Activate
public class TraceIDFilter implements Filter {
    private static final String TRACE_ID = "TRACE_ID";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation inv)
            throws RpcException {
        if (inv.getAttachment(TRACE_ID) != null) {
            TraceIDUtils.setTraceId(inv.getAttachment(TRACE_ID));
            String mdcData = String.format("[TraceID:%s]", inv.getAttachment(TRACE_ID));
            MDC.put("mdcData", mdcData);
        } else if (TraceIDUtils.getTraceId() != null) {
            inv.getAttachments().put("TRACE_ID", TraceIDUtils.getTraceId());
        }
        return invoker.invoke(inv);
    }
}