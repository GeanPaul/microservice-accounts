package com.nttdata.app.service;

import com.nttdata.app.document.CurrentAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICurrentAccountService {
    Flux<CurrentAccount> getAllCurrentAccount();

    Mono<CurrentAccount> getFindAllByIdCurrentAccount(String id);

    Mono<CurrentAccount> createCurrentAccount(CurrentAccount account);

    Mono<CurrentAccount> updateCurrentAccount(CurrentAccount account);

    Mono<Void> deleteCurrentAccount(CurrentAccount account);
}
