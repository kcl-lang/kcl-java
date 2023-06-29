package com.kcl.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class GetSchemaTypeResult {
    public List<KclType> getSchemaTypeList() {
        return schemaTypeList;
    }

    public void setSchemaTypeList(List<KclType> schemaTypeList) {
        this.schemaTypeList = schemaTypeList;
    }

    @JSONField(name = "schema_type_list")
    private List<KclType> schemaTypeList;
}
