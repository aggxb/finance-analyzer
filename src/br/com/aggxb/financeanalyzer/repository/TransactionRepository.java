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
        transactionList.add(new Transaction(1, "January Salary", 5000.00, LocalDate.of(2026, 1, 5), TransactionType.INCOME, "Salary"));
        transactionList.add(new Transaction(2, "Grocery Store", 450.00, LocalDate.of(2026, 1, 10), TransactionType.EXPENSE, "Food"));
        transactionList.add(new Transaction(3, "Electric Bill", 120.00, LocalDate.of(2026, 1, 15), TransactionType.EXPENSE, "Utilities"));
        transactionList.add(new Transaction(4, "Netflix Subscription", 40.00, LocalDate.of(2026, 1, 20), TransactionType.EXPENSE, "Entertainment"));
        transactionList.add(new Transaction(5, "Gas Station", 200.00, LocalDate.of(2026, 1, 25), TransactionType.EXPENSE, "Transport"));

        transactionList.add(new Transaction(6, "February Salary", 5000.00, LocalDate.of(2026, 2, 5), TransactionType.INCOME, "Salary"));
        transactionList.add(new Transaction(7, "Restaurant with friends", 180.00, LocalDate.of(2026, 2, 8), TransactionType.EXPENSE, "Food"));
        transactionList.add(new Transaction(8, "Freelance Web Design", 1500.00, LocalDate.of(2026, 2, 12), TransactionType.INCOME, "Freelance"));
        transactionList.add(new Transaction(9, "Water Bill", 80.00, LocalDate.of(2026, 2, 14), TransactionType.EXPENSE, "Utilities"));
        transactionList.add(new Transaction(10, "Cinema Ticket", 60.00, LocalDate.of(2026, 2, 18), TransactionType.EXPENSE, "Entertainment"));
        transactionList.add(new Transaction(11, "Supermarket", 380.00, LocalDate.of(2026, 2, 22), TransactionType.EXPENSE, "Food"));

        transactionList.add(new Transaction(12, "March Salary", 5000.00, LocalDate.of(2026, 3, 5), TransactionType.INCOME, "Salary"));
        transactionList.add(new Transaction(13, "Gym Membership", 100.00, LocalDate.of(2026, 3, 6), TransactionType.EXPENSE, "Health"));
        transactionList.add(new Transaction(14, "Uber Ride", 45.00, LocalDate.of(2026, 3, 10), TransactionType.EXPENSE, "Transport"));
        transactionList.add(new Transaction(15, "Spotify Subscription", 25.00, LocalDate.of(2026, 3, 15), TransactionType.EXPENSE, "Entertainment"));
    }

    public List<Transaction> getTransactionList() {
        return Collections.unmodifiableList(transactionList);
    }
}
