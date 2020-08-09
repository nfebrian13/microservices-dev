package com.axon.services.commands;

import java.util.concurrent.CompletableFuture;

import com.axon.dto.AccountCreateDTO;
import com.axon.dto.MoneyCreditDTO;
import com.axon.dto.MoneyDebitDTO;

public interface AccountCommandService {
	
	public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
	public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
	public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}
