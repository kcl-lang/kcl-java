package com.kclvm.model;

import com.alibaba.fastjson.annotation.JSONField;

public class KclErrorInfo {
    @JSONField(name = "err_level")
    private String errLevel;
    @JSONField(name = "arg_msg")
    private String argMsg;
    private String filename;
    @JSONField(name = "src_code")
    private String srcCode;
    @JSONField(name = "line_no")
    private String lineNo;
    @JSONField(name = "col_no")
    private String colNo;

    public String getErrLevel() {
        return errLevel;
    }

    public void setErrLevel(String errLevel) {
        this.errLevel = errLevel;
    }

    public String getArgMsg() {
        return argMsg;
    }

    public void setArgMsg(String argMsg) {
        this.argMsg = argMsg;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSrcCode() {
        return srcCode;
    }

    public void setSrcCode(String srcCode) {
        this.srcCode = srcCode;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }

    public String getColNo() {
        return colNo;
    }

    public void setColNo(String colNo) {
        this.colNo = colNo;
    }
}
