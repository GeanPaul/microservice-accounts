package com.nttdata.app.service.impl;

import com.nttdata.app.document.SavingsAccount;
import com.nttdata.app.repository.ISavingsAccountRepository;
import com.nttdata.app.service.ISavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ISavingsAccountServiceImpl implements ISavingsAccountService {

    @Autowired
    private ISavingsAccountRepository savingsAccountRepository;


    @Override
    public Flux<SavingsAccount> getAllSavingsAccount() {
        return savingsAccountRepository.findAll();
    }

    @Override
    public Mono<SavingsAccount> getFindAllByIdSavingsAccount(String id) {
        return savingsAccountRepository.findById(id);
    }

    @Override
    public Mono<SavingsAccount> createSavingsAccount(SavingsAccount account) {
        return savingsAccountRepository.save(account);
    }

    @Override
    public Mono<SavingsAccount> updateSavingsAccount(SavingsAccount account) {
        return savingsAccountRepository.save(account);
    }

    @Override
    public Mono<Void> deleteSavingsAccount(SavingsAccount account)
    {
        return savingsAccountRepository.delete(account);
    }
}
