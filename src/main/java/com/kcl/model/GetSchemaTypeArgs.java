package com.kcl.model;

import com.alibaba.fastjson.annotation.JSONField;

public class GetSchemaTypeArgs {
    public GetSchemaTypeArgs(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public GetSchemaTypeArgs(String code, String schemaName) {
        this.code = code;
        this.schemaName = schemaName;
    }

    @JSONField(name = "schema_name")
    private String schemaName;
}
