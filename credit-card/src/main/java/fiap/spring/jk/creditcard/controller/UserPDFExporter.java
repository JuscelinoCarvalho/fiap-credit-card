package fiap.spring.jk.creditcard.controller;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import fiap.spring.jk.creditcard.model.Student;
 
 
public class UserPDFExporter {
    private List<Student> listUsers;

    public UserPDFExporter(List<Student> vlistUsers) {
        this.listUsers = vlistUsers;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("id", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("full_name", font));
        table.addCell(cell);
         
        //cell.setPhrase(new Phrase("registration", font));
        //table.addCell(cell);
         
        //cell.setPhrase(new Phrase("card_number", font));
        //table.addCell(cell);
         
        cell.setPhrase(new Phrase("reg_card_number", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("email", font));
        table.addCell(cell);

        //cell.setPhrase(new Phrase("date_created", font));
        //table.addCell(cell);
        
        //cell.setPhrase(new Phrase("date_updated", font));
        //table.addCell(cell);
        
        //cell.setPhrase(new Phrase("active", font));
        //table.addCell(cell);
    
    }
     
    private void writeTableData(PdfPTable table) {
        for (Student user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getFullName());
            //table.addCell(user.getRegistration());
            //table.addCell(user.getCardNumber());
            table.addCell(user.getRegistrationCardNumber());
            table.addCell(user.getEmail());
            //table.addCell(user.getDateCreated());
            //table.addCell(user.getDateUpdated());
            //table.addCell("true");
        }
    }
     
    public void exportStudents(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Students", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {2.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}