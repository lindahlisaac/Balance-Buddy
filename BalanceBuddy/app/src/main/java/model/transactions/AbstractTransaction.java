package model.transactions;

import java.math.BigDecimal;
import java.util.Date;

public abstract class AbstractTransaction {

    private BigDecimal amount;
    private Date transDate;
    private int frequencyDays;

    /*
    Setters
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public void setFrequencyDays(int frequencyDays) {
        this.frequencyDays = frequencyDays;
    }

    /*
    Getters
     */
    public BigDecimal getAmount() {
        return this.amount;
    }

    public Date getTransDate() {
        return this.transDate;
    }

    public int getFrequencyDays() {
        return this.frequencyDays;
    }


}
