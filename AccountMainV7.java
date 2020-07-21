package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Account;
import com.montran.pojo.Savings;
import com.montran.pojo.Current;

public class AccountMainV7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int accountNumber;
		String name;
		double balance;
		int amount;
		int trainsactionChoice;
		String continueChoice;
		int accountChoice;
		boolean isSalary = false;
		boolean result;
		double overdraftBalance;

		System.out.println(" Hello Welcome to XYZ Bank !!");

		System.out.println("Menu");
		System.out.println("1.. Savings");
		System.out.println("2.. Current");
		System.out.println("Enter your choice");
		accountChoice = scanner.nextInt();

		switch (accountChoice) {
		case 1:
			System.out.println("Do you want to open salary account (true-false)");
			isSalary = scanner.nextBoolean();
			System.out.println("Enter account Number");
			accountNumber = scanner.nextInt();

			System.out.println("Enter Name");
			name = scanner.next();

			System.out.println("Enter Salary");
			balance = scanner.nextDouble();

			Savings savings = new Savings(accountNumber, name, balance, isSalary);
			System.out.println("Your account is opened successfully !!! ");
			System.out.println(savings);
			do {
				System.out.println("Menu");
				System.out.println("1. Withdraw");
				System.out.println("2. Deposit");
				System.out.println("3. Balance");
				System.out.println("Enter your choice");
				trainsactionChoice = scanner.nextInt();

				switch (trainsactionChoice) {
				case 1:
					System.out.println("Enter amount to withdraw");
					amount = scanner.nextInt();
					result = savings.withdraw(amount);
					if (result)
						System.out.println("Transaction Success !!");
					else
						System.out.println("Transaction Failed !!");
					break;
				case 2:
					System.out.println("Enter amount to deposit");
					amount = scanner.nextInt();
					result = savings.deposit(amount);
					if (result)
						System.out.println("Transaction Success !!");
					else
						System.out.println("Transaction Failed !!");
					break;
				case 3:
					System.out.println("Account Balance :: " + savings.getBalance());
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}

				System.out.println("Do you want to continue ?");
				continueChoice = scanner.next();
			} while (continueChoice.equals("yes"));
			break;
		case 2:
			
			System.out.println("Enter account Number");
			accountNumber = scanner.nextInt();

			System.out.println("Enter Name");
			name = scanner.next();

			System.out.println("Enter Balance");
			balance = scanner.nextDouble();
			
			System.out.println("Enter overdraft balance");
			overdraftBalance=scanner.nextDouble();
			Current current=new Current(accountNumber,name,balance,overdraftBalance);
			System.out.println("Your account is opened successfully !!! ");
			System.out.println(current);
			do {
				System.out.println("Menu");
				System.out.println("1. Withdraw");
				System.out.println("2. Deposit");
				System.out.println("3. Balance");
				System.out.println("Enter your choice");
				trainsactionChoice = scanner.nextInt();

				switch (trainsactionChoice) {
				case 1:
					System.out.println("Enter amount to withdraw");
					amount = scanner.nextInt();
					result = current.withdraw(amount);
					if (result)
						System.out.println("Transaction Success !!");
					else
						System.out.println("Transaction Failed !!");
					break;
				case 2:
					System.out.println("Enter amount to deposit");
					amount = scanner.nextInt();
					result = current.deposit(amount);
					if (result)
						System.out.println("Transaction Success !!");
					else
						System.out.println("Transaction Failed !!");
					break;
				case 3:
					System.out.println("Account Balance :: " + current.getBalance());
					System.out.println("Overdraft Balance::"+ current.getOverdradtBalance());
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}

				System.out.println("Do you want to continue ?");
				continueChoice = scanner.next();
			} while (continueChoice.equals("yes"));
		default:
			System.out.println("Thank you for banking with us ");
			break;
		}

		
		

		
		scanner.close();

	}
}

