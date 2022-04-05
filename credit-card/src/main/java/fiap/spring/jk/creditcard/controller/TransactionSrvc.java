package fiap.spring.jk.creditcard.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.DocumentException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import fiap.spring.jk.creditcard.model.Transactions;
import fiap.spring.jk.creditcard.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
public class TransactionSrvc {
    
    @Autowired
    private TransactionRepository transactionRepo;

    @PostMapping(value = "/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    public Transactions addTransaction(@RequestBody Transactions transaction) {
        return transactionRepo.save(transaction);
    }

    @GetMapping(value="/transactions")
    public List<Transactions> getTransactions(){
        return transactionRepo.findAll();
    }


    @GetMapping("/transactions/export/pdf")
    public void exportTransactionsToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Transactions_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Transactions> listTransactions = transactionRepo.findAll();
         
        TransactionsPDFExporter exporter = new TransactionsPDFExporter(listTransactions);
        exporter.exportTransactions(response);    
    }


}
