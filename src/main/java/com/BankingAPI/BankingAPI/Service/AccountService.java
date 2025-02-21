package com.BankingAPI.BankingAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.BankingAPI.BankingAPI.Repo.AccountRepo;
import com.BankingAPI.BankingAPI.entity.AccountEntity;

@Service
public class AccountService {
	@Autowired
	
	private AccountRepo repo;
	
	public AccountEntity senddata(AccountEntity a) {
		return repo.save(a);
	}
	public List<AccountEntity> thisukura () {
		return repo.findAll();
	}


	public Optional <AccountEntity> update(Long id) {
		
		return repo.findById(id);
	}

	public AccountEntity diposit(AccountEntity acconutEntity) {
		
		return repo.save(acconutEntity);
	}
	
public Optional <AccountEntity> find(Long id) {
		
		return repo.findById(id);
	}
	
	
	public AccountEntity delete(AccountEntity a) {
		
		return repo.save(a);
	}
	public Optional<AccountEntity> findById(Long id) {
	
		return repo.findById(id);
	}
	
	
	
	
	
	
	
	
	
}
