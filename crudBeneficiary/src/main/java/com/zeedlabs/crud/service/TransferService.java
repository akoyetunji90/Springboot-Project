package com.zeedlabs.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeedlabs.crud.entity.LocalTransfer;
import com.zeedlabs.crud.model.BaseResponse;
import com.zeedlabs.crud.repository.TransferRepo;

@Service
public class TransferService {
	@Autowired
	TransferRepo transferRepo;

	public BaseResponse savePaymentRecord(LocalTransfer transferRecord) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(400);
		baseResponse.setDescription("An error occured");
		try {
			Long recordId = transferRepo.save(transferRecord).getId();
			baseResponse.setStatus(200);
			baseResponse.setDescription("Your record has been saved successfully with the Id " + recordId);
			baseResponse.setData(transferRecord);
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return baseResponse;

	}

	public BaseResponse retrievedRecordById(String userId) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(400);
		baseResponse.setDescription("An error occured");
		try {
			Optional<LocalTransfer> optPayment = transferRepo.findById(Long.valueOf(userId));

			if (!optPayment.isPresent()) {
				baseResponse.setStatus(400);
				baseResponse.setDescription("Payment record not found");
				return baseResponse;

			}
			LocalTransfer transferRecord = optPayment.get();
			baseResponse.setStatus(200);
			baseResponse.setDescription("Successful");
			baseResponse.setData(transferRecord);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return baseResponse;

	}

	public BaseResponse retrieveAllRecordById() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(400);
		baseResponse.setDescription("An error occured");
		try {
			List<LocalTransfer> transferRecord = transferRepo.findAll();
			if (transferRecord.isEmpty()) {
				baseResponse.setStatus(400);
				baseResponse.setDescription("No record to display!");
				return baseResponse;
			}

			baseResponse.setStatus(200);
			baseResponse.setDescription("Successful");
			baseResponse.setData(transferRecord);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResponse;
	}

	public void deleteById(Long id) {
		transferRepo.deleteById(id);

	}

}
