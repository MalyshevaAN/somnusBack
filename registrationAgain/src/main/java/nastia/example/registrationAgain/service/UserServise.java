package nastia.example.registrationAgain.service;


import nastia.example.registrationAgain.model.UserData;
import nastia.example.registrationAgain.model.UserEntity;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;

public interface UserServise {


    void register(final UserData user) throws Exception;

    boolean checjIfUserExists(final String email);
    void sendRegistrationConfirmationEmail(final UserEntity user);
    boolean verifyUser(final String token) throws InvalidCsrfTokenException;
    UserEntity getUserById(final String id) throws UnknownError;
}
