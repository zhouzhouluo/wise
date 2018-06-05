package com.zhou.wise.manager.service;

import com.zhou.wise.pojo.PackageVersion;

import java.util.Map;


/**
 * 
 * @author Administrator
 *
 */
public interface IPackageVersionService extends IGenericService<PackageVersion, Integer> {


    PackageVersion findLastVersion(Map<String,String> map);


}
