package pe.edu.idat.api_ventas_idat.exception;

import java.util.Date;

public class ErrorMessage {
    private Integer statusCode;
    private Date dateError;
    private String message;
    private String description;

    public Integer getStatusCode() {
        return statusCode;
    }

    public Date getDateError() {
        return dateError;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public ErrorMessage(Integer statusCode, Date dateError, String message, String description) {
        this.statusCode = statusCode;
        this.dateError = dateError;
        this.message = message;
        this.description = description;
    }
}
