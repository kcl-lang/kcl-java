package com.kcl.model;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class ExecProgramArgs {
    @JSONField(name = "work_dir")
    private String workDir;

    @JSONField(name = "k_filename_list")
    private List<String> kFilenameList;

    @JSONField(name = "k_code_list")
    private List<String> kCodeList;

    @JSONField(name = "args")
    private List<CmdArgSpec> args;

    @JSONField(name = "overrides")
    private List<CmdOverrideSpec> overrides;

    @JSONField(name = "disable_yaml_result")
    private boolean disableYamlResult;

    @JSONField(name = "print_override_ast")
    private boolean printOverrideAst;

    /*
     * -r --strict-range-check
     */
    @JSONField(name = "strict_range_check")
    private boolean strictRangeCheck;

    /* -n --disable-none */
    @JSONField(name = "disable_none")
    private boolean disableNone;
    /* -v --verbose */
    @JSONField(name = "verbose")
    private Integer verbose;

    /*
     * -d --debug
     */
    @JSONField(name = "debug")
    private Integer debug;

    /*
     * yaml/json: sort keys
     */
    @JSONField(name = "sort_keys")
    private boolean sortKeys;

    public String getWorkDir() {
        return workDir;
    }

    public void setWorkDir(String workDir) {
        this.workDir = workDir;
    }

    public List<String> getkFilenameList() {
        return kFilenameList;
    }

    public void setkFilenameList(List<String> kFilenameList) {
        this.kFilenameList = kFilenameList;
    }

    public List<String> getkCodeList() {
        return kCodeList;
    }

    public void setkCodeList(List<String> kCodeList) {
        this.kCodeList = kCodeList;
    }

    public List<CmdArgSpec> getArgs() {
        return args;
    }

    public void setArgs(List<CmdArgSpec> args) {
        this.args = args;
    }

    public List<CmdOverrideSpec> getOverrides() {
        return overrides;
    }

    public void setOverrides(List<CmdOverrideSpec> overrides) {
        this.overrides = overrides;
    }

    public boolean isDisableYamlResult() {
        return disableYamlResult;
    }

    public void setDisableYamlResult(boolean disableYamlResult) {
        this.disableYamlResult = disableYamlResult;
    }

    public boolean isPrintOverrideAst() {
        return printOverrideAst;
    }

    public void setPrintOverrideAst(boolean printOverrideAst) {
        this.printOverrideAst = printOverrideAst;
    }

    public boolean isStrictRangeCheck() {
        return strictRangeCheck;
    }

    public void setStrictRangeCheck(boolean strictRangeCheck) {
        this.strictRangeCheck = strictRangeCheck;
    }

    public boolean isDisableNone() {
        return disableNone;
    }

    public void setDisableNone(boolean disableNone) {
        this.disableNone = disableNone;
    }

    public Integer getVerbose() {
        return verbose;
    }

    public void setVerbose(Integer verbose) {
        this.verbose = verbose;
    }

    public Integer getDebug() {
        return debug;
    }

    public void setDebug(Integer debug) {
        this.debug = debug;
    }

    public boolean isSortKeys() {
        return sortKeys;
    }

    public void setSortKeys(boolean sortKeys) {
        this.sortKeys = sortKeys;
    }
}
