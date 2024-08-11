package usecase;

import core.domain.Wallet;

public interface IFindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber (String taxNumber) throws Exception;
}
