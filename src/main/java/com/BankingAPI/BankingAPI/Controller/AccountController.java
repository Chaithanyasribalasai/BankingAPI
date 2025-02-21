package com.BankingAPI.BankingAPI.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankingAPI.BankingAPI.Exception.ResourceNotFoundException;
import com.BankingAPI.BankingAPI.Service.AccountService;
import com.BankingAPI.BankingAPI.entity.AccountEntity;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

	@Autowired
	private AccountService service;

	//Add account REST API
	
	@PostMapping("/AccountOpening")
	
	public AccountEntity send(@RequestBody AccountEntity a) {
		return service.senddata(a);
	}
	//Get Account REST API 
	
	@GetMapping("/AllAccount")
	 public ResponseEntity<List<AccountEntity>> thisukura() {
	        List<AccountEntity> accounts = service.thisukura();
	        return new ResponseEntity<>(accounts, HttpStatus.OK);
	}
	
	//FindById REST API
	
	@GetMapping("/account/{id}")
	
	public ResponseEntity<AccountEntity> getAccountById(@PathVariable(value = "id") Long id) 
			throws ResourceNotFoundException
	{
	AccountEntity accountEntity = service.update(id).
			orElseThrow(()->new ResourceNotFoundException("Account not found  :: " + id)); 
	return ResponseEntity.ok().body(accountEntity);
	}
	
	
	//Diposit REST API 
	@PutMapping("/{id}/Diposit")
	public AccountEntity updateStudent(@PathVariable(value="id") Long id, @RequestBody AccountEntity acconut) 
			throws ResourceNotFoundException {
		AccountEntity existingAccount = service.find(id)
				.orElseThrow(()->new ResourceNotFoundException("Account not found  :: " + id)); 
		double totalAmmount=acconut.getBalance();
		existingAccount.setBalance((existingAccount.getBalance() + totalAmmount));
		return service.diposit(existingAccount); 
	}
	
	
	@PutMapping("/{id}/inactive")
	
	public AccountEntity deletAccount( @PathVariable (value="id")Long id, @RequestBody AccountEntity a )throws ResourceNotFoundException {
		AccountEntity existingAccount=service.find(id).orElseThrow(()->new ResourceNotFoundException("Account not found  :: " + id));
		String s=a.getStatus();
		existingAccount.setStatus(s);
		return service.diposit(existingAccount);
	}
	
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<AccountEntity> findData(@PathVariable  Long id) throws ResourceNotFoundException {
			AccountEntity a=service.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not found " + id));
			return ResponseEntity.ok().body(a);
	}


}


