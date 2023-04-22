package com.kclvm.model;

import java.io.Serializable;

/**
 * The base facade result.
 *
 * @author peefy
 */
public class Result<DATA> implements Serializable {

    private static final long serialVersionUID = 579178995823150578L;

    private DATA data;

    private boolean success = false;

    private String code;

    private String message;

    private KclError kclError;

    public Result() {
    }

    public static <T> Result<T> success(final T data) {
        Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> failed(final String code, final String message) {
        Result<T> result = new Result<T>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> failed(final String code, final String message, KclError kclError) {
        Result<T> res = failed(code, message);
        res.setKclError(kclError);
        return res;
    }

    public static <T> Result<T> failed(final String code, final String message, KclError kclError, final T data) {
        Result<T> res = failed(code, message, data);
        res.setKclError(kclError);
        return res;
    }

    public static <T> Result<T> failed(final String code, final String message, final T data) {
        Result<T> result = new Result<T>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * Getter method for property <tt>data</tt>.
     *
     * @return property value of data
     */
    public DATA getData() {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     *
     * @param data value to be assigned to property data
     */
    public void setData(DATA data) {
        this.data = data;
    }

    /**
     * Getter method for property <tt>success</tt>.
     *
     * @return property value of success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter method for property <tt>success</tt>.
     *
     * @param success value to be assigned to property success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>message</tt>.
     *
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property <tt>message</tt>.
     *
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public KclError getKclError() {
        return kclError;
    }

    public void setKclError(KclError errorInfo) {
        this.kclError = errorInfo;
    }
}
