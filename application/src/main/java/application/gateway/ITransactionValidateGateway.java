package application.gateway;

import core.domain.Transaction;

public interface ITransactionValidateGateway {
    Boolean validate(Transaction transaction);
}
