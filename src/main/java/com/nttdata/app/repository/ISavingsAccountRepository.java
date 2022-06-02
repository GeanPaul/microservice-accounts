package com.nttdata.app.repository;

import com.nttdata.app.document.CurrentAccount;
import com.nttdata.app.document.SavingsAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ISavingsAccountRepository extends ReactiveMongoRepository<SavingsAccount, String> {

    Mono<SavingsAccount> findByIdCustomer(String idCustomer);



}
