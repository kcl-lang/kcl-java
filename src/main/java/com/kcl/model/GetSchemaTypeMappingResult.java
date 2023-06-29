package com.kcl.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

public class GetSchemaTypeMappingResult {
    @JSONField(name = "schema_type_mapping")
    Map<String, KclType> schemaTypeMapping;

    public Map<String, KclType> getSchemaTypeMapping() {
        return schemaTypeMapping;
    }

    public void setSchemaTypeMapping(Map<String, KclType> schemaTypeMapping) {
        this.schemaTypeMapping = schemaTypeMapping;
    }
}
