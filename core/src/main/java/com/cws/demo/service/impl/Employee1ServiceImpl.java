package com.cws.demo.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.cws.demo.dto.Employee1;
import com.cws.demo.service.IEmployee1Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class Employee1ServiceImpl extends BaseServiceImpl<Employee1> implements IEmployee1Service{

}