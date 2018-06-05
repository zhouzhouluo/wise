package com.zhou.wise.manager.service.impl;

import com.zhou.wise.manager.service.IRequestLogService;
import com.zhou.wise.pojo.RequestLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service
 * @author Administrator
 *
 */
//@Service(value="requestLogService")
//@Transactional

@com.alibaba.dubbo.config.annotation.Service
@Service
public class RequestLogServiceImpl extends GenericServiceImpl<RequestLog, Integer>
		implements IRequestLogService {

}
