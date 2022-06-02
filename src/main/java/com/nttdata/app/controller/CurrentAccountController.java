package com.nttdata.app.controller;
import com.nttdata.app.document.CurrentAccount;
import com.nttdata.app.document.SavingsAccount;
import com.nttdata.app.service.impl.ICurrentAccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
@RequestMapping("/current-accounts")
public class CurrentAccountController {

    @Autowired
    private ICurrentAccountServiceImpl currentAccountServiceImpl;

    @GetMapping
    public Flux<CurrentAccount> findAllCurrentAccount() {
        log.info("Accounts get All");
        return currentAccountServiceImpl.getAllCurrentAccount();

    }

    @GetMapping("/{id}")
    public Mono<CurrentAccount> findAllCurrentAccountById(@PathVariable String id) {
        log.info("Savings Account get id: " + id);
        return currentAccountServiceImpl.getFindAllByIdCurrentAccount(id);

    }

    @PostMapping("/create")
    public Mono<CurrentAccount> saveCurrentAccount(@RequestBody CurrentAccount account) {
        log.info("Savings Accounts created \n" + account.toString());
        return currentAccountServiceImpl.createCurrentAccount(account);

    }

    @PutMapping("/update")
    public Mono<CurrentAccount> updateCurrentAccount(@RequestBody CurrentAccount account) {

        Mono<CurrentAccount> mono = currentAccountServiceImpl.getFindAllByIdCurrentAccount(account.getIdCurrentAccount());
        return mono.flatMap(ac -> {
            ac.setTypeAccount(account.getTypeAccount());
            ac.setNumberCurrentAccount(account.getNumberCurrentAccount());
            ac.setAccountBalance(account.getAccountBalance());
            ac.setMaintenanceCost(account.getMaintenanceCost());
            ac.setIdCustomer(account.getIdCustomer());
            log.info("Savings Accounts by id: " + account.getIdCurrentAccount() + " " + "updated");
            return currentAccountServiceImpl.updateCurrentAccount(ac);
        });
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteCurrentAccount(@PathVariable String id) {
        Mono<CurrentAccount> mono = currentAccountServiceImpl.getFindAllByIdCurrentAccount(id);
        return mono.flatMap(ac -> {
            log.info("Savings Account by id: " + id + " " + "delete");
            return currentAccountServiceImpl.deleteCurrentAccount(ac);
        });


    }

    @GetMapping("/customer/{idCustomer}")
    public Flux<CurrentAccount> getAllCurrentAccountsPersonalByIdCustomer(@PathVariable String idCustomer)
    {
        return  currentAccountServiceImpl.getCurrentAccountByIdCustomer(idCustomer);

    }


}
