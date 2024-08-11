package application.usecase;

import application.gateway.IUserNotificationGateway;
import core.domain.Transaction;
import usecase.IUserNotificationUseCase;

public class UserNotificationImpl implements IUserNotificationUseCase {

    private final IUserNotificationGateway _userNotificationGateway;

    public UserNotificationImpl(IUserNotificationGateway userNotificationGateway) {
        _userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notifyUser(Transaction transaction, String email) throws Exception {

        if (!_userNotificationGateway.notifyUser(transaction, email)) {
            throw new Exception("Erro ao notificar usuário");
        }

        return true;
    }
}
