package fiap.spring.jk.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.spring.jk.creditcard.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}