package com.cws.cwswebservice.controllers;

import com.cws.cwswebservice.service.WsService;
import com.cws.cwswebservice.service.impl.Student1ServiceImpl;

import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import com.cws.cwswebservice.dto.Student1;
import com.cws.cwswebservice.service.IStudent1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

    @Controller
    public class Student1Controller extends BaseController{

    @Autowired
    private IStudent1Service service;
    @Autowired
    WsService wsService;


    @RequestMapping(value = "/student/query")
    @ResponseBody
    public ResponseData query( Student1 dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) throws Exception {
        IRequest requestContext = createRequestContext(request);
        Student1 student1=wsService.inAction(requestContext);
        return new ResponseData(service.select(requestContext,dto,page,pageSize));

    }

        @RequestMapping(value = "/api/public/demo/emp/invoke")
        @ResponseBody
        public ResponseData invoke(Student1 dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
            IRequest requestContext = createRequestContext(request);
            ResponseData responseData = new ResponseData();
            List<Student1> student1s = new ArrayList<>();
            Student1 student1 = new Student1();
           // Student1 emp = wsService.selectByPrimaryKey(requestContext, dto);
            try {
                student1 = wsService.inAction(requestContext);
            } catch (Exception e) {
                System.out.println("invoke Error");
            }
            student1s.add(student1);
            //返回请求
            return new ResponseData(student1s);
        }



        @RequestMapping(value = "/student/query1")
        @ResponseBody
        public Student1 query2( Student1 dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) throws Exception {
            IRequest requestContext = createRequestContext(request);
            return wsService.inAction(requestContext);

        }
        @RequestMapping(value = "/api/hand/student/query")
        @ResponseBody
        public ResponseData query1(@RequestBody Student1 dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                  @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
            IRequest requestContext = createRequestContext(request);

            return new ResponseData(service.select(requestContext,dto,page,pageSize));
        }



    @RequestMapping(value = "/api/public/student/submit")
    @ResponseBody
    public ResponseData update(@RequestBody List<Student1> dto, BindingResult result, HttpServletRequest request){
        getValidator().validate(dto, result);
        if (result.hasErrors()) {
        ResponseData responseData = new ResponseData(false);
        responseData.setMessage(getErrorMessage(result, request));
        return responseData;
        }
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/student/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<Student1> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }
    }