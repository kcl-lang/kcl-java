package com.kclvm.model;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class OverrideFileArgs {
    @JSONField(name = "file")
    private String file;

    @JSONField(name = "specs")
    private List<String> specs;

    @JSONField(name = "import_paths")
    private List<String> importPaths;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<String> getSpecs() {
        return specs;
    }

    public void setSpecs(List<String> specs) {
        this.specs = specs;
    }

    public List<String> getImportPaths() {
        return importPaths;
    }

    public void setImportPaths(List<String> importPaths) {
        this.importPaths = importPaths;
    }
}
