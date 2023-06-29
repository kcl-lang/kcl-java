package com.kcl.model;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class FormatPathResult {
    @JSONField(name = "changed_paths")
    private List<String> changedPaths;
}
