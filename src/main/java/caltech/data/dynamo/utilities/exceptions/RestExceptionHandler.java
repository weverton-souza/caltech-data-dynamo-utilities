package caltech.data.dynamo.utilities.exceptions;

import caltech.data.dynamo.utilities.generics.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

/**
 * @author Weverton Souza.
 * Created on 02/07/19
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    Response<ResourceNotFoundDetails> handleResourceNotFoundException(final ResourceNotFoundException ex) {
        ResourceNotFoundDetails notFoundDetails =
                ResourceNotFoundDetails.Builder()
                .withTimestamp(new Date().getTime())
                .withDeveloperMessage(ex.getClass().getName())
                .build();

        return new Response<>(
                notFoundDetails,
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HashMap<String, List<String>> fieldExceptionDetails = new HashMap<>();
        List<FieldExceptionDetails> detailsList = new ArrayList<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError e : fieldErrors) {
            if (fieldExceptionDetails.get(e.getField()) == null) {
                fieldExceptionDetails.put(e.getField(), new ArrayList<>());
                fieldExceptionDetails.get(e.getField()).add(e.getDefaultMessage());
            } else {
                fieldExceptionDetails.get(e.getField()).add(e.getDefaultMessage());
            }
        }

        for (Map.Entry<String, List<String>> entry : fieldExceptionDetails.entrySet()) {
            String k = entry.getKey();
            List<String> v = entry.getValue();
            detailsList.add(new FieldExceptionDetails(k, v));
        }

        ValidationExceptionDetails validationExceptionDetails =
                ValidationExceptionDetails.Builder()
                        .withFieldExceptionDetails(detailsList)
                        .withTimestamp(new Date().getTime())
                        .withDeveloperMessage(ex.getClass().getName())
                        .build();

        Response response =  new Response<>(
                validationExceptionDetails,
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.getReasonPhrase());

        return new ResponseEntity<>(response, status);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        ExceptionDetails exceptionDetails = new ExceptionDetails()
                .setTimestamp(new Date().getTime())
                .setDeveloperMessage(ex.getMessage());

        Response response = new Response<>(
                exceptionDetails,
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.getReasonPhrase());

        return new ResponseEntity<>(response, status);
    }
}
