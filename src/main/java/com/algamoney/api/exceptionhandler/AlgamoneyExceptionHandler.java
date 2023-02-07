package com.algamoney.api.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
    protected ResponseEntity<Object> handleHttpMessageNotReadable( HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request )
    {
        String userMessage = messageSource.getMessage( "invalid.message", null, LocaleContextHolder.getLocale() );
        String devMessage = ex.getCause().toString();

        return handleExceptionInternal( ex, new Error( userMessage, devMessage ), headers, HttpStatus.BAD_REQUEST, request );
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
