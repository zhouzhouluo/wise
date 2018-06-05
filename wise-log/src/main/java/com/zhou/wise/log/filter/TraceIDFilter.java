package com.zhou.wise.log.filter;

import com.zhou.wise.common.utils.TraceIDUtils;
import org.slf4j.MDC;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * TokenInvokerFilter
 *
 * @author william.liangf
 */
@Activate()
public class TraceIDFilter implements Filter {
    private static final String TRACE_ID="TRACE_ID";
    public Result invoke(Invoker<?> invoker, Invocation inv)
            throws RpcException {
        if(inv.getAttachment(TRACE_ID)!=null){
            TraceIDUtils.setTraceId(inv.getAttachment(TRACE_ID));
            String mdcData = String.format("[TraceID:%s]", inv.getAttachment(TRACE_ID));
            MDC.put("mdcData", mdcData);
        }else if(TraceIDUtils.getTraceId()!=null){
            inv.getAttachments().put("TRACE_ID", TraceIDUtils.getTraceId());
        }
        return invoker.invoke(inv);
    }
}