package application.usecase;

import usecase.IUserAuthenticate;

public class UserAuthenticateUseCaseImpl implements IUserAuthenticate {
    private final IUserAuthenticate _userAuthenticate;

    public UserAuthenticateUseCaseImpl(IUserAuthenticate userAuthenticate) {
        _userAuthenticate = userAuthenticate;
    }


    @Override
    public Boolean authenticate(String username, String password) throws Exception {

        if (!_userAuthenticate.authenticate(username, password)) {
            throw new Exception("Usuário não autenticado");
        }

        return true;
    }
}
