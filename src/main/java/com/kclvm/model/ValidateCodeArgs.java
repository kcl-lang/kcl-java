package com.kclvm.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author peefy
 * @Description
 */
public class ValidateCodeArgs {
    private String data;
    private String code;
    private String schema;
    @JSONField(name = "attribute_name")
    private String attributeName;
    private String format;

    public ValidateCodeArgs(String data, String code, String schema, String attributeName, String format) {
        this.data = data;
        this.code = code;
        this.schema = schema;
        this.attributeName = attributeName;
        this.format = format;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
