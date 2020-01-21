package caltech.data.dynamo.utilities.exceptions;

import java.util.List;

/**
 * @author Weverton Souza.
 * Created on 03/07/19
 */
public class ValidationExceptionDetails extends ExceptionDetails {
    private List<FieldExceptionDetails> fieldExceptionDetails;

    public List<FieldExceptionDetails> getFieldExceptionDetails() {
        return fieldExceptionDetails;
    }

    public static ValidationExceptionDetailsBuilder Builder() {
        return new ValidationExceptionDetailsBuilder();
    }

    public static final class ValidationExceptionDetailsBuilder {
        private long timestamp;
        private String developerMessage;
        private List<FieldExceptionDetails> fieldExceptionDetails;

        private ValidationExceptionDetailsBuilder() {
        }

        public ValidationExceptionDetailsBuilder withFieldExceptionDetails(
                List<FieldExceptionDetails> fieldExceptionDetails) {
            this.fieldExceptionDetails = fieldExceptionDetails;
            return this;
        }

        ValidationExceptionDetailsBuilder withTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        ValidationExceptionDetailsBuilder withDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        ValidationExceptionDetails build() {
            ValidationExceptionDetails validation = new ValidationExceptionDetails();
            validation.fieldExceptionDetails = this.fieldExceptionDetails;
            validation.setDeveloperMessage(this.developerMessage);
            validation.setTimestamp(this.timestamp);
            return validation;
        }
    }
}
