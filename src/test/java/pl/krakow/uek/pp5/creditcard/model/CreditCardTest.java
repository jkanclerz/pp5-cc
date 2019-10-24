package pl.krakow.uek.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Test;
import pl.krakow.uek.pp5.creditcard.model.exceptions.CreditBelowMinimumException;

import java.math.BigDecimal;

public class CreditCardTest {

    public static final int NEW_CREDIT_LIMIT = 2000;

    @Test
    public void itAllowAssignLimitToCreditCard() {
        //Arrange // Given
        CreditCard creditCard = new CreditCard("1234-5678");
        //Act // When
        creditCard.assignLimit(BigDecimal.valueOf(NEW_CREDIT_LIMIT));
        //Assert // Then // Expect
        Assert.assertTrue(creditCard.getLimit().equals(BigDecimal.valueOf(NEW_CREDIT_LIMIT)));
    }

    @Test
    public void itVerifyMinimumCreditValue() {

        CreditCard card = new CreditCard("1234-5678");

        try {
            card.assignLimit(BigDecimal.valueOf(50));
            Assert.fail("Exception should be thrown");
        } catch (CreditBelowMinimumException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void foo() {
        CreditCard card = new CreditCard("1234-5678");
        card.assignLimit(BigDecimal.valueOf(100));
        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(100)));
    }

}
