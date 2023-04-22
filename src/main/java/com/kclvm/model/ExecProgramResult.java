package com.kclvm.model;

import com.alibaba.fastjson.annotation.JSONField;

public class ExecProgramResult {
    @JSONField(name = "json_result")
    private String jsonResult;
    @JSONField(name = "yaml_result")
    private String yamlResult;
    @JSONField(name = "escaped_time")
    private String escapedTime;

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public String getYamlResult() {
        return yamlResult;
    }

    public void setYamlResult(String yamlResult) {
        this.yamlResult = yamlResult;
    }

    public String getEscapedTime() {
        return escapedTime;
    }

    public void setEscapedTime(String escapedTime) {
        this.escapedTime = escapedTime;
    }
}
