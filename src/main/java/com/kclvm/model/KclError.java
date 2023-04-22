package com.kclvm.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class KclError {
    private String ewcode;
    private String name;
    private String msg;
    @JSONField(name = "error_infos")
    List<KclErrorInfo> errorInfos;

    public List<KclErrorInfo> getErrorInfos() {
        return errorInfos;
    }

    public void setErrorInfos(List<KclErrorInfo> errorInfos) {
        this.errorInfos = errorInfos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getEwcode() {
        return ewcode;
    }

    public void setEwcode(String ewcode) {
        this.ewcode = ewcode;
    }
}
