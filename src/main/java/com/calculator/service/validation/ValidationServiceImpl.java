package com.calculator.service.validation;

import com.calculator.domain.ComplexObject;
import com.calculator.domain.Service;

public class ValidationServiceImpl implements ValidationService {

    private FieldsValidatorFactory fieldsValidatorFactory;

    public ValidationServiceImpl(FieldsValidatorFactory fieldsValidatorFactory) {
        this.fieldsValidatorFactory = fieldsValidatorFactory;
    }

    public void checkCompatibilityAndValidity(ComplexObject... params) {
        checkCompatibility(params);

        for(ComplexObject complexObject : params){
            validate(complexObject);
        }
    }

    public void checkCompatibility(ComplexObject... params) {
        if(params.length == 0){
            throw new IllegalArgumentException("Params shouldn't be empty");
        }
        Service service = params[0].getService();

        for(int i = 1; i < params.length; i++){
            if(params[i].getService() != service){
                throw new IllegalArgumentException("ComplexObjects aren't of the same service");
            }
        }
    }

    public void validate(ComplexObject complexObject) {
        if (complexObject == null || complexObject.getService() == null) {
            throw new IllegalArgumentException("Service in ComplexObject can't be null");
        }

        fieldsValidatorFactory.getFieldsValidator(complexObject)
                .validate(complexObject);
    }
}
