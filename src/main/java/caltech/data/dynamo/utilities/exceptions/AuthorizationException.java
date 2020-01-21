package caltech.data.dynamo.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthorizationException extends RuntimeException {
    public AuthorizationException(final String msg) {
        super(msg);
    }

    public AuthorizationException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }
}
