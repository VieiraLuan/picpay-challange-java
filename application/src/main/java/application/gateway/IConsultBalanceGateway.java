package application.gateway;

import core.domain.Wallet;

import java.math.BigDecimal;

public interface IConsultBalanceGateway {

    BigDecimal consultBalance(Wallet wallet);

}
