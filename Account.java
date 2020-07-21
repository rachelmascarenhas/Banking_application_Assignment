package com.montran.pojo;

public class Account { //if u don't extend the class by default it will extend object class (root/base class)
   //Create variables
   private int accountNumber;
   private String name;
   private double balance;
   
   //deafult constructor
   public Account() {
	   System.out.println("Default constructor");
   }
   //Parametrized constructro
   public Account(int accountNumber, String name, double balance) {
		//System.out.println("Param constructor of Account");
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

   public int getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getBalance() {
	return balance;
}

   public void setBalance(double balance) {
	this.balance = balance;
   }

   public boolean deposit(double amount) {
	   if (amount>0) {
		   balance=balance+amount;
		   return true;
	   }
	   return false;
   }
   
   public boolean withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance = balance - amount;
			return true;
		}
		return false;
	}


@Override //@override denotes that the method is used from some other class
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
}




}
