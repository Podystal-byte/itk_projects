package org.example.task3.task3_3;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {
    private Integer id;
    private final AtomicLong bankBill;

    public BankAccount(Long bankBill) {
        this.bankBill = new AtomicLong(bankBill);
    }

    public Long deposit(Long deposit){
        return bankBill.addAndGet(deposit);
    }

    public Long withdraw(Long withdraw){
        if (bankBill.longValue() < withdraw){
            throw new IllegalArgumentException("Недостаточно средств на счете");
        }

        return bankBill.addAndGet(-withdraw);
    }

    public Long getBalance(){
        return bankBill.get();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(id, that.id) && Objects.equals(bankBill, that.bankBill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankBill);
    }
}
