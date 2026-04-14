package br.com.aggxb.financeanalyzer.repository;

import br.com.aggxb.financeanalyzer.entity.Transaction;
import br.com.aggxb.financeanalyzer.enums.TransactionType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {
    private final static List<Transaction> transactionList = new ArrayList<>();

    static {
        transactionList.add(new Transaction(1, "January Salary", 5000.00, LocalDate.of(2024, 1, 5), TransactionType.INCOME, "Salary"));
        transactionList.add(new Transaction(2, "Grocery Store", 450.00, LocalDate.of(2024, 3, 10), TransactionType.EXPENSE, "Food"));
        transactionList.add(new Transaction(3, "Pharmacy", 150.00, LocalDate.of(2024, 6, 12), TransactionType.EXPENSE, "Health"));
        transactionList.add(new Transaction(4, "Electric Bill", 120.00, LocalDate.of(2024, 7, 15), TransactionType.EXPENSE, "Utilities"));
        transactionList.add(new Transaction(5, "Netflix Subscription", 40.00, LocalDate.of(2024, 9, 20), TransactionType.EXPENSE, "Entertainment"));
        transactionList.add(new Transaction(6, "Gas Station", 200.00, LocalDate.of(2024, 12, 25), TransactionType.EXPENSE, "Transport"));

        transactionList.add(new Transaction(7, "February Salary", 5000.00, LocalDate.of(2025, 2, 5), TransactionType.INCOME, "Salary"));
        transactionList.add(new Transaction(8, "Restaurant with friends", 180.00, LocalDate.of(2025, 2, 8), TransactionType.EXPENSE, "Food"));
        transactionList.add(new Transaction(9, "Stock Dividend", 350.00, LocalDate.of(2025, 4, 10), TransactionType.INCOME, "Investments"));
        transactionList.add(new Transaction(10, "Freelance Web Design", 1500.00, LocalDate.of(2025, 5, 12), TransactionType.INCOME, "Freelance"));
        transactionList.add(new Transaction(11, "Water Bill", 80.00, LocalDate.of(2025, 8, 14), TransactionType.EXPENSE, "Utilities"));
        transactionList.add(new Transaction(12, "Flight Ticket", 1200.00, LocalDate.of(2025, 10, 5), TransactionType.EXPENSE, "Travel"));
        transactionList.add(new Transaction(13, "Cinema Ticket", 60.00, LocalDate.of(2025, 11, 18), TransactionType.EXPENSE, "Entertainment"));

        transactionList.add(new Transaction(14, "January Salary", 5000.00, LocalDate.of(2026, 1, 5), TransactionType.INCOME, "Salary"));
        transactionList.add(new Transaction(15, "New Laptop", 4500.00, LocalDate.of(2026, 1, 12), TransactionType.EXPENSE, "Electronics"));
        transactionList.add(new Transaction(16, "Supermarket", 380.00, LocalDate.of(2026, 1, 22), TransactionType.EXPENSE, "Food"));
        transactionList.add(new Transaction(17, "Gym Membership", 100.00, LocalDate.of(2026, 2, 6), TransactionType.EXPENSE, "Health"));
        transactionList.add(new Transaction(18, "Coffee Shop", 35.00, LocalDate.of(2026, 2, 8), TransactionType.EXPENSE, "Food"));
        transactionList.add(new Transaction(19, "Uber Ride", 45.00, LocalDate.of(2026, 2, 10), TransactionType.EXPENSE, "Transport"));
        transactionList.add(new Transaction(20, "Car Maintenance", 800.00, LocalDate.of(2026, 3, 2), TransactionType.EXPENSE, "Transport"));
        transactionList.add(new Transaction(21, "Spotify Subscription", 25.00, LocalDate.of(2026, 3, 15), TransactionType.EXPENSE, "Entertainment"));
        transactionList.add(new Transaction(22, "Year-end Bonus", 3000.00, LocalDate.of(2026, 12, 10), TransactionType.INCOME, "Salary"));
    }

    public List<Transaction> getTransactionList() {
        return Collections.unmodifiableList(transactionList);
    }
}
