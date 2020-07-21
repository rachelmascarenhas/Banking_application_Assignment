package com.montran.pojo;

//savings "is-a" account 
public class Savings extends Account {
	private boolean isSalary;

	public Savings() {
		System.out.println("Default of Savings");
	}

	public Savings(int accountNumber, String name, double balance, boolean isSalary) {
		super(accountNumber, name, balance);
		this.isSalary = isSalary;
	}

	public boolean isSalary() {
		return isSalary;
	}
	
	public void setSalary(boolean isSalary) {
		System.out.println("param of savings");
		this.isSalary = isSalary;
	}

	@Override //(type with then ctrl+space)
	public boolean withdraw(double amount) {
		if (amount>0) {
			if (isSalary && amount <=getBalance()) {
				setBalance(getBalance()-amount);
				return true;
        }
		if (isSalary == false && getBalance() - amount >=500) {
			setBalance(getBalance()-amount);
			return true;
		}
		}
		return false;
	}
	
	@Override//(type with then ctrl+space)
	public boolean deposit(double amount) {
		if (amount > 0) {
			setBalance(getBalance() + amount);
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Savings [isSalary=" + isSalary + ", getAccountNumber()=" + getAccountNumber() + ", getName()="
				+ getName() + ", getBalance()=" + getBalance() + "]";
	}
	
	
	
	
}
