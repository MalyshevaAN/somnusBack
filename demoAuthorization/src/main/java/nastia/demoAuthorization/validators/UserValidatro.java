package nastia.demoAuthorization.validators;


import nastia.demoAuthorization.model.User;
import nastia.demoAuthorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

@Component
public class UserValidatro  implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass){
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
        if(!user.getEmail().contains("@") || user.getEmail().length()>32){
            errors.rejectValue("email", "Size.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if(user.getPassword().length() < 8 || user.getPassword().length() > 32){
            errors.rejectValue("password", "Size.userForm.email");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }

}

