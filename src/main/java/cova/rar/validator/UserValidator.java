package cova.rar.validator;

import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import cova.rar.entities.User;

import org.springframework.validation.Validator;


/**
 * @author imssbora
 */
@Component
public class UserValidator implements Validator {

   @Override
   public boolean supports(Class<?> clazz) {
      return User.class.equals(clazz);
   }

   @Override
   public void validate(Object obj, Errors err) {

      ValidationUtils.rejectIfEmptyOrWhitespace(err, "username", "err.username", "Username is required");
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "password", "err.password", "Password is required");
      
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "firstname", "error.firstname", "First name is required.");
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "lastname", "error.lastname", "Last name is required.");
      
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "email", "error.email", "Email is required.");
      User user = (User) obj;

      Pattern emailPattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");     
      if (!(emailPattern.matcher(user.getEmail()).matches())) {
         err.rejectValue("email", "user.email.invalid","Invalid email format!");  
      }
      
      
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "phone", "error.phone", "PhoneNumber is required.");
      Pattern phonePattern = Pattern.compile("^((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}$");
      if (!(phonePattern.matcher(user.getPhone()).matches())) {
          err.rejectValue("phone", "user.phone.invalid","Invalid phone format! Please enter format like (123) 456-7890 | 123-456-7890");  
       }
   }



}