package com.zhou.wise.manager.service.impl;

//import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.zhou.wise.common.utils.TraceIDUtils;
import com.zhou.wise.manager.service.IPackageVersionService;
import com.zhou.wise.pojo.PackageVersion;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Service
 *
 * @author Administrator
 */
//@Service("packageVersionService")
//@Service(version="1.0.0")
//@Transactional
//@Component

@com.alibaba.dubbo.config.annotation.Service()
@Service
public class PackageVersionServiceImpl extends GenericServiceImpl<PackageVersion, Integer>
        implements IPackageVersionService {

    @Override
    public PackageVersion findLastVersion(Map<String, String> map) {

        String traceID = TraceIDUtils.getTraceId();
        System.out.println("uuidID1111111111111111111:"+traceID);

        String uuidStr = RpcContext.getContext().getAttachment("TRACE_ID");

        System.out.println("uuidStr:"+uuidStr);

        PackageVersion packageVersion = findByParam("selectByStatus_1", map);

        return packageVersion;
    }
}
