package com.zhou.wise.manager.service.impl;

import com.zhou.wise.manager.service.ISystemRoleService;
import com.zhou.wise.pojo.SystemRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service
 * @author Administrator
 *
 */
//@Service(value="systemRoleService")
//@Transactional
@com.alibaba.dubbo.config.annotation.Service
@Service
public class SystemRoleServiceImpl extends GenericServiceImpl<SystemRole, Integer>
		implements ISystemRoleService {

}
