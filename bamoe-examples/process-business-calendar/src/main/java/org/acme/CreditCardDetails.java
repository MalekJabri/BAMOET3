
package org.acme;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardDetails {
    private String cardNumber;
    private String status = "Bill Due";

    public CreditCardDetails() {
    }

    public CreditCardDetails(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
