package application.usecase;

import core.domain.Transaction;
import usecase.ITransactionValidateUseCase;

public class TransactionValidateImpl implements ITransactionValidateUseCase {

    private final ITransactionValidateUseCase _transactionValidateUseCase;

    public TransactionValidateImpl(ITransactionValidateUseCase transactionValidateUseCase) {
        _transactionValidateUseCase = transactionValidateUseCase;
    }

    @Override
    public Boolean validate(Transaction transaction) throws Exception {
        if (!_transactionValidateUseCase.validate(transaction)) {
            throw new Exception("Erro ao criar transação");
        }

        return true;
    }
}
