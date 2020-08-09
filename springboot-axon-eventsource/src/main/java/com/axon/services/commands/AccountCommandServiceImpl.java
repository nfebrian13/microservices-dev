package com.axon.services.commands;

import com.axon.commands.CreateAccountCommand;
import com.axon.commands.CreditMoneyCommand;
import com.axon.commands.DebitMoneyCommand;
import com.axon.dto.AccountCreateDTO;
import com.axon.dto.MoneyCreditDTO;
import com.axon.dto.MoneyDebitDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

	private final CommandGateway commandGateway;

	public AccountCommandServiceImpl(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@Override
	public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
		return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(),
				accountCreateDTO.getStartingBalance(), accountCreateDTO.getCurrency()));
	}

	@Override
	public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
		return commandGateway.send(
				new CreditMoneyCommand(accountNumber, moneyCreditDTO.getCreditAmount(), moneyCreditDTO.getCurrency()));
	}

	@Override
	public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
		return commandGateway.send(
				new DebitMoneyCommand(accountNumber, moneyDebitDTO.getDebitAmount(), moneyDebitDTO.getCurrency()));
	}
}
