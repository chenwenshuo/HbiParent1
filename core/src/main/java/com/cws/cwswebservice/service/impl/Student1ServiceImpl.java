package com.cws.cwswebservice.service.impl;


import com.hand.hap.system.service.impl.BaseServiceImpl;

import com.cws.cwswebservice.dto.Student1;
import com.cws.cwswebservice.service.IStudent1Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class Student1ServiceImpl extends BaseServiceImpl<Student1> implements IStudent1Service{



}