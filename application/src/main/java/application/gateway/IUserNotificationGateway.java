package application.gateway;

import core.domain.Transaction;

public interface IUserNotificationGateway {

    Boolean notifyUser(Transaction transaction, String email);



}
