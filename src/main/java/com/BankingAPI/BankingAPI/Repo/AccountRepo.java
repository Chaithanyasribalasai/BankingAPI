package com.BankingAPI.BankingAPI.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BankingAPI.BankingAPI.entity.AccountEntity;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Long> {

}
