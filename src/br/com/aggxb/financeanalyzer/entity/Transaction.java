package br.com.aggxb.financeanalyzer.entity;

import br.com.aggxb.financeanalyzer.enums.TransactionType;
import br.com.aggxb.financeanalyzer.exceptions.NegativeAmountException;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

public class Transaction {
    private int id;
    private String description;
    private double amount;
    private LocalDate date;
    private TransactionType type;
    private String category;

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    public Transaction(int id, String description, double amount, LocalDate date, TransactionType type, String category) {
        if (amount < 0) throw new NegativeAmountException();

        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && Double.compare(amount, that.amount) == 0 && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, date);
    }

    @Override
    public String toString() {
        String transaction = """
                TRANSACTION
                Description: %s
                Amount: %s
                Date: %s
                Transaction Type: %s
                Category: %s""".formatted(getDescription(), formatter.format(getAmount()), getDate(), getType(), getCategory());

        return transaction;
    }
}