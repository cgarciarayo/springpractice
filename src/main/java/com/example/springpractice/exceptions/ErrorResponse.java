package com.example.springpractice.exceptions;

/**
 * En esta clase defino la respuesta de error que voy a devolver en formato JSON
 * cuando se produzca una excepcion en la aplicacion.
 */
public class ErrorResponse {

    /**
     * En este atributo guardo el codigo de error.
     */
    private int errorCode;

    /**
     * En este atributo guardo el mensaje descriptivo del error.
     */
    private String message;

    /**
     * En este atributo guardo la marca de tiempo del error.
     */
    private String timestamp;

    /**
     * En este constructor vacio permito crear el objeto sin parametros.
     */
    public ErrorResponse() {
    }

    /**
     * En este constructor recibo todos los datos del error.
     *
     * @param errorCode codigo de error
     * @param message mensaje descriptivo
     * @param timestamp marca de tiempo
     */
    public ErrorResponse(int errorCode, String message, String timestamp) {
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}