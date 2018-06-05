package com.zhou.wise.manager.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.zhou.wise.common.utils.TraceIDUtils;
import com.zhou.wise.manager.service.IDeviceManageService;
import com.zhou.wise.manager.service.IPackageVersionService;
import com.zhou.wise.pojo.DeviceManage;
import com.zhou.wise.pojo.PackageVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/test")
public class testController {

    @Reference
    IPackageVersionService packageVersionService;

    @Reference
    IDeviceManageService deviceManageService;

    @RequestMapping("/a")
//    @ResponseBody
    public PackageVersion a(String name) {

        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        System.out.println("uuidStr啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊:" + uuidStr);

        TraceIDUtils.setTraceId(uuidStr);

        System.out.println("gift consumer traceId：" + TraceIDUtils.getTraceId());


        RpcContext.getContext().setAttachment("TRACE_ID", uuidStr);

        DeviceManage deviceManage = deviceManageService.findByParam("selectByPrimaryKey", 1);

        System.out.println("deviceManage-------------------------------:" + deviceManage);

        System.out.println("hello-------------------------------:" + name);

        Map<String, String> map = new HashMap<>();
        map.put("hVender", "default");
        map.put("hModel", "default");

        PackageVersion packageVersion = packageVersionService.findLastVersion(map);

//        PackageVersion packageVersion = packageVersionService.findByParam("selectByStatus_1", map);
        packageVersion.sethPackageurl("");
        System.out.println("packageVersion=" + packageVersion);
        System.out.println("packageVersion.gethPackagename()=" + packageVersion.gethPackagename());
        return packageVersion;
    }

}
