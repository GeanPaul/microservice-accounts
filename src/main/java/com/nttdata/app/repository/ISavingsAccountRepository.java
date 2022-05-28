package com.nttdata.app.repository;

import com.nttdata.app.document.SavingsAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ISavingsAccountRepository extends ReactiveMongoRepository<SavingsAccount, String> {
}
