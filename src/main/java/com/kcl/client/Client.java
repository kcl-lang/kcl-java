package com.kcl.client;

import com.kcl.model.*;
import com.kcl.utl.Util;

import java.util.List;
import java.util.Optional;

/**
 * @author peefy
 * @Description
 */
public class Client {
    private static final String FMT_JSON = "JSON";

    private KclClient client;

    public void setClient(KclClient client) {
        this.client = client;
    }

    public KclClient getClient() {
        return client;
    }

    public static class Builder {
        private KclClient client;

        public Builder restClient(RestClient restClient) {
            this.client = restClient;
            return this;
        }

        public Builder binClient(BinClient binClient) {
            this.client = binClient;
            return this;
        }

        public Client build() {
            return new Client(this);
        }

        public Builder(Client that) {
            this.client = that.client;
        }
    }

    private Client(Builder builder) {
        this.client = builder.client;
    }

    public Client() {
    }

    public Client(BinClient c) {
        client = c;
    }

    public Client(RestClient c) {
        client = c;
    }

    private boolean validFormat(String format) {
        if ("json".equals(format) || "JSON".equals(format)) {
            return true;
        }
        return "yaml".equals(format) || "YAML".equals(format);
    }

    public Result<Boolean> validate(String code, String jsonData, String schemaName, String attributeName,
            String format) {
        if (Util.isEmpty(format)) {
            format = FMT_JSON;
        }
        if (!validFormat(format)) {
            return Result.failed("invalidFormat", String.format("invalid format:[%s]", format), false);
        }
        Response<ValidateCodeResult> rsp = client
                .validate(new ValidateCodeArgs(jsonData, code, schemaName, attributeName, format));
        if (rsp.getResult() == null) {
            return Result.failed("", rsp.getError(), rsp.getKclError(), false);
        }
        Boolean success = rsp.getResult().getSuccess();
        if (Boolean.TRUE.equals(success)) {
            return Result.success(true);
        }
        return Result.failed("", rsp.getResult().getErrMessage(), rsp.getKclError(), false);
    }

    public Result<List<KclType>> getSchemaType(String code) {
        Response<GetSchemaTypeResult> rsp = client.getSchemaType(code);
        if (Util.isNotEmpty(rsp.getError())) {
            return Result.failed("", rsp.getError(), rsp.getKclError(), null);
        }
        return Result.success(rsp.getResult().getSchemaTypeList());
    }

    public Result<KclType> getSchemaType(String code, String schemaName) {
        if (Util.isBlank(schemaName)) {
            return Result.failed("", "blank schema", null, null);
        }
        Response<GetSchemaTypeResult> rsp = client.getSchemaType(code);
        if (Util.isNotEmpty(rsp.getError())) {
            return Result.failed("", rsp.getError(), rsp.getKclError(), null);
        }
        if (rsp.getResult() == null) {
            return Result.failed("", "null result", rsp.getKclError(), null);
        }
        List<KclType> typeList = rsp.getResult().getSchemaTypeList();
        if (typeList == null) {
            return Result.failed("", "empty result", rsp.getKclError(), null);
        }
        Optional<KclType> targetType = typeList.stream().filter(k -> schemaName.equals(k.getSchemaName())).findFirst();
        return targetType.map(Result::success).orElseGet(
                () -> Result.failed("", String.format("cannot find schema [%s]", schemaName), rsp.getKclError(), null));
    }
}
