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

import com.zeedlabs.crud.entity.LocalTransfer;
import com.zeedlabs.crud.model.BaseResponse;
import com.zeedlabs.crud.service.TransferService;

@RestController
public class TransferController {

		@Autowired
		TransferService transferService;
		
		@RequestMapping(value="/add-payment",method=RequestMethod.POST)
		public ResponseEntity savePayment(@RequestBody LocalTransfer transferRecord) {
			BaseResponse baseResponse= transferService.savePaymentRecord(transferRecord);
			return new ResponseEntity<>(baseResponse,HttpStatus.OK);
		}
		
		@RequestMapping(value="/get-payment",method=RequestMethod.GET)
		public ResponseEntity getPaymentById(@RequestParam("paymentId") String paymentId ) {
			BaseResponse baseResponse= transferService.retrievedRecordById(paymentId);
			return new ResponseEntity<>(baseResponse,HttpStatus.OK);
		}
		@RequestMapping(value="/get-allPayments",method=RequestMethod.GET)
		public ResponseEntity getallPaymentId() {
			BaseResponse baseResponse= transferService.retrieveAllRecordById();
			return new ResponseEntity<>(baseResponse,HttpStatus.OK);
		}
		@RequestMapping(value="/delete-a-payment/{id}", method=RequestMethod.DELETE)
		public void destroy(@PathVariable("id") Long id) {
	         transferService.deleteById(id);
	         System.out.println("You have successfully deleted payment with the ID :"+id);
	    }	
	}
