package com.kclvm.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.SystemUtils;

import com.kclvm.model.ExecProgramArgs;
import com.kclvm.model.ExecProgramResult;
import com.kclvm.model.GetSchemaTypeResult;
import com.kclvm.model.Response;
import com.kclvm.model.ValidateCodeArgs;
import com.kclvm.model.ValidateCodeResult;

public class BinClient implements KclClient {
    private String binName = "kcl";

    private String runCommand(String[] args) {
        Process p;
        if (SystemUtils.IS_OS_WINDOWS) {
            p = Runtime.getRuntime()
                    .exec(ArrayUtils.addAll(new String[] { "cmd.exe /C " }, args));
        } else {
            p = Runtime.getRuntime()
                    .exec(ArrayUtils.addAll(new String[] { "/bin/sh", "-c" }, args));
        }
        String result = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "utf-8"));
            String line = null;
            StringBuffer b = new StringBuffer();
            while ((line = br.readLine()) != null) {
                b.append(line + "\n");
            }
            return b.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
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
