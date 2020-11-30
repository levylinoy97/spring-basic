package app.beans;

import app.annotations.BasicAuthorization;
import app.annotations.BasicMeasurement;
import org.springframework.stereotype.Component;

@Component
@BasicMeasurement
public class Account {
    private String number;
    private String balance;
    private int overdraftInterest;
    private int overdraftCap;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public int getOverdraftInterest() {
        return overdraftInterest;
    }

    public void setOverdraftInterest(int overdraftInterest) {
        this.overdraftInterest = overdraftInterest;
    }

    public int getOverdraftCap() {
        return overdraftCap;
    }

    public void setOverdraftCap(int overdraftCap) {
        this.overdraftCap = overdraftCap;
    }
}
