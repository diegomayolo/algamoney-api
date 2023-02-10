package com.algamoney.api.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author dm
 */
@ControllerAdvice
public class AlgamoneyExceptionHandler extends ResponseEntityExceptionHandler
{
    @Autowired
    private MessageSource messageSource;

    /**
     * handleHttpMessageNotReadable
     *
     * @param ex HttpMessageNotReadableException
     * @param headers HttpHeaders
     * @param status HttpStatusCode
     * @param request WebRequest
     * @return ResponseEntity<Object>
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable( HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request )
    {
        String userMessage = messageSource.getMessage( "invalid.message", null, LocaleContextHolder.getLocale() );
        String devMessage  = ex.getCause().toString();

        List<Error> errors = Arrays.asList( new Error( userMessage, devMessage ) );
        return handleExceptionInternal( ex, errors, headers, HttpStatus.BAD_REQUEST, request );
    }

    /**
     * handleMethodArgumentNotValid
     *
     * @param ex MethodArgumentNotValidException
     * @param headers HttpHeaders
     * @param status HttpStatusCode
     * @param request WebRequest
     * @return ResponseEntity<Object>
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request )
    {
        List<Error> errors = createErrorList( ex.getBindingResult() );
        return handleExceptionInternal( ex, errors, headers, HttpStatus.BAD_REQUEST, request );
    }

    /**
     * createErrorList
     *
     * @param bindingResult BindingResult
     * @return List<Error>
     */
    private List<Error> createErrorList( BindingResult bindingResult )
    {
        List<Error> errors = new ArrayList<>();

        List<FieldError> fieldsErrors = bindingResult.getFieldErrors();

        for ( FieldError field : fieldsErrors )
        {
            String userMessage = messageSource.getMessage( field, LocaleContextHolder.getLocale() );
            String devMessage  = field.toString();
            errors.add( new Error(  userMessage, devMessage ) );
        }

        return errors;
    }

    /**
     * @author dm
     */
    public static class Error
    {
        private String userMessage;
        private String devMessage;

        /**
         * Error
         *
         * @param devMessage String
         * @param userMessage String
         */
        public Error( String userMessage, String devMessage )
        {
            this.userMessage = userMessage;
            this.devMessage = devMessage;
        }

        /**
         * getUserMessage
         *
         * @return String
         */
        public String getUserMessage()
        {
            return userMessage;
        }

        /**
         * getDevMessage
         *
         * @return String
         */
        public String getDevMessage()
        {
            return devMessage;
        }
    }
}
