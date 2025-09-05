
package org.acme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreditCardService {

    private Logger logger = LoggerFactory.getLogger(CreditCardService.class);

    public CreditCardDetails processCreditBill(String creditCardNumber) {
        logger.info("Paying credit card");
        return new CreditCardDetails(creditCardNumber);
    }

    public CreditCardDetails settleBill(CreditCardDetails creditCardDetails) {
        creditCardDetails.setStatus("Bill paid");
        logger.info("settling bill");
        return creditCardDetails;
    }

    public CreditCardDetails cancelPayment(CreditCardDetails creditCardDetails) {
        creditCardDetails.setStatus("Payment cancelled, money will be refunded if it is debited");
        logger.info("cancelling bill");
        return creditCardDetails;
    }
}
