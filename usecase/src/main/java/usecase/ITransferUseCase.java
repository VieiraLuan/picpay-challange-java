package usecase;

import core.domain.Transaction;

import java.math.BigDecimal;

public interface ITransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal amount) throws Exception;
}
