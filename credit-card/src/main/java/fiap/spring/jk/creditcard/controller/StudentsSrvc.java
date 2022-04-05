package fiap.spring.jk.creditcard.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import fiap.spring.jk.creditcard.model.Student;
@RestController
public class StudentsSrvc {
    
    @Autowired
    private fiap.spring.jk.creditcard.repository.StudentsRepository StudentsRepos;


    @GetMapping("/students/export/pdf")
    public void exportStudentsToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Student> listUsers = StudentsRepos.findAll();
         
        UserPDFExporter exporter = new UserPDFExporter(listUsers);
        exporter.exportStudents(response);    
    }


    @GetMapping(value="/students")
    public List<Student> getStudents() {
        return StudentsRepos.findAll();
    }

    @PostMapping(value="/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student insertStudent(@RequestBody Student student){
        return StudentsRepos.save(student);
    }
    
    @GetMapping(value="/students/{Id}")
    public Optional<Student> getStudentById(@PathVariable("Id") Long id){
        Optional<Student> student = StudentsRepos.findById(id);
        return student;
    }

    @PutMapping(value="/students/{Id}")
    public Student updateStudentById(@PathVariable("Id") Long id, @RequestBody Student studentBody){
        Optional<Student> student = StudentsRepos.findById(id);
        Student _student = student.get();
        if(student.isPresent()){
            _student.setFullName(studentBody.getFullName());
            _student.setEmail(studentBody.getEmail());
            _student.setRegistration(studentBody.getRegistration());
            //_student.setRegistrationCardNumber(studentBody.getRegistrationCardNumber());
            _student.setCardNumber(studentBody.getCardNumber());
            _student.setDateCreated(new Date().toString());
            _student.setDateUpdated(new Date().toString());

            return StudentsRepos.save(_student);
        }else{
            return _student;
        }
 
    }


}