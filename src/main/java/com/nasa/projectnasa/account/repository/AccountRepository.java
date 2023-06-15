package com.nasa.projectnasa.account.repository;

import com.nasa.projectnasa.account.entity.Account;
import com.nasa.projectnasa.account.entity.AuthProvider;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

  Optional<Account> findByEmail(String email);

}
