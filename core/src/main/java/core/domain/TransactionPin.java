package core.domain;

import core.enums.ErrorCodeEnum;

import java.time.LocalDateTime;

import core.exception.TransactionPinExpection;

public class TransactionPin {

    private long id;
    private User user;
    private String pin;
    private int attempt;
    private boolean blocked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TransactionPin(long id, User user, String pin, int attempt, boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TransactionPin(User user, String pin) throws TransactionPinExpection {
        this.user = user;
        this.setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {
    }

    private void isValid(String pin) throws TransactionPinExpection {
        if (pin.length() != 8)
            throw new TransactionPinExpection(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getMessage());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinExpection {
        isValid(pin);
        this.pin = pin;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
