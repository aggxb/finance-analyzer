package br.com.aggxb.financeanalyzer;

import br.com.aggxb.financeanalyzer.repository.TransactionRepository;
import br.com.aggxb.financeanalyzer.service.TransactionService;

public class Main {
    public static void main(String[] args) {
        TransactionRepository repository = new TransactionRepository();

        TransactionService service = new TransactionService(repository.getTransactionList());

        System.out.println(service.calculateTotalBalance());
        System.out.println("---------------");
        service.filterByMonthAndYear(1, 2026).forEach(System.out::println);
        System.out.println("---------------");
        service.findHighestExpense().ifPresent(System.out::println);
        System.out.println("---------------");
        service.getUniqueCategories().forEach(System.out::println);
        System.out.println("---------------");
        service.groupExpensesByCategory().entrySet().forEach(System.out::println);
    }
}
