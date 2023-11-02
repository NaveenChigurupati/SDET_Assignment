package org.javaAssignment;

public class SavingsAccount extends Account {

    public void interest() {
        System.out.println("From derived class savingsAccount");

    }

    public static void main(String[] Args) {
        Account currentaccount = new CurrentAccount();
        Account account = new Account();
        SavingsAccount savingsAccount=new SavingsAccount();
        currentaccount.interest();
        account.interest();
        savingsAccount.interest();
    }
}