package application.usecase;

import application.gateway.IFindWalletByTaxNumberGateway;
import core.domain.Wallet;
import usecase.IFindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberImpl implements IFindWalletByTaxNumberUseCase {

    private final IFindWalletByTaxNumberGateway _findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberImpl(IFindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        _findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        var wallet = _findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);

        if (wallet == null) {
            throw new Exception("Carteira não encontrada");
        }

        return wallet;
    }
}
