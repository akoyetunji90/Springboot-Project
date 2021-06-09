package com.zeedlabs.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zeedlabs.crud.entity.LocalTransfer;
	
		public interface TransferRepo extends CrudRepository<LocalTransfer,Long>{
		List<LocalTransfer> findAll();

	}

