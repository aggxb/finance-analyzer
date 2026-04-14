package br.com.aggxb.financeanalyzer.exceptions;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException() {
        super("Amount value must be a positive number or zero");
    }
}
