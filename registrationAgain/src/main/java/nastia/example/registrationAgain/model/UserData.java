package nastia.example.registrationAgain.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class UserData implements Serializable {

    @NotEmpty(message = "First name can not be empty")
    private String firstName;

    @NotEmpty(message = "Lastname cannot be empty")
    private String lastname;

    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
    private String email;

    @NotEmpty(message = "Password can not be empty")
    private String password;
}
