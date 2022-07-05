package com.example.part3_practice.ch06.exception.advice;

import com.example.part3_practice.ch06.exception.controller.ApiController;
import com.example.part3_practice.ch06.exception.dto.Error;
import com.example.part3_practice.ch06.exception.dto.ErrorResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestControllerAdvice(basePackageClasses = ApiController.class)
public class ApiControllerAdvice {

    @ExceptionHandler(value =Exception.class)
    public ResponseEntity exception(Exception e){
        System.out.println(e.getClass().getName());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }



    @ExceptionHandler(value =MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest){

        List<Error> errorList =new ArrayList<>();

        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getAllErrors().forEach(
                objectError -> {

                    FieldError field = (FieldError) objectError;
                    String fieldName = field.getField();
                    String message = field.getDefaultMessage();
                    String value = field.getRejectedValue().toString();


                    Error errorMessage =new Error();
                    errorMessage.setFieldName(fieldName);
                    errorMessage.setMessage(message);
                    errorMessage.setInvalidValue(value);

                    errorList.add(errorMessage);
                }
        );
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setResultUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FaiL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity constraintViolationException(ConstraintViolationException e,HttpServletRequest httpServletRequest){
        List<Error> errorList =new ArrayList<>();
        e.getConstraintViolations().forEach(
                error->{

                    Stream<Path.Node> stream = StreamSupport.stream(error.getPropertyPath().spliterator(),false);
                    List<Path.Node> list =stream.collect(Collectors.toList());
                    String field = list.get(list.size()-1).getName();
                    String message = error.getMessage();
                    String invalidValue =error.getInvalidValue().toString();


                    Error errorMessage =new Error();
                    errorMessage.setFieldName(field);
                    errorMessage.setMessage(message);
                    errorMessage.setInvalidValue(invalidValue);

                    errorList.add(errorMessage);


                }

        );
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setResultUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FaiL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value =MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException (MissingServletRequestParameterException e,HttpServletRequest httpServletRequest){

        List<Error> errorList =new ArrayList<>();

        String fieldName = e.getParameterName();
        String invalidValue = e.getMessage();

        Error errorMessage =new Error();
        errorMessage.setFieldName(fieldName);
        errorMessage.setMessage(e.getMessage());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setResultUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FaiL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }


}
