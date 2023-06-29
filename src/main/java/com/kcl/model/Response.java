package com.kcl.model;

import com.alibaba.fastjson.annotation.JSONField;

public class Response<T> {
    private String error;
    private T result;
    @JSONField(name = "kcl_err")
    private KclError kclError;

    public KclError getKclError() {
        return kclError;
    }

    public void setKclError(KclError kclError) {
        this.kclError = kclError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
