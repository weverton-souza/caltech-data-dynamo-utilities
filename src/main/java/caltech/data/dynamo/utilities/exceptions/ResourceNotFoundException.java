package caltech.data.dynamo.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(final String msg) {
        super(msg);
    }

    public ResourceNotFoundException() {
    }
}
