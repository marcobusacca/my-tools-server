package it.mytools.spring.restcontroller.tracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mytools.spring.db.pojo.tracker.Wallet;
import it.mytools.spring.db.serv.tracker.WalletService;

@RestController
@RequestMapping("/api/tracker/wallets")
public class WalletRestController {

    @Autowired
    private WalletService walletService;

    @GetMapping
    public ResponseEntity<List<Wallet>> getWallets() {

        List<Wallet> wallets = walletService.findAll();

        return new ResponseEntity<>(wallets, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> storeWallet(@RequestBody Wallet walletForm) {

        String walletName = walletForm.getName();
        double walletBalance = walletForm.getBalance();

        Wallet wallet = new Wallet(walletName, walletBalance);

        walletService.save(wallet);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<String> toggleWalletActive(@PathVariable int id) {
        Wallet wallet = walletService.findById(id);

        wallet.setActive(!wallet.isActive());

        walletService.save(wallet);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
