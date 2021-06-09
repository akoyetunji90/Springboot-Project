package com.zeedlabs.crud.service;

	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeedlabs.crud.entity.UtilityBeneficiary;
import com.zeedlabs.crud.model.BaseResponse;
import com.zeedlabs.crud.repository.UtilityRepo;

	@Service
	public class UtilityService {
		@Autowired
		UtilityRepo utilityRepo;

		public BaseResponse savePaymentRecord(UtilityBeneficiary utilityRecord) {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setStatus(400);
			baseResponse.setDescription("An error occured");
			try {
				Long recordId = utilityRepo.save(utilityRecord).getId();
				baseResponse.setStatus(200);
				baseResponse.setDescription("Your record has been saved successfully with the Id " + recordId);
				baseResponse.setData(utilityRecord);
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
				Optional<UtilityBeneficiary> optPayment =utilityRepo.findById(Long.valueOf(userId));

				if (!optPayment.isPresent()) {
					baseResponse.setStatus(400);
					baseResponse.setDescription("Payment record not found");
					return baseResponse;

				}
				UtilityBeneficiary utilityRecord = optPayment.get();
				baseResponse.setStatus(200);
				baseResponse.setDescription("Successful");
				baseResponse.setData(utilityRecord);

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
				List<UtilityBeneficiary> transferRecord = utilityRepo.findAll();
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
			utilityRepo.deleteById(id);

		}
	}
