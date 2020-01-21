package caltech.data.dynamo.utilities.exceptions;

import java.util.List;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
public class FieldExceptionDetails {
    private String field;
    private List<String> fieldMessages;

    public FieldExceptionDetails(String field, List<String> fieldMessages) {
        this.field = field;
        this.fieldMessages = fieldMessages;
    }

    public String getField() {
        return field;
    }

    public FieldExceptionDetails setField(String field) {
        this.field = field;
        return this;
    }

    public List<String> getFieldMessages() {
        return fieldMessages;
    }

    public FieldExceptionDetails setFieldMessages(List<String> fieldMessages) {
        this.fieldMessages = fieldMessages;
        return this;
    }
}
