package usecase;

import core.domain.Wallet;

import java.math.BigDecimal;

public interface IConsultBalanceUseCase {

    BigDecimal consultBalance(Wallet wallet) throws Exception;

}
