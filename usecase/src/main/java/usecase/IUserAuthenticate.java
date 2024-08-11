package usecase;

public interface IUserAuthenticate {

    Boolean authenticate(String username, String password) throws Exception;
}
