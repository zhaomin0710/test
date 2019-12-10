package com.sram.common;

public enum CodeMenu {
    SUCCESS(true,10000),
    FAIL(false,10001);


    boolean success;
    Integer code;

    private CodeMenu(boolean success, Integer code) {
        this.success = success;
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public CodeMenu setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public CodeMenu setCode(Integer code) {
        this.code = code;
        return this;
    }
}
