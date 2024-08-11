package usecase;

import core.domain.User;
import core.exception.EmailException;
import core.exception.TransactionPinExpection;

public interface ICreateUserUseCase {

    void create(User user, String pin) throws Exception;

}
