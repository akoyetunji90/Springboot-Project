package com.zeedlabs.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zeedlabs.crud.entity.UtilityBeneficiary;
	
		public interface UtilityRepo extends CrudRepository<UtilityBeneficiary,Long>{
		List<UtilityBeneficiary> findAll();

	}

