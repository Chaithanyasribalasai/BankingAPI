package com.BankingAPI.BankingAPI.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account_Details")
public class AccountEntity {
	@Id
	@Column(name="Holder_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @Column(name="Account_holdername")
	private String Account_holdername;
    @Column(name="Balance") // mobile number
	private double Balance;
	@Column(name="Address")
    private String Address;
	
	@Column (name="status")
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status ) {
		this.status=status;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccount_holdername() {
		return Account_holdername;
	}
	public void setAccount_holdername(String account_holdername) {
		Account_holdername = account_holdername;
	}
	
	
	
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public AccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountEntity(long id, String account_holdername, double balance, String address, String status) {
		super();
		this.id = id;
		Account_holdername = account_holdername;
		Balance = balance;
		Address = address;
		this.status=status;
	}
	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", Account_holdername=" + Account_holdername + ", Balance=" + Balance
				+ ", Address=" + Address + "]";
	}


	

}
