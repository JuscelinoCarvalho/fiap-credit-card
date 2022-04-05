package fiap.spring.jk.creditcard.controller;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import fiap.spring.jk.creditcard.model.Transactions;
 
 
public class TransactionsPDFExporter {
    private List<Transactions> listTrans;

    public TransactionsPDFExporter(List<Transactions> vlistUsers) {
        this.listTrans = vlistUsers;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("id", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("transaction_number", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("reg_card_number", font));
        table.addCell(cell);
            
        cell.setPhrase(new Phrase("transactionValue", font));
        
    }
     
    private void writeTableData(PdfPTable table) {
        for (Transactions transact : listTrans) {
            table.addCell(String.valueOf(transact.getId()));
            table.addCell(transact.getTransactionNumber().toString());
            table.addCell(transact.getRegistrationNumberCard());
            table.addCell(transact.getTransactionValue().toString());
        }
    }
     
    public void exportTransactions(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Transactions", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {0.5f, 4.0f, 4.0f, 3.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}