package com.kcl.model;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class CliConfig {
	List<String> files;
	String output;
	List<String> overrides;
	@JSONField(name = "path_selector")
	List<String> pathSelector;
	@JSONField(name = "strict_range_check")
	boolean strictRangeCheck;
	@JSONField(name = "disable_none")
	boolean disableNone;
	Integer verbose;
	boolean debug;

	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public List<String> getOverrides() {
		return overrides;
	}

	public void setOverrides(List<String> overrides) {
		this.overrides = overrides;
	}

	public List<String> getPathSelector() {
		return pathSelector;
	}

	public void setPathSelector(List<String> pathSelector) {
		this.pathSelector = pathSelector;
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

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}
}
