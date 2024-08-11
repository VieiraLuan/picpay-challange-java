package usecase;

import core.domain.Transaction;

public interface ITransactionValidateUseCase {
    Boolean validate(Transaction transaction) throws Exception;
}
