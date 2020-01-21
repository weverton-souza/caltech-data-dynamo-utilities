package caltech.data.dynamo.utilities.exceptions;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
public class ResourceNotFoundDetails extends ExceptionDetails {

    private ResourceNotFoundDetails() {}

    static ResourceNotFoundDetailsBuilder Builder() {
        return new ResourceNotFoundDetailsBuilder();
    }

    public static final class ResourceNotFoundDetailsBuilder {
        private long timestamp;
        private String developerMessage;

        private ResourceNotFoundDetailsBuilder() {
        }

        ResourceNotFoundDetailsBuilder withTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        ResourceNotFoundDetailsBuilder withDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.setDeveloperMessage(this.developerMessage);
            resourceNotFoundDetails.setTimestamp(this.timestamp);
            return resourceNotFoundDetails;
        }
    }
}
