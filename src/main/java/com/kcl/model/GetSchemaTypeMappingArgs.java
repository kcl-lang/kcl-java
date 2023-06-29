package com.kcl.model;

import com.alibaba.fastjson.annotation.JSONField;

public class GetSchemaTypeMappingArgs {
    public GetSchemaTypeMappingArgs(String code) {
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

    public GetSchemaTypeMappingArgs(String code, String schemaName) {
        this.code = code;
        this.schemaName = schemaName;
    }

    @JSONField(name = "schema_name")
    private String schemaName;
}
