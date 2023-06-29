package com.kcl.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;
import java.util.Map;

public class KclType {
    private String type;
    @JSONField(name = "schema_name")
    private String schemaName;
    private Integer line;
    private Map<String, KclType> properties;
    // for list
    private KclType item;
    // for map
    private KclType key;
    // for union
    @JSONField(name = "union_types")
    private List<KclType> unionTypes;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public Map<String, KclType> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, KclType> properties) {
        this.properties = properties;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public KclType getItem() {
        return item;
    }

    public void setItem(KclType item) {
        this.item = item;
    }

    public KclType getKey() {
        return key;
    }

    public void setKey(KclType key) {
        this.key = key;
    }

    public List<KclType> getUnionTypes() {
        return unionTypes;
    }

    public void setUnionTypes(List<KclType> unionTypes) {
        this.unionTypes = unionTypes;
    }
}
