package com.kcl.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author peefy
 * @Description
 */
public class CmdOverrideSpec {
    @JSONField(name = "pkgpath")
    private String pkgpath;

    public String getPkgpath() {
        return pkgpath;
    }

    public void setPkgpath(String pkgpath) {
        this.pkgpath = pkgpath;
    }

    @JSONField(name = "field_path")
    private String fieldPath;

    public String getFieldPath() {
        return fieldPath;
    }

    public void setFieldPath(String fieldPath) {
        this.fieldPath = fieldPath;
    }

    @JSONField(name = "field_value")
    private String fieldValue;

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @JSONField(name = "action")
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
