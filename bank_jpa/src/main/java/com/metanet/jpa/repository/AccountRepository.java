package com.metanet.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.jpa.model.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, String>{
	
}
