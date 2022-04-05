package fiap.spring.jk.creditcard.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import fiap.spring.jk.creditcard.model.Transaction;
import org.springframework.http.HttpStatus;

@RestController
public class TransactionSrvc {
    
    private fiap.spring.jk.creditcard.repository.TransactionRepository transactionRepo;

    @PostMapping(value = "/transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionRepo.save(transaction);
    }


    @GetMapping(value="/transaction")
    public List<Transaction> getTransactions(){
        return transactionRepo.findAll();
    }
}
