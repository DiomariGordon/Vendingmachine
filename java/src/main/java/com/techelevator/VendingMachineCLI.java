package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {
// create variables for the menus
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	private static final String MAIN_MENU_TWO_OPTION_FEED_MONEY = "Feed Money";
	private static final String MAIN_MENU_TWO_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String MAIN_MENU_TWO_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] MAIN_MENU_TWO_OPTIONS = {MAIN_MENU_TWO_OPTION_FEED_MONEY, MAIN_MENU_TWO_OPTION_SELECT_PRODUCT, MAIN_MENU_TWO_OPTION_FINISH_TRANSACTION};
	private static final BigDecimal MAIN_MENU_THREE_OPTION_ONE = new BigDecimal("1.00");
	private static final BigDecimal MAIN_MENU_THREE_OPTION_TWO = new BigDecimal("2.00");
	private static final BigDecimal MAIN_MENU_THREE_OPTION_FIVE = new BigDecimal("5.00");
	private static final BigDecimal MAIN_MENU_THREE_OPTION_TEN = new BigDecimal("10.00");
	private static final BigDecimal[] MAIN_MENU_THREE_OPTIONS = new BigDecimal[]{MAIN_MENU_THREE_OPTION_ONE, MAIN_MENU_THREE_OPTION_TWO, MAIN_MENU_THREE_OPTION_FIVE, MAIN_MENU_THREE_OPTION_TEN};

	// use menu object to hold variables
	private Menu menu;
// call your vending machine constructor that inputs a menu
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
// create a method to use all the values named run
	public void run() {
		boolean isOnChoice = true;
		VendingMachine machine = new VendingMachine();
		machine.setStock();
		while (isOnChoice) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				machine.displayItems();
			}
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean isOnChoice2 = true;
				// do purchase
				while(isOnChoice2) {
					System.out.println(System.lineSeparator() + "Current Money Provided: $" + VendingMachine.getBalance());
					String choice2 = (String) menu.getChoiceFromOptions(MAIN_MENU_TWO_OPTIONS);
					if (choice2.equals(MAIN_MENU_TWO_OPTION_FEED_MONEY)) {
						Scanner scan = new Scanner(System.in);
						System.out.print("How much do you want to put in?: ");
						BigDecimal moneyFed = (BigDecimal) menu.getChoiceFromOptions(MAIN_MENU_THREE_OPTIONS);
						//BigDecimal moneyFed = scan.nextBigDecimal();
						machine.feedMoney(moneyFed);
					} else if (choice2.equals(MAIN_MENU_TWO_OPTION_SELECT_PRODUCT)) {
						machine.displayItems();
						Scanner scan = new Scanner(System.in);
						System.out.print("What's The Item Number: ");
						String itemNumber = scan.nextLine();

						if(itemNumber != null) {
							System.out.println(machine.purchaseItem(VendingMachine.getBalance(), itemNumber));
						} else {
							System.out.println("Invalid. Please reenter item location.");
						}
					} else if (choice2.equals(MAIN_MENU_TWO_OPTION_FINISH_TRANSACTION)) {
						System.out.println(machine.getChange(VendingMachine.getBalance()));
						isOnChoice2 = false;
					}
				}

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				isOnChoice = false;
			}

		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		VendingMachine machine = new VendingMachine();
		cli.run();
	}
}
