package caltech.data.dynamo.utilities.exceptions;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
public class ExceptionDetails {
    private long timestamp;
    private String developerMessage;

    public long getTimestamp() {
        return timestamp;
    }

    public ExceptionDetails setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public ExceptionDetails setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }
}
