package application.usecase;

import application.gateway.ITransferGateway;
import core.domain.Transaction;
import core.domain.Wallet;
import usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements ITransferUseCase {

    private final ITransferGateway _transferGateway;
    private final IFindWalletByTaxNumberUseCase _findWalletByTaxNumberUseCase;
    private final ITransactionValidateUseCase _transactionValidateUseCase;
    private final ICreateTransactionUseCase _createTransactionUseCase;
    private final IUserNotificationUseCase _userNotificationUseCase;


    public TransferUseCaseImpl(ITransferGateway transferGateway, IFindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, ITransactionValidateUseCase transactionValidateUseCase, ICreateTransactionUseCase createTransactionUseCase, IUserNotificationUseCase userNotificationUseCase) {
        _transferGateway = transferGateway;
        _findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        _transactionValidateUseCase = transactionValidateUseCase;
        _createTransactionUseCase = createTransactionUseCase;
        _userNotificationUseCase = userNotificationUseCase;
    }


    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal amount) throws Exception {

        Wallet fromWallet = _findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet toWallet = _findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        fromWallet.transfer(amount);
        toWallet.receiveValue(amount);

        Transaction transactionCreated = _createTransactionUseCase.createTransaction(new Transaction(fromWallet, toWallet, amount));

        _transactionValidateUseCase.validate(transactionCreated);

        if (!_transferGateway.transfer(fromTaxNumber, toTaxNumber, amount)) {
            throw new Exception("Erro ao realizar transferência");
        }

        if (!_userNotificationUseCase.notifyUser(transactionCreated, toWallet.getUser().getEmail())) {
            throw new Exception("Erro ao notificar o usuário");
        }

        return true;
    }
}
