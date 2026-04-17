package br.com.aggxb.financeanalyzer.cli;

import br.com.aggxb.financeanalyzer.entity.Transaction;
import br.com.aggxb.financeanalyzer.service.TransactionService;

import java.text.NumberFormat;
import java.util.*;

public class MenuController {
    Scanner scanner = new Scanner(System.in);
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    public TransactionService service;
    public String div = "----------------------------";

    public MenuController(TransactionService service) {
        this.service = service;
    }

    private void showTotalBalance() {
        System.out.println("--TOTAL BALANCE-------------");

        double totalBalance = service.calculateTotalBalance();
        System.out.println("The total balance is " + formatter.format(totalBalance));
    }

    private void showFilteredListByMonthAndYear() {
        System.out.println("--FILTER TRANSACTION--------");

        System.out.printf("Insert the month: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.printf("Insert the year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println(div);

        List<Transaction> filteredList = service.filterByMonthAndYear(month, year);

        if (filteredList.isEmpty()) {
            System.out.println("Empty list or invalid month/year");
        } else {
            filteredList.forEach(transaction -> System.out.println(transaction + "\n" + div));
        }
    }

    private void showHighestExpenseTransaction() {
        System.out.println("--HIGHEST EXPENSE-----------");

        Optional<Transaction> highestExpenseTransaction = service.findHighestExpense();

        if (highestExpenseTransaction.isPresent()) {
            System.out.println(highestExpenseTransaction.get());
        } else {
            System.out.println("None transaction found");
        }
    }

    private void showTransactionCategories() {
        System.out.println("--CATEGORIES----------------");

        Set<String> categories = service.getUniqueCategories();

        if (categories.isEmpty()) {
            System.out.println("Empty list of categories");
        } else {
            categories.forEach(System.out::println);
        }
    }

    private void showExpenseTransactionBalanceByCategory() {
        System.out.println("--EXPENSES BY CATEGORY------");

        Map<String, Double> transactionBalanceByCategoryMap = service.groupExpensesByCategory();

        if (transactionBalanceByCategoryMap.isEmpty()) {
            System.out.println("Empty list of transactions");
        } else {
            transactionBalanceByCategoryMap.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + ": " + formatter.format(entry.getValue()));
            });
        }
    }

    public void start() {
        int opt;

        do {
            System.out.println(div);
            System.out.println("------FINANCE ANALYZER------");
            System.out.println(div);
            System.out.println("[1] - Get total balance");
            System.out.println("[2] - Get transactions by month and year");
            System.out.println("[3] - Get highest expense transaction");
            System.out.println("[4] - Get transaction categories");
            System.out.println("[5] - Get expense transactions by category");
            System.out.println("[6] - Exit");
            System.out.println(div);

            System.out.printf("Option: ");
            opt = Integer.parseInt(scanner.nextLine());
            System.out.println(div);

            switch (opt) {
                case 1:
                    showTotalBalance();
                    break;
                case 2:
                    showFilteredListByMonthAndYear();
                    break;
                case 3:
                    showHighestExpenseTransaction();
                    break;
                case 4:
                    showTransactionCategories();
                    break;
                case 5:
                    showExpenseTransactionBalanceByCategory();
                    break;
                case 6:
                    System.out.println("--EXIT----------------------");
                    System.out.println("Thank you for the preference");
                    break;
                default:
                    System.out.println("INVALID OPTION!");
                    break;
            }
        } while (opt != 6);
    }
}
