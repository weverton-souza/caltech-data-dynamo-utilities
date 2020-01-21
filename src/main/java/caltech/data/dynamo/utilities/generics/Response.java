package caltech.data.dynamo.utilities.generics;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
public class Response<E> {
    private E content;
    private Integer code;
    private HttpStatus status;
    private String description;

    public Response() {}

    public Response(@Nullable final E content, final Integer code, final HttpStatus status,
                    final String Description) {
        this.content = content;
        this.code = code;
        this.status = status;
        this.description = Description;
    }

    public E getContent() {
        return content;
    }


    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status.name();
    }


    public String getDescription() {
        return description;
    }


    public ResponseBuilder<?> Builder() {
        return new ResponseBuilder<E>();
    }


    public static final class ResponseBuilder<E> {
        private E content;
        private Integer code;
        private HttpStatus status;
        private String description;

        private ResponseBuilder() {}

        public ResponseBuilder<?> content(E content) {
            this.content = content;
            return this;
        }

        public ResponseBuilder<?> code(Integer code) {
            this.code = code;
            return this;
        }

        public ResponseBuilder<?> status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ResponseBuilder<?> Description(String Description) {
            this.description = Description;
            return this;
        }

        public Response<?> build() {
            Response<E> response = new Response<>();
            response.content = (content);
            response.code = (code);
            response.status = (status);
            response.description = (description);
            return response;
        }
    }
}
