package application.usecase;

import application.gateway.IEmailAvailableGateway;
import usecase.IEmailAvailableUseCase;

public class EmailAvailableImpl implements IEmailAvailableUseCase {

    private final IEmailAvailableGateway _emailAvailableGateway;

    public EmailAvailableImpl(IEmailAvailableGateway emailAvailableGateway) {
        this._emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return _emailAvailableGateway.emailAvailable(email);
    }
}
