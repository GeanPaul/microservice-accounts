package com.nttdata.app.controller;

import com.nttdata.app.document.FixedTermAccount;
import com.nttdata.app.document.SavingsAccount;
import com.nttdata.app.service.impl.IFixedTermAccountServiceImpl;
import com.nttdata.app.service.impl.ISavingsAccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
@RequestMapping("/fixedterm-accounts")
public class FixedTermAccountController {

    @Autowired
    private IFixedTermAccountServiceImpl FixedTermAccountServiceImpl;

    @GetMapping
    public Flux<FixedTermAccount> findAllFixedTermAccount() {
        log.info("Accounts get All");
        return FixedTermAccountServiceImpl.getAllFixedTermAccount();

    }

    @GetMapping("/{id}")
    public Mono<FixedTermAccount> findAllFixedTermAccount(@PathVariable String id) {
        log.info("Savings Account get id: " + id);
        return FixedTermAccountServiceImpl.getFindAllByIdFixedTermAccount(id);

    }

    @PostMapping("/create")
    public Mono<FixedTermAccount> saveFixedTermAccount(@RequestBody FixedTermAccount account) {
        log.info("Savings Accounts created \n" + account.toString());
        return FixedTermAccountServiceImpl.createFixedTermAccount(account);

    }

    @PutMapping("/update")
    public Mono<FixedTermAccount> updatesavingsAccount(@RequestBody FixedTermAccount account) {

        Mono<FixedTermAccount> mono = FixedTermAccountServiceImpl.getFindAllByIdFixedTermAccount(account.getIdFixedTermAccount());
        return mono.flatMap(ac -> {
            ac.setTypeAccount(account.getTypeAccount());
            ac.setNumberFixedTermAccount(account.getNumberFixedTermAccount());
            ac.setAccountBalance(account.getAccountBalance());
            ac.setMovementLimit(account.getMovementLimit());
            ac.setMoveDate(account.getMoveDate());
            ac.setIdCustomer(account.getIdCustomer());

            log.info("Savings Accounts by id: " + account.getIdFixedTermAccount() + " " + "updated");
            return FixedTermAccountServiceImpl.updateFixedTermAccount(ac);
        });
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteSavingsAccount(@PathVariable String id) {
        Mono<FixedTermAccount> mono = FixedTermAccountServiceImpl.getFindAllByIdFixedTermAccount(id);
        return mono.flatMap(ac -> {
            log.info("Savings Account by id: " + id + " " + "delete");
            return FixedTermAccountServiceImpl.deleteFixedTermAccount(ac);
        });


    }


}
