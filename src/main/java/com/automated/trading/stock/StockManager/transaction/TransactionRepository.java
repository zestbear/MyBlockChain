package com.automated.trading.stock.StockManager.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}