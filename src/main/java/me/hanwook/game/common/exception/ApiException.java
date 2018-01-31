package me.hanwook.game.common.exception;

import org.springframework.http.HttpStatus;

/**
 * API Exception
 */
public class ApiException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 8110992995766118568L;

    private HttpStatus status;

    public ApiException(String message) {
        super(message);
        status = HttpStatus.BAD_REQUEST;
    }

    public ApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
