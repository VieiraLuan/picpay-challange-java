package application.usecase;

import application.gateway.IConsultBalanceGateway;
import core.domain.Wallet;
import usecase.IConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceImpl implements IConsultBalanceUseCase {

    private final IConsultBalanceGateway _consultBalanceGateway;

    public ConsultBalanceImpl(IConsultBalanceGateway consultBalanceGateway) {
        _consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consultBalance(Wallet wallet) throws Exception {
        var balance = _consultBalanceGateway.consultBalance(wallet);

        if (balance == null) {
            throw new Exception("Erro ao recuperar o saldo.");
        }

        return balance;
    }
}
