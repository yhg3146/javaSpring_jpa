package com.example.part3_practice.ch06.exception.dto;

public class Error {

    private String fieldName;
    private String message;
    private String invalidValue;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(String invalidValue) {
        this.invalidValue = invalidValue;
    }

    @Override
    public String toString() {
        return "Error{" +
                "fieldName='" + fieldName + '\'' +
                ", message='" + message + '\'' +
                ", invalidValue='" + invalidValue + '\'' +
                '}';
    }
}
