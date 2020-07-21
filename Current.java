package com.montran.pojo;

//current is-a account so extend Account class
public class Current extends Account {
	private double overdraftBalance;
	private double baloverdraftBalance;
	private double orgoverdraftBalance;
	
	//default constr
	public Current() {
		
	}
    //param constr
	public Current(int accountNumber, String name, double balance, double overdraftBalance) {
		super(accountNumber, name, balance);
		this.overdraftBalance = overdraftBalance;
		this.baloverdraftBalance=overdraftBalance;
		this.orgoverdraftBalance=overdraftBalance;
	}
    //getter-setter
	public double getOverdradtBalance() {
		return overdraftBalance;
	}

	public void setOverdraftBalance(double overdraftBalance) {
		this.overdraftBalance = overdraftBalance;
		this.baloverdraftBalance=overdraftBalance;
	}
	
	public boolean withdraw(double amount) {
		double due=0;
		if (amount >0 && amount>getBalance()) {  // If amount is deducted from overdraftbalance
			due=amount-getBalance();    
		    setBalance(0);              //Balance=0
		    baloverdraftBalance=overdraftBalance-due;  
		    overdraftBalance=baloverdraftBalance;     
		    return true;
		}
		if (amount<getBalance()) {             
			setBalance(getBalance() - amount);    
			return true;
		}
		return false;
		    
	}
	
	public boolean deposit(double amount) {
		double due=0;
		//System.out.println(getBalance());
		if(orgoverdraftBalance!=overdraftBalance) {         
			due=orgoverdraftBalance - overdraftBalance; 
			if(amount<=due) {
				overdraftBalance=overdraftBalance+amount;
			    return true;
			}    
			else if(amount>due) {
				overdraftBalance=overdraftBalance+due;
			    setBalance(getBalance()+(amount-due));
			    return true;
			}
		}
		else
			setBalance(getBalance()+amount);
		return false;
	}

	@Override
	public String toString() {
		return "Current [overdraftBalance=" + overdraftBalance + ", getAccountNumber()=" + getAccountNumber()
				+ ", getName()=" + getName() + ", getBalance()=" + getBalance() + "]";
	}
	
	

}
