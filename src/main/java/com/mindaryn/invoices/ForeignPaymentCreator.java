package com.mindaryn.invoices;

import com.mindaryn.banking.Payment;
import com.mindaryn.banking.PaymentCreator;
import com.mindaryn.banking.PaymentException;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

@Component
public class ForeignPaymentCreator implements PaymentCreator {

    // hard coded account value for demo purposes
    private static final String CURRENT_IBAN_ACC = "current-iban-acc";

    @Override
    @Transformer
    public Payment createPayment(Invoice invoice) throws PaymentException {
        if (null == invoice.getIban()) {
            throw new PaymentException("IBAN mustn't be null when creating foreign payment!");
        }

        return new Payment(CURRENT_IBAN_ACC, invoice.getIban(), invoice.getDollars());
    }

}
