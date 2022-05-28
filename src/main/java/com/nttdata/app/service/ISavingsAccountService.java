package com.nttdata.app.service;

import com.nttdata.app.document.FixedTermAccount;
import com.nttdata.app.document.SavingsAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ISavingsAccountService {
    Flux<SavingsAccount> getAllSavingsAccount();

    Mono<SavingsAccount> getFindAllByIdSavingsAccount(String id);

    Mono<SavingsAccount> createSavingsAccount(SavingsAccount account);

    Mono<SavingsAccount> updateSavingsAccount(SavingsAccount account);

    Mono<Void> deleteSavingsAccount(SavingsAccount account);
}
