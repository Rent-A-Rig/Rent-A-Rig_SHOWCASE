package cova.rar.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cova.rar.entities.Login;
import cova.rar.entities.User;

@Component
public class LoginValidator implements Validator{
	 @Override
	   public boolean supports(Class<?> clazz) {
	      return Login.class.equals(clazz);
	   }
	 @Override
	   public void validate(Object obj, Errors err) {

	      ValidationUtils.rejectIfEmptyOrWhitespace(err, "username", "err.username", "Username is required");
	      ValidationUtils.rejectIfEmptyOrWhitespace(err, "password", "err.password", "Password is required");
	 }
}
