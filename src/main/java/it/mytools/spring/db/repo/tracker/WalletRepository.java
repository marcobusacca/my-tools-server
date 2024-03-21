package it.mytools.spring.db.repo.tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.mytools.spring.db.pojo.tracker.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
