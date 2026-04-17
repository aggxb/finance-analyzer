package br.com.aggxb.financeanalyzer;

import br.com.aggxb.financeanalyzer.cli.MenuController;
import br.com.aggxb.financeanalyzer.repository.TransactionRepository;
import br.com.aggxb.financeanalyzer.service.TransactionService;

public class Main {
    public static void main(String[] args) {
        TransactionRepository repository = new TransactionRepository();
        TransactionService service = new TransactionService(repository.getTransactionList());

        MenuController controller = new MenuController(service);

        controller.start();
    }
}
