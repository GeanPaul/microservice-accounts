package com.nttdata.app.service.impl;

import com.nttdata.app.document.CurrentAccount;
import com.nttdata.app.document.SavingsAccount;
import com.nttdata.app.repository.ICurrentAccountRepository;
import com.nttdata.app.service.ICurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ICurrentAccountServiceImpl implements ICurrentAccountService {

    @Autowired
    private ICurrentAccountRepository currentAccountRepository;


    @Override
    public Flux<CurrentAccount> getAllCurrentAccount() {
        return currentAccountRepository.findAll();
    }

    @Override
    public Mono<CurrentAccount> getFindAllByIdCurrentAccount(String id) {
        return currentAccountRepository.findById(id);
    }

    @Override
    public Mono<CurrentAccount> createCurrentAccount(CurrentAccount account) {
        return currentAccountRepository.save(account);
    }

    @Override
    public Mono<CurrentAccount> updateCurrentAccount(CurrentAccount account) {
        return currentAccountRepository.save(account);
    }

    @Override
    public Mono<Void> deleteCurrentAccount(CurrentAccount account)
    {
        return currentAccountRepository.delete(account);
    }


    public  Flux<CurrentAccount> getCurrentAccountByIdCustomer(String idCustomer)
    {
        return currentAccountRepository.findAllByIdCustomer(idCustomer);
    }

}
