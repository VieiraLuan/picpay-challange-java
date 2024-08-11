package usecase;

import core.domain.Transaction;
import core.domain.User;

public interface IUserNotificationUseCase {

    Boolean notifyUser(Transaction transaction, String email) throws Exception;



}
