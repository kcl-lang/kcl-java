package com.kcl.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.SystemUtils;

import com.kcl.model.ExecProgramArgs;
import com.kcl.model.ExecProgramResult;
import com.kcl.model.GetSchemaTypeResult;
import com.kcl.model.Response;
import com.kcl.model.ValidateCodeArgs;
import com.kcl.model.ValidateCodeResult;

public class BinClient implements KclClient {
    private String binName = "kcl";

    private String runCommand(String[] args) {
        try {
            Process p;
            if (SystemUtils.IS_OS_WINDOWS) {
                p = Runtime.getRuntime()
                        .exec(ArrayUtils.addAll(new String[] { "cmd.exe /C " }, args));
            } else {
                p = Runtime.getRuntime()
                        .exec(ArrayUtils.addAll(new String[] { "/bin/sh", "-c" }, args));
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "utf-8"));
            String line = null;
            StringBuffer b = new StringBuffer();
            while ((line = br.readLine()) != null) {
                b.append(line + "\n");
            }
            return b.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Response<ExecProgramResult> execProgram(ExecProgramArgs args) {
        String result = runCommand(
                ArrayUtils.addAll(new String[] { binName }, args.getkFilenameList().toArray(new String[0])));
        ExecProgramResult execProgramResult = new ExecProgramResult();
        execProgramResult.setYamlResult(result);

        Response<ExecProgramResult> rsp = new Response<>();
        rsp.setResult(execProgramResult);
        return rsp;
    }

    @Override
    public Response<ValidateCodeResult> validate(ValidateCodeArgs req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }

    @Override
    public Response<GetSchemaTypeResult> getSchemaType(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSchemaType'");
    }
}