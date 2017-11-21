package com.calculator.service.validation;

import com.calculator.domain.ComplexObject;
import com.calculator.domain.Service;

import java.util.HashMap;
import java.util.Map;

public class FieldsValidatorFactory {

    private Map<Service, FieldsValidator> fieldsValidatorMap = new HashMap<Service, FieldsValidator>();

    public FieldsValidatorFactory() {}

    public void initFiledsValidatorMap(){
        fieldsValidatorMap.put(Service.A, new AServiceFieldsValidatorImpl());
        fieldsValidatorMap.put(Service.B, new BServiceFieldsValidatorImpl());
        fieldsValidatorMap.put(Service.C, new CServiceFieldsValidatorImpl());
    }

    public FieldsValidator getFieldsValidator(ComplexObject complexObject){
        return fieldsValidatorMap.get(complexObject.getService());
    }

}
