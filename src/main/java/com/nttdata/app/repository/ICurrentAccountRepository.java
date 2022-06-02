package com.nttdata.app.repository;

import com.nttdata.app.document.CurrentAccount;
import com.nttdata.app.document.SavingsAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ICurrentAccountRepository extends ReactiveMongoRepository<CurrentAccount, String> {
    Flux<CurrentAccount> findAllByIdCustomer(String idCustomer);
}
