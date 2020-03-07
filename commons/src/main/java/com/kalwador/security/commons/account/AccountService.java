package com.kalwador.security.commons.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AccountService extends UserDetailsService {
    @Override
    Account loadUserByUsername(String username) throws UsernameNotFoundException;

    Account get(Long id);

    boolean exists(Long id);

    Account create(Account account);

    Page<Account> all(Pageable pageable);

    void delete(Long id);
}
