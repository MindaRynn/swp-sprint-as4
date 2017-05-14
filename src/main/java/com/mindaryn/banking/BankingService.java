package com.mindaryn.banking;

/**
 * Contract for communication with bank.
 */
public interface BankingService {

	void pay(Payment payment) throws PaymentException;

}
