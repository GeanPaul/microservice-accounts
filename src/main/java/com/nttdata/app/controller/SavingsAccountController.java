package com.nttdata.app.controller;

import com.nttdata.app.document.SavingsAccount;
import com.nttdata.app.service.impl.ISavingsAccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
@RequestMapping("/savings-accounts")
public class SavingsAccountController {

    @Autowired
    private ISavingsAccountServiceImpl savingsAccountServiceImpl;

    @GetMapping
    public Flux<SavingsAccount> findAllSavingsAccounts() {
        log.info("Accounts get All");
        return savingsAccountServiceImpl.getAllSavingsAccount();

    }

    @GetMapping("/{id}")
    public Mono<SavingsAccount> findAllSavingsAccountById(@PathVariable String id) {
        log.info("Savings Account get id: " + id);
        return savingsAccountServiceImpl.getFindAllByIdSavingsAccount(id);

    }

    @PostMapping("/create")
    public Mono<SavingsAccount> saveSavingsAccount(@RequestBody SavingsAccount account) {
        log.info("Savings Accounts created \n" + account.toString());
        return savingsAccountServiceImpl.createSavingsAccount(account);

    }

    @PutMapping("/update")
    public Mono<SavingsAccount> updatesavingsAccount(@RequestBody SavingsAccount account) {

        Mono<SavingsAccount> mono = savingsAccountServiceImpl.getFindAllByIdSavingsAccount(account.getIdSavingsAccount());
        return mono.flatMap(ac -> {
            ac.setTypeAccount(account.getTypeAccount());
            ac.setNumberAccount(account.getNumberAccount());
            ac.setAccountBalance(account.getAccountBalance());
            ac.setMaintenanceCost(account.getMaintenanceCost());
            ac.setMovementLimit(account.getMovementLimit());
            ac.setIdCustomer(account.getIdCustomer());
            log.info("Savings Accounts by id: " + account.getIdSavingsAccount() + " " + "updated");
            return savingsAccountServiceImpl.updateSavingsAccount(ac);
        });
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteSavingsAccount(@PathVariable String id) {
        Mono<SavingsAccount> mono = savingsAccountServiceImpl.getFindAllByIdSavingsAccount(id);
        return mono.flatMap(ac -> {
            log.info("Savings Account by id: " + id + " " + "delete");
            return savingsAccountServiceImpl.deleteSavingsAccount(ac);
        });


    }

    @GetMapping("/personalcustomer/{idCustomer}")
    public Mono<SavingsAccount> getAllSavingsAccountByIdCustomer(@PathVariable String idCustomer)
    {
        return  savingsAccountServiceImpl.getSavingsAccountByIdCustomer(idCustomer);

    }


}
