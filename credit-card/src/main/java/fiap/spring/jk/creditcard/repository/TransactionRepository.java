package fiap.spring.jk.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.spring.jk.creditcard.model.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
}