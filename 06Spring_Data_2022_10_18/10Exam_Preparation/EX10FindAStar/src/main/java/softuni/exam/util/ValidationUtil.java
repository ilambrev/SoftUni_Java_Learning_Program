package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationUtil {

    private final Validator validator;

    public ValidationUtil(Validator validator) {
        this.validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }

    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }

    public <E> Set<ConstraintViolation<E>> violation(E entity) {
        return validator.validate(entity);
    }

}