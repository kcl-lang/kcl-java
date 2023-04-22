package com.kclvm.model;

import com.alibaba.fastjson.annotation.JSONField;

public class LoadSettingsFilesResult {
    @JSONField(name = "kcl_cli_configs")
    private CliConfig kclCliConfigs;

    @JSONField(name = "kcl_options")
    private KeyValuePair kclOptions;

    public CliConfig getKclCliConfigs() {
        return kclCliConfigs;
    }

    public void setKclCliConfigs(CliConfig kclCliConfigs) {
        this.kclCliConfigs = kclCliConfigs;
    }

    public KeyValuePair getKclOptions() {
        return kclOptions;
    }

    public void setKclOptions(KeyValuePair kclOptions) {
        this.kclOptions = kclOptions;
    }
}
