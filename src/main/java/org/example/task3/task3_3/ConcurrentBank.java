package org.example.task3.task3_3;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentBank {
    private final ConcurrentHashMap<Integer,BankAccount> listBankAccount;
    private int id = 0;

    public ConcurrentBank() {
        this.listBankAccount = new ConcurrentHashMap<>();
    }


    public BankAccount createAccount(Long value){
        if (value < 0){
            throw new IllegalArgumentException("Счет не может быть отрицательным");
        }

        BankAccount bankAccount = new BankAccount(value);
        bankAccount.setId(id);
        id++;
        listBankAccount.put(bankAccount.getId(), bankAccount);
        return bankAccount;
    }

    public synchronized void transfer(BankAccount bankAccount1, BankAccount bankAccount2, Long value){
        if (bankAccount1.getBalance() < value){
            throw  new IllegalArgumentException("Нет денег для перевода");
        }

        Optional<BankAccount> mapBankAcc1 = Optional.ofNullable(listBankAccount.get(bankAccount1.getId()));
        Optional<BankAccount> mapBankAcc2 = Optional.ofNullable(listBankAccount.get(bankAccount2.getId()));

        if (mapBankAcc1.isEmpty() || mapBankAcc2.isEmpty()){
            throw new IllegalArgumentException("Данных аккаунтов не существует");
        }

        bankAccount1.withdraw(value);
        bankAccount2.deposit(value);
    }

    public long getTotalBalance() {
        long total = 0;
        for (BankAccount account : listBankAccount.values()) {
            total += account.getBalance();
        }
        return total;
    }
}
