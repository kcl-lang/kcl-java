package com.kclvm.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kclvm.model.*;
import com.kclvm.utl.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author peefy
 * @Description
 */
public class RestClient implements KclClient {
    private static final Logger log = LoggerFactory.getLogger(RestClient.class);

    private static final String execProgramPath = "api:protorpc/KclvmService.ExecProgram";
    private static final String validatePath = "api:protorpc/KclvmService.ValidateCode";
    public static final String pingPath = "api:protorpc/BuiltinService.Ping";
    public static final String schemaTypePath = "api:protorpc/KclvmService.GetSchemaType";
    public static final String resolveCodePath = "api:protorpc/KclvmService.ResolveCode";

    private final String execProgramPathURL;
    private final String validateURL;
    private final String pingURL;
    private final String endPoint;
    private final String schemaTypeURL;

    public String getEndPoint() {
        return endPoint;
    }

    public RestClient(String endPoint) {
        if (Util.isEmpty(endPoint)) {
            throw new RuntimeException("empty endpoint");
        }
        this.endPoint = endPoint;
        if (endPoint.endsWith("/")) {
            this.execProgramPathURL = String.format("%s%s", endPoint, execProgramPath);
            this.validateURL = String.format("%s%s", endPoint, validatePath);
            this.pingURL = String.format("%s%s", endPoint, pingPath);
            this.schemaTypeURL = String.format("%s%s", endPoint, schemaTypePath);
        } else {
            this.execProgramPathURL = String.format("%s%s", endPoint, execProgramPath);
            this.validateURL = String.format("%s/%s", endPoint, validatePath);
            this.pingURL = String.format("%s/%s", endPoint, pingPath);
            this.schemaTypeURL = String.format("%s/%s", endPoint, schemaTypePath);
        }
    }

    public static class RawResponse {
        private String content;
        private String error;
        private int status;
    }

    public void healthCheck() {
        for (int i = 0; i < 10; i++) {
            try {
                RawResponse rsp = post(pingURL, "{}");
                if (Objects.equals(rsp.status, 200)) {
                    return;
                }
                Thread.sleep(1000);
            } catch (Throwable e) {
                log.error(String.format("failed to init rest client, %s", e.getMessage()));
            }
        }
        throw new RuntimeException(String.format("failed to init rest client [%s]", pingURL));
    }

    public static boolean healthCheck(String endPoint) {
        RawResponse rsp = post(String.format("%s/%s", endPoint, pingPath), "{}");
        if (rsp.status > 299) {
            return false;
        }
        return Util.isEmpty(rsp.error);
    }

    private static RawResponse post(String path, String contentInJSON) {
        RawResponse rsp = new RawResponse();
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            OutputStream outputStream = conn.getOutputStream();
            byte[] input = contentInJSON.getBytes(StandardCharsets.UTF_8);
            outputStream.write(input, 0, input.length);

            int status = conn.getResponseCode();
            Reader streamReader;
            rsp.status = status;
            if (status > 299) {
                streamReader = new InputStreamReader(conn.getErrorStream());
            } else {
                streamReader = new InputStreamReader(conn.getInputStream());
            }
            BufferedReader buff = new BufferedReader(streamReader);
            String inputLine;
            StringBuilder contentBuf = new StringBuilder();
            while ((inputLine = buff.readLine()) != null) {
                contentBuf.append(inputLine);
            }
            streamReader.close();
            rsp.content = contentBuf.toString();
            return rsp;
        } catch (Throwable t) {
            rsp.error = t.getMessage();
            rsp.status = 500;
            return rsp;
        }
    }

    public Response<ValidateCodeResult> validate(ValidateCodeArgs req) {
        Response<ValidateCodeResult> rsp = new Response<>();
        ValidateCodeResult result = new ValidateCodeResult();
        rsp.setResult(result);
        try {
            RawResponse response = post(validateURL, JSON.toJSONString(req));
            if (response.status > 299) {
                result.setSuccess(false);
                if (!Util.isEmpty(response.content)) {
                    result.setErrMessage(response.content);
                } else if (!Util.isEmpty(response.error)) {
                    result.setErrMessage(response.error);
                } else {
                    result.setErrMessage(String.valueOf(response.status));
                }
            } else {
                return JSON.parseObject(response.content, new TypeReference<Response<ValidateCodeResult>>() {
                });
            }
        } catch (Throwable t) {
            log.info("validate failed: [{}]", JSON.toJSONString(t));
            result.setSuccess(false);
            result.setErrMessage(t.getMessage());
        }
        return rsp;
    }

    public Response<GetSchemaTypeResult> getSchemaType(String code) {
        Response<GetSchemaTypeResult> rsp = new Response<>();
        try {
            RawResponse response = post(schemaTypeURL, JSON.toJSONString(new GetSchemaTypeArgs(code)));
            if (response.status > 299) {
                if (!Util.isEmpty(response.content)) {
                    rsp.setError(response.content);
                } else if (!Util.isEmpty(response.error)) {
                    rsp.setError(response.error);
                } else {
                    rsp.setError(String.valueOf(response.status));
                }
            } else {
                rsp = JSON.parseObject(response.content, new TypeReference<Response<GetSchemaTypeResult>>() {
                });
            }
        } catch (Throwable t) {
            log.info("getSchemaType failed: [{}]", JSON.toJSONString(t));
            rsp.setError(t.getMessage());
        }
        return rsp;
    }

    @Override
    public Response<ExecProgramResult> execProgram(ExecProgramArgs args) {
        Response<ExecProgramResult> rsp = new Response<>();
        try {
            RawResponse response = post(execProgramPathURL, JSON.toJSONString(args));
            if (response.status > 299) {
                if (!Util.isEmpty(response.content)) {
                    rsp.setError(response.content);
                } else if (!Util.isEmpty(response.error)) {
                    rsp.setError(response.error);
                } else {
                    rsp.setError(String.valueOf(response.status));
                }
            } else {
                rsp = JSON.parseObject(response.content, new TypeReference<Response<ExecProgramResult>>() {
                });
            }
        } catch (Throwable t) {
            log.info("execProgram failed: [{}]", JSON.toJSONString(t));
            rsp.setError(t.getMessage());
        }
        return rsp;
    }
}
