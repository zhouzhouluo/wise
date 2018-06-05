package com.zhou.wise.manager.service.impl;

import com.zhou.wise.manager.service.IDeviceManageService;
import com.zhou.wise.pojo.DeviceManage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service
 * @author Administrator
 *
 */
//@Service(value="deviceManageService")
//@Transactional

@com.alibaba.dubbo.config.annotation.Service
@Service
public class DeviceManageServiceImpl extends GenericServiceImpl<DeviceManage, Integer>
		implements IDeviceManageService{

}
