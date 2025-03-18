package Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.dtos;

import org.springframework.http.HttpStatus;

public class ValidationExceptionDto {
    private String message;
    private HttpStatus status;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
