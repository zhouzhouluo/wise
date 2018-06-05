package com.zhou.wise.manager.service;

import com.zhou.wise.pojo.SystemResource;
import com.zhou.wise.pojo.Tree;

import java.util.List;


/**
 * 
 * @author Administrator
 *
 */
public interface ISystemResourceService extends IGenericService<SystemResource, Integer> {

	List<Tree> findAllTree();

	List<Tree> findAllTrees();

	List<SystemResource> findResourceUrlListByRoleId(Integer roleId);
	
}
