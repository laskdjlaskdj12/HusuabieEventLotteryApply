package com.horyu1234.husuabieventlotteryapply.service;

import com.horyu1234.husuabieventlotteryapply.database.dao.AccountDAO;
import com.horyu1234.husuabieventlotteryapply.domain.Account;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by horyu on 2018-04-04
 */
@Service
public class AccountService {
    private AccountDAO accountDAO;

    @PostConstruct
    public void init() {
        accountDAO.createTableIfNotExist();
    }

    @Autowired
    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account login(String username, String password) {
        List<Account> storedAccounts = accountDAO.getAccount(username);
        if (storedAccounts.isEmpty()) {
            return null;
        }

        Account storedAccount = storedAccounts.get(0);
        if (BCrypt.checkpw(username + "/" + password, storedAccount.getPassword())) {
            return storedAccount;
        }

        return null;
    }
}
