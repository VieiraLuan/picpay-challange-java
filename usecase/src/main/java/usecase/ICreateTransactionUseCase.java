package usecase;

import core.domain.Transaction;

public interface ICreateTransactionUseCase {
    Transaction createTransaction(Transaction transaction) throws Exception;
}
