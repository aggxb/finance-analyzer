package br.com.aggxb.financeanalyzer.service;

import br.com.aggxb.financeanalyzer.entity.Transaction;
import br.com.aggxb.financeanalyzer.enums.TransactionType;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionService {
    private final List<Transaction> transactionList;

    public TransactionService(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public double calculateTotalBalance() {
        double totalIncomes = transactionList.stream()
                .filter(transaction -> transaction.getType() == TransactionType.INCOME)
                .mapToDouble(Transaction::getAmount).sum();
        double totalExpenses = transactionList.stream()
                .filter(transaction -> transaction.getType() == TransactionType.EXPENSE)
                .mapToDouble(Transaction::getAmount).sum();

        return totalIncomes - totalExpenses;
    }

    public List<Transaction> filterByMonthAndYear(Integer month, Integer year) {
        List<Transaction> filteredList;

        boolean validMonth = month > 0 && month <= 12;
        boolean validYear = year.toString().length() == 4;

        if (validMonth && validYear) {
            filteredList = transactionList.stream()
                    .filter(transaction -> transaction.getDate().getMonth().equals(Month.of(month)) && transaction.getDate().getYear() == year).toList();

            return filteredList;
        }

        return List.of();
    }

    public Optional<Transaction> findHighestExpense() {
        Optional<Transaction> highestExpenseTransaction = transactionList.stream()
                .filter(transaction -> transaction.getType() == TransactionType.EXPENSE)
                .max(Comparator.comparingDouble(Transaction::getAmount));

        return highestExpenseTransaction;
    }

    public Set<String> getUniqueCategories() {
        Set<String> categories = transactionList.stream()
                .map(Transaction::getCategory)
                .collect(Collectors.toSet());

        return categories;
    }

    public Map<String, Double> groupExpensesByCategory() {
        Map<String, Double> expensesByCategory = transactionList.stream()
                .filter(transaction -> transaction.getType() == TransactionType.EXPENSE)
                .collect(
                        Collectors.groupingBy(
                                Transaction::getCategory,
                                Collectors.summingDouble(Transaction::getAmount)
                        )
                );

        return expensesByCategory;
    }
}
