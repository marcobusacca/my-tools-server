package it.mytools.spring.db.serv.tracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mytools.spring.db.pojo.tracker.Wallet;
import it.mytools.spring.db.repo.tracker.WalletRepository;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    public Wallet findById(int id) {
        return walletRepository.findById(id).orElse(null);
    }

    public void save(Wallet wallet) {
        if (wallet == null) {
            return;
        }
        walletRepository.save(wallet);
    }

    public void delete(Wallet wallet) {
        if (wallet == null) {
            return;
        }
        walletRepository.delete(wallet);
    }
}
