package com.mindaryn.invoices;

import com.mindaryn.banking.BankingService;
import com.mindaryn.banking.Payment;
import com.mindaryn.banking.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * Endpoint that picks Payments from the system and dispatches them to the
 * service provided by bank.
 */
@Component
public class PaymentProcessor {

    @Autowired
    BankingService bankingService;

    @ServiceActivator
    public void processPayment(Payment payment) throws PaymentException {
        bankingService.pay(payment);
    }

}
