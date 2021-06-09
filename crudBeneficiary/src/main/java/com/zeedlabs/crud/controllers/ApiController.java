package com.zeedlabs.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeedlabs.crud.model.BaseResponse;
import com.zeedlabs.crud.service.ApiService;

@RestController
public class ApiController {
    @Autowired
    ApiService apiService; 
    
    @RequestMapping(value = "/template/products")
	   public BaseResponse getApi() {
		   BaseResponse baseResponse = apiService.getProductList();
		   return baseResponse;
	   } 
}
