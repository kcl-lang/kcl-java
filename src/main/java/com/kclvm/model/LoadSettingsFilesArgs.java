package com.kclvm.model;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class LoadSettingsFilesArgs {
    @JSONField(name = "work_dir")
    private String workDir;

    private List<String> files;

    public String getWorkDir() {
        return workDir;
    }

    public void setWorkDir(String workDir) {
        this.workDir = workDir;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
}
