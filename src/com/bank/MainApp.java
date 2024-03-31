package com.bank;

import java.util.Scanner;

public class MainApp {
	static int MAX_ACCOUNTS = 20;
    static int MAX_REPORTS = 50;
	static Report[] report = new Report[MAX_REPORTS];
	static int rcount = 0;
	static Account[] accounts = new Account[MAX_ACCOUNTS];
	
	public static void reportGenerate(int acc, String accName, double transication, String activity) 
	{

		report[rcount++] = new Report(acc, accName, transication, activity);
	}
	
	public static void fetchReport() 
	{
		System.out.println("====================================================================================================");
        System.out.printf("| %-8s | %-23s | %-18s | %-37s |\n", "AccountNo", "HolderName", "Transation", "Activity");
        System.out.println("====================================================================================================");
		for (Report ref : report) 
		{
			if (ref != null) 
			{
			
				System.out.printf("| %-9d | %-23s | %-18s | %-37s |\n",ref.getAccountNumber(),ref.getAccountName(),ref.getTransicationAmount(),ref.getActivity());
				System.out.println("----------------------------------------------------------------------------------------------------");
			}
			else 
			{
				System.out.println("Todays No work");
				break;
			}

		}
	}

	

	public static void main(String[] args) {
		

		int choice, accountNumber = 123456, count = 0;
		String id="chetan@123";
		String password="Pass@123";
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("\t _________________________________________________________________________");
			System.out.println("\t|    MENU                                                                 |");
			System.out.println("\t|    Which operation would you like to perform                            |");
			System.out.println("\t|    1.Create New Account                                                 |");
			System.out.println("\t|    2.Login Existing                                                     |");
			System.out.println("\t|    3.Bank Admin Login                                                   |");
			System.out.println("\t|_________________________________________________________________________|");
			System.out.println("\t     Enter your choice:   ");
			choice = sc.nextInt();
			switch (choice) {
				case 1: {
					System.out.println("\tEnter The Name: ");
					String name = sc.next();
					System.out.println();
					System.out.println("\t _________________________________________________________________________");
					System.out.println("\t|    MENU                                                                 |");
					System.out.println("\t|    Which operation would you like to perform                            |");
					System.out.println("\t|    1.Saving Account                                                     |");
					System.out.println("\t|    2.Salary Account                                                     |");
					System.out.println("\t|    3.Current Account                                                    |");
					System.out.println("\t|    4.Loan Account                                                       |");
					System.out.println("\t|_________________________________________________________________________|");
					System.out.println("\t     Enter your choice:-");
					int subChoice = sc.nextInt();
					switch (subChoice) {
						case 1: {
							System.out.println("\tEnter Initial Amount To Deposite");
							double amount = sc.nextDouble();
							System.out.println("\tEnter the Password:");
							String logpass=sc.next();
							if(amount>1000)
							{
								accounts[count++] = new SavingAccount(accountNumber++, name, amount,logpass);

								reportGenerate(accounts[count - 1].getAccountNumber(),
										accounts[count - 1].getAccountHolderName(), amount, "Saving Account Open");
								System.out.println("\tAccount Created Successfully");
								accounts[count - 1].display();
							}
							else
							{
								System.out.println("\tMinimum Account Opening Amount 1000 Plz Enter valid Amount1");
							}
							
						}
							break;
						case 2: {
							System.out.println("\tEnter Initial Amount To Deposite");
							double amount = sc.nextDouble();
							System.out.println("\tEnter the Password:");
							String logpass=sc.next();
							if(amount>1000)
							{
								accounts[count++] = new SalaryAccount(accountNumber++, name, amount,logpass);

								reportGenerate(accounts[count - 1].getAccountNumber(),
										accounts[count - 1].getAccountHolderName(), amount, "Salary Account Open");
								System.out.println("\tAccount Created Successfully");
								accounts[count - 1].display();
							}
							else
							{
								System.out.println("\tMinimum Account Opening Amount 1000 Plz Enter valid Amount1");
							}
							
						}
							break;
						case 3: {
							System.out.println("\tEnter Initial Amount To Deposite");
							double amount = sc.nextDouble();
							System.out.println("\tEnter the Password:");
							String logpass=sc.next();
							accounts[count++] = new CurrentAccount(accountNumber++, name, amount,logpass, 10000d);

							reportGenerate(accounts[count - 1].getAccountNumber(),
									accounts[count - 1].getAccountHolderName(), amount, "Current Account Open");
							System.out.println("\tAccount Created Successfully");
							accounts[count - 1].display();
						}
							break;
						case 4: {
							System.out.println("\tEnter Amount To Get Loan");
							double amount = sc.nextDouble();
							System.out.println("\tEnter the Password:");
							String logpass=sc.next();
							accounts[count++] = new LoanAccount(accountNumber++, name, amount,logpass);

							reportGenerate(accounts[count - 1].getAccountNumber(),
									accounts[count - 1].getAccountHolderName(), amount, "Loan Account Open");
							System.out.println("\tLoan Account Created Successfully ");
							accounts[count - 1].display();
						}
							break;

					}

				}
					break;
				case 2: {
					System.out.println("\tEnter Your Account Number: ");
					int accountNo = sc.nextInt();
					System.out.println("\tEnter the Password:");
					String passwords=sc.next();
					Account account = null;
					for (Account ref : accounts) {
						if (ref != null)
							if (ref.getAccountNumber() == accountNo) {
								account = ref;
								break;
							}
					
					}
					if(account==null)
					{
						System.out.println("\tAccount Not exist");
					}
					else
					{
						
						if(passwords.equals(account.getPassword()))
						{
						account.display();
						int subChoice;
						do {

							System.out.println();
							System.out.println("\t _________________________________________________________________________");
							System.out.println("\t|    MENU                                                                 |");
							System.out.println("\t|    Which operation would you like to perform                            |");
							System.out.println("\t|    1.Deposite                                                           |");
							System.out.println("\t|    2.Withdraw                                                           |");
							System.out.println("\t|    3.Transfer the Amount                                                |");
							System.out.println("\t|    4.See The Intrest On Account balance                                 |");
							System.out.println("\t|    5.Check Account Balance                                              |");
							System.out.println("\t|    6.Delete Account                                                     |");
							System.out.println("\t|    0.Logout                                                             |");
							System.out.println("\t|_________________________________________________________________________|");
							System.out.println("\t     Enter your choice:   ");
							subChoice = sc.nextInt();
							switch (subChoice) {
								case 1: {
									System.out.println("\tEnter The Amount To Deposite: ");
									double amount = sc.nextDouble();
									if (account.deposite(amount)) {
										System.out.println("\tAmount Deposite Successfully");
										System.out.println("\tAccount Balance:"+account.getAccountBalance());
										reportGenerate(account.getAccountNumber(),account.getAccountHolderName(), amount, "Deposite");
									}

								}
									break;

								case 2: {
									System.out.println("\tEnter The Amount TO Withdraw: ");
									double amount = sc.nextDouble();
									if (account.withdraw(amount)) {
										System.out.println("\tAmount Withdraw Succesfully");
										System.out.println("\tRemainig Balace:" + account.getAccountBalance());
										reportGenerate(account.getAccountNumber(),account.getAccountHolderName(), -amount, "Withdraw");

									}

									else {
										System.out.println("\tTransication Failed");
									}
								}
									break;

								case 3: {
									System.out.println("\tEnter The Account Number Where Transfer:");
									int accNo = sc.nextInt();
									Account destination = null;
									for (Account ref : accounts) {
										if(ref!=null)
										if (ref.getAccountNumber() == accNo) {
											destination = ref;
											break;
										}
									}
									if(destination!=null)
									{
										System.out.println("\tEnter The Amount To Transfer: ");
										double amount = sc.nextDouble();
										if (account.transfer1(destination, amount)) {
											reportGenerate(account.getAccountNumber(),account.getAccountHolderName(), -amount,"Transfer");
											System.out.println("\tAmount Transfered Succesfully");
										}
										else
										{
											System.out.println("\tTransication failed");
										}
									}
									else
									{
										System.out.println("\tInvalid Account Number Try Again");
									}
									

								}
									break;
								case 4: {
									System.out.println("\tIntrset On Your Account Balance: "+ accounts[0].getClass().getName() + account.rateofintreset());
								}
									break;
								case 5:
									{
										System.out.println("\tAccount Balance:"+account.getAccountBalance());
									}
									break;
								case 6:
									{
										if(account.getAccountBalance()==0)
										{
											int i,j;
											for(i=0;i<count;i++)
											{
												if(accounts[i]==account)
												{
													break;
												}
											}
											for( j=i;j<count;j++)
											{
												accounts[j]=accounts[j+1];
											}
											reportGenerate(account.getAccountNumber(),account.getAccountHolderName(),01,"Account Deleted");
											System.out.println("\t===============================================================");
									        System.out.printf("\t| %-8s | %-23s | %-18s |\n", "AccountNumber", "AccountHolderName", "Balance");
									        System.out.println("\t===============================================================");
											account.displayAll();
											count--;
											System.out.println("\tAccount Delete Successfully");
										}
										else
										{
											System.out.println("\tYou Have " + account.getAccountBalance() + " in Your Account Balance \nThis Account Cant Be Delete");
										}
										
									}break;
							}

						} while (subChoice != 0);
						}
						else
						{
							System.out.println("\tIncorrect Password ");
						}
					}
				}
					break;
				case 3: 
					{
						
						System.out.println("Enter the Login Id:");
						String logid=sc.next();
						System.out.println("Enter the Password");
						String passid=sc.next();
						int schoice=0;
						if(id.equals(logid)&& password.equals(passid))
						{
							do
							{
								System.out.println();
								System.out.println("\t _________________________________________________________________________");
								System.out.println("\t|    MENU                                                                 |");
								System.out.println("\t|    Which operation would you like to perform                            |");
								System.out.println("\t|    1.All Account details                                                |");
								System.out.println("\t|    2.Get Transication Report                                            |");
								System.out.println("\t|    3.Calculate Intrest of All Account                                   |");
								System.out.println("\t|    0.Logout                                                             |");
								System.out.println("\t|_________________________________________________________________________|");
								System.out.println("\t     Enter your choice:   ");
								schoice = sc.nextInt();
								switch(schoice)
								{
									case 1:
									{
										if(count==0)
										{
											System.out.println("Does Not Have Any Acclount in Bank!");
										}
										else
										{
										System.out.println("\t===============================================================");
								        System.out.printf("\t| %-8s | %-23s | %-18s |\n", "AccountNumber", "AccountHolderName", "Balance");
								        System.out.println("\t===============================================================");
										for (Account ref : accounts) 
										{
											if (ref != null)
											{
												ref.displayAll();
											} 
										}
										}
										
									}
										break;
									case 2:
										{
											fetchReport();
										}break;
										
									case 3:
										{
								
											for (Account ref : accounts) 
											{
												if (ref != null) 
												{
													ref.deposite(ref.rateofintreset());
													reportGenerate(ref.getAccountNumber(), ref.accountHolderName, ref.rateofintreset(),
															"Intrest Credited");
												}
												else
												{
													System.out.println("Data Set is Empty");
													break;
												}
													
											}
											
											
										}break;
										
								
								}
								
							}
							while(schoice !=0);
						}
						else
						{
							System.out.println("Invalid Password or ID");
						}
						
						
								
					}break;
				
				default: {
					System.out.println("Invalid Choice!");
				}

			}

		} while (choice != 0);
		sc.close();

	}
}
	























