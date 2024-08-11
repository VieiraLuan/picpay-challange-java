package application.usecase;

import application.gateway.ICreateUserGateway;
import core.domain.TransactionPin;
import core.domain.User;
import core.domain.Wallet;
import core.enums.ErrorCodeEnum;
import core.exception.EmailException;
import usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements ICreateUserUseCase {

    private final ITaxNumberAvailableUseCase _taxNumberAvailableUseCase;

    private final IEmailAvailableUseCase _emailAvailableUseCase;

    private final ICreateUserGateway _createUserGateway;


    public CreateUserUseCaseImpl(
            ITaxNumberAvailableUseCase _taxNumberAvailableUseCase,
            IEmailAvailableUseCase _emailAvailableUseCase,
            ICreateUserGateway createUserGateway
    ) {
        this._taxNumberAvailableUseCase = _taxNumberAvailableUseCase;
        this._emailAvailableUseCase = _emailAvailableUseCase;
        this._createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws Exception {

        if (_taxNumberAvailableUseCase.isTaxNumberAvailable(user.getTaxNumber().toString())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        if (_emailAvailableUseCase.emailAvailable(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }

        if (!_createUserGateway.create(user, new Wallet(BigDecimal.ZERO, user), new TransactionPin(user, pin))) {
            throw new Exception("Erro ao criar usuário, carteira e pin");
        }


    }
}
