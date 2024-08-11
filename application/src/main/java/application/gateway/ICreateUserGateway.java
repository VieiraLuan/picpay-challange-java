package application.gateway;

import core.domain.TransactionPin;
import core.domain.User;
import core.domain.Wallet;

public interface ICreateUserGateway {
    Boolean create(User user, Wallet wallet, TransactionPin transactionPin);

}
