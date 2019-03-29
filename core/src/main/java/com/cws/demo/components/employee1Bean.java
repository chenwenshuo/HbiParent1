package com.cws.demo.components;


import com.cws.demo.dto.Employee1;
import com.cws.demo.mapper.Employee1Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class employee1Bean {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    Employee1Mapper  mapper;
    public List<Employee1> loadeEmployee1Data(String dsName,
                                             String datasetName, Map<String, Object> parameters) {
        Employee1 criteria = new Employee1();
       criteria.setName((String)parameters.get("name"));
        String name=criteria.getName();
        System.out.println(name);
        System.out.println(criteria);
        if (name==null||name==""){
            return  mapper.selectAll();

        }
        else
            return mapper.select(criteria);

}}



