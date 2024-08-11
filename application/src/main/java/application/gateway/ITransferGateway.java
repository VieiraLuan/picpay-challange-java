package application.gateway;

import core.domain.Transaction;

import java.math.BigDecimal;

public interface ITransferGateway {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value);
}
