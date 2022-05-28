package com.nttdata.app.repository;

import com.nttdata.app.document.FixedTermAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IFixedTermAccountRepository extends ReactiveMongoRepository<FixedTermAccount, String> {
}
