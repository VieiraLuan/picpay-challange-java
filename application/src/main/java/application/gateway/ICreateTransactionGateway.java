package application.gateway;

import core.domain.Transaction;

public interface ICreateTransactionGateway {
    Transaction createTransaction(Transaction transaction);
}
