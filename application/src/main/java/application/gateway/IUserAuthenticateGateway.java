package application.gateway;

public interface IUserAuthenticateGateway {

    Boolean authenticate(String username, String password);
}
