package application.gateway;

import core.domain.Wallet;

public interface IFindWalletByTaxNumberGateway {
    Wallet findByTaxNumber (String taxNumber);
}
