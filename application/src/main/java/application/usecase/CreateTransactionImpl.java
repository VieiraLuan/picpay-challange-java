package application.usecase;

import application.gateway.ICreateTransactionGateway;
import core.domain.Transaction;
import usecase.ICreateTransactionUseCase;

public class CreateTransactionImpl implements ICreateTransactionUseCase {

    private final ICreateTransactionGateway _createTransactionGateway;

    public CreateTransactionImpl(ICreateTransactionGateway createTransactionGateway) {
        _createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) throws Exception {
        var result = _createTransactionGateway.createTransaction(transaction);

        if (result == null) {
            throw new Exception("Não foi possível criar a transação");
        }

        return result;
    }
}
