package com.kcl.client;

import com.kcl.model.*;

public interface KclClient {
    Response<ExecProgramResult> execProgram(ExecProgramArgs args);

    Response<ValidateCodeResult> validate(ValidateCodeArgs req);

    Response<GetSchemaTypeResult> getSchemaType(String code);
}
