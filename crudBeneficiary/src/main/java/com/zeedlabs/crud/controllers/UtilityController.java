package com.zeedlabs.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeedlabs.crud.entity.UtilityBeneficiary;
import com.zeedlabs.crud.model.BaseResponse;
import com.zeedlabs.crud.service.UtilityService;


	@RestController
	public class UtilityController {

			@Autowired
			UtilityService utilityService;
			
			@RequestMapping(value="/add-utility",method=RequestMethod.POST)
			public ResponseEntity saveUtility(@RequestBody UtilityBeneficiary utilityRecord) {
				BaseResponse baseResponse= utilityService.savePaymentRecord(utilityRecord);
				return new ResponseEntity<>(baseResponse,HttpStatus.OK);
			}
			
			@RequestMapping(value="/get-utility",method=RequestMethod.GET)
			public ResponseEntity getPaymentById(@RequestParam("paymentId") String paymentId ) {
				BaseResponse baseResponse= utilityService.retrievedRecordById(paymentId);
				return new ResponseEntity<>(baseResponse,HttpStatus.OK);
			}
			@RequestMapping(value="/get-allUtility",method=RequestMethod.GET)
			public ResponseEntity getallPaymentId() {
				BaseResponse baseResponse= utilityService.retrieveAllRecordById();
				return new ResponseEntity<>(baseResponse,HttpStatus.OK);
			}
			@RequestMapping(value="/delete-a-utility/{id}", method=RequestMethod.DELETE)
			public void destroy(@PathVariable("id") Long id) {
		         utilityService.deleteById(id);
		         System.out.println("You have successfully deleted payment with the ID :"+id);
		    }	
		}