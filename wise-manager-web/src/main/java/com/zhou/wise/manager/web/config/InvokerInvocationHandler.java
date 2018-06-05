package com.zhou.wise.manager.web.config;

import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcInvocation;
import com.zhou.wise.common.utils.TraceIDUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvokerInvocationHandler implements InvocationHandler {

    private final Invoker<?> invoker;

    public InvokerInvocationHandler(Invoker<?> handler){
        this.invoker = handler;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(invoker, args);
        }
        if ("toString".equals(methodName) && parameterTypes.length == 0) {
            return invoker.toString();
        }
        if ("hashCode".equals(methodName) && parameterTypes.length == 0) {
            return invoker.hashCode();
        }
        if ("equals".equals(methodName) && parameterTypes.length == 1) {
            return invoker.equals(args[0]);
        }
        // 这里将cosumer 端的traceId放入RpcInvocation
        RpcInvocation rpcInvocation = new RpcInvocation(method, args);
        rpcInvocation.setAttachment("traceId", TraceIDUtils.getTraceId());
        return invoker.invoke(rpcInvocation).recreate();
    }

}
