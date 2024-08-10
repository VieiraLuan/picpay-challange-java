package core.domain;

import core.enums.TransactionStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private Long id;
    private Wallet fromWallet;
    private Wallet toWallet;
    private BigDecimal value;
    private TransactionStatusEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Transaction() {
    }

    public Transaction(Wallet fromWallet, Wallet toWallet, BigDecimal value, TransactionStatusEnum status, LocalDateTime createdAt) {
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = TransactionStatusEnum.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public Transaction(Long id, Wallet fromWallet, Wallet toWallet, BigDecimal value, TransactionStatusEnum status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && fromWallet.equals(that.fromWallet) && toWallet.equals(that.toWallet) && value.equals(that.value) && status == that.status && createdAt.equals(that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + fromWallet.hashCode();
        result = 31 * result + toWallet.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + Objects.hashCode(updatedAt);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wallet getFromWallet() {
        return fromWallet;
    }

    public void setFromWallet(Wallet fromWallet) {
        this.fromWallet = fromWallet;
    }

    public Wallet getToWallet() {
        return toWallet;
    }

    public void setToWallet(Wallet toWallet) {
        this.toWallet = toWallet;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
