package com.kalwador.security.commons.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AccountServiceImpl implements AccountService {
    private static final String ACCOUNT_NOT_EXISTS = "Account not exists";
    private AccountRepository accountRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public AccountServiceImpl(AccountRepository accountRepository, BCryptPasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void initDB() {
        var account = new Account();
        account.setUsername("admin");
        account.setPassword(passwordEncoder.encode("admin"));
        account.setRole(Role.ADMIN);
        accountRepository.save(account);
    }

    @Override
    public Account get(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException(ACCOUNT_NOT_EXISTS));
    }

    @Override
    public Account loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByUsername(username).orElseThrow(() -> new RuntimeException(ACCOUNT_NOT_EXISTS));
    }

    @Override
    public Page<Account> all(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public boolean exists(Long id) {
        return accountRepository.existsById(id);
    }

    @Override
    public Account create(Account account) {
        account.setRole(Role.USER);
        return accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        if (!exists(id)) throw new RuntimeException(ACCOUNT_NOT_EXISTS);
        accountRepository.deleteById(id);
    }
}
