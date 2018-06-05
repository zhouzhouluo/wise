package com.zhou.wise.manager.service.impl;

import com.zhou.wise.manager.service.ISystemUserService;
import com.zhou.wise.pojo.SystemUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 意见反馈Service
 * @author Administrator
 *
 */
//@Service(value="systemUserService")
//@Transactional
@com.alibaba.dubbo.config.annotation.Service
@Service
public class SystemUserServiceImpl extends GenericServiceImpl<SystemUser, Integer>
		implements ISystemUserService {

}
