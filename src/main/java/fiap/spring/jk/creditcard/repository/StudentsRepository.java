package fiap.spring.jk.creditcard.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fiap.spring.jk.creditcard.model.Student;


@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
    
}


