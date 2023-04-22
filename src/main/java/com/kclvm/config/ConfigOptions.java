package com.kclvm.config;

public class ConfigOptions {
    private String endPoint;

    public String getEndPoint() {
        return endPoint;
    }

    public static class Builder {
        private String endPoint;

        public ConfigOptions build() {
            return new ConfigOptions(this);
        }

        public Builder endPoint(String endPoint) {
            this.endPoint = endPoint;
            return this;
        }
    }

    private ConfigOptions(Builder builder) {
        this.endPoint = builder.endPoint;
    }
}
