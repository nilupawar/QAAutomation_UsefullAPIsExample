package com.automation.qa.example;


import lombok.Builder;

/*
* This is build example using Lombok API
* */

@Builder
public class BankAccount {
    private long accountNumber; //This is important, so we'll pass it to the constructor.
    private String owner;
    private String branch;
    private double balance;
    private double interestRate;

    public static void main(String[] args) {
        BankAccount bankAccount = BankAccount.builder()
                .accountNumber(324234)
                .balance(4234)
                .branch("")
                .interestRate(3.3)
                .owner("")
                .build();
    }
}
