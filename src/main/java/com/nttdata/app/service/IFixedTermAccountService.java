package com.nttdata.app.service;

import com.nttdata.app.document.FixedTermAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFixedTermAccountService {
    Flux<FixedTermAccount> getAllFixedTermAccount();

    Mono<FixedTermAccount> getFindAllByIdFixedTermAccount(String id);

    Mono<FixedTermAccount> createFixedTermAccount(FixedTermAccount account);

    Mono<FixedTermAccount> updateFixedTermAccount(FixedTermAccount account);

    Mono<Void> deleteFixedTermAccount(FixedTermAccount account);
}
