package com.zhou.wise.manager.service;


import com.zhou.wise.pojo.SystemRoleResource;

import java.util.List;


/**
 * 
 * @author Administrator
 *
 */
public interface ISystemRoleResourceService extends IGenericService<SystemRoleResource, Integer> {
	
	void updateRoleResource(Integer id, String resourceIds);

	List<Integer> getRoleResourceIdListByRoleId(Integer id);
	
}
