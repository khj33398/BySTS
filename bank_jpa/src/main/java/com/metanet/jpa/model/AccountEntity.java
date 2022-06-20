package com.metanet.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.metanet.jpa.dto.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name="ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {
	@Id //primary key
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Integer balance;
	
	public static AccountEntity createEntity(Account acc) {
		AccountEntity entity = new AccountEntity();
		entity.id = acc.getId();
		entity.name = acc.getName();
		entity.balance = acc.getBalance();
		return entity;
	}
	
	public static Account createDto(AccountEntity entity) {
		Account dto = new Account();
		dto.setId(entity.id);
		dto.setName(entity.name);
		dto.setBalance(entity.balance);
		return dto;
	}
}
