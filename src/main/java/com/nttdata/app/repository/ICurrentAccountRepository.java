package com.nttdata.app.repository;

import com.nttdata.app.document.CurrentAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICurrentAccountRepository extends ReactiveMongoRepository<CurrentAccount, String> {
}
