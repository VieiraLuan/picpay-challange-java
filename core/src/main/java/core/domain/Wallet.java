package core.domain;

import core.enums.ErrorCodeEnum;
import core.enums.UserTypeEnum;
import core.exception.TaxNumberException;
import core.exception.TransferException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wallet {
    private Long id;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(BigDecimal balance, User user) {
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet(Long id, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Wallet() {

    }


    public void receiveValue(BigDecimal value) {
        this.balance = balance.add(value);
    }

    public void transfer (BigDecimal value) throws TransferException {
        if(this.user.getType() == UserTypeEnum.SHOPKEEPER){
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.ON0001.getCode());
        }

        if(this.balance.compareTo(value) < 0){
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());

        }

        this.balance.subtract(value);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
