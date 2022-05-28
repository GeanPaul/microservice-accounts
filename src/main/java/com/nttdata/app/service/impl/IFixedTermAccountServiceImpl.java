package com.nttdata.app.service.impl;

import com.nttdata.app.document.FixedTermAccount;
import com.nttdata.app.repository.IFixedTermAccountRepository;
import com.nttdata.app.service.IFixedTermAccountService;
import com.nttdata.app.service.ISavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IFixedTermAccountServiceImpl implements IFixedTermAccountService {

    @Autowired
    private IFixedTermAccountRepository fixedTermAccountRepository;


    @Override
    public Flux<FixedTermAccount> getAllFixedTermAccount() {
        return fixedTermAccountRepository.findAll();
    }

    @Override
    public Mono<FixedTermAccount> getFindAllByIdFixedTermAccount(String id) {
        return fixedTermAccountRepository.findById(id);
    }

    @Override
    public Mono<FixedTermAccount> createFixedTermAccount(FixedTermAccount account) {
        return fixedTermAccountRepository.save(account);
    }

    @Override
    public Mono<FixedTermAccount> updateFixedTermAccount(FixedTermAccount account) {
        return fixedTermAccountRepository.save(account);
    }

    @Override
    public Mono<Void> deleteFixedTermAccount(FixedTermAccount account)
    {
        return fixedTermAccountRepository.delete(account);
    }
}
