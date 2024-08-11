package application.usecase;

import application.gateway.ITaxNumberAvailableGateway;
import usecase.ITaxNumberAvailableUseCase;

public class TaxNumberAvailableImpl implements ITaxNumberAvailableUseCase {

    private final ITaxNumberAvailableGateway _taxNumberAvailableGateway;

    public TaxNumberAvailableImpl(ITaxNumberAvailableGateway taxNumberAvailableGateway) {
        this._taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean isTaxNumberAvailable(String taxNumber) {
        return _taxNumberAvailableGateway.isTaxNumberAvailable(taxNumber);
    }
}
