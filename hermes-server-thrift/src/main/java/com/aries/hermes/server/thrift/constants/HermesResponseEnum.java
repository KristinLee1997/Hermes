package com.aries.hermes.server.thrift.constants;


import com.aries.hermes.idl.dto.ResponseCode;
import com.aries.hermes.idl.dto.ThriftResponse;

public enum HermesResponseEnum {
    SUCCESS(ResponseCode.SUCCESS.getValue(), "成功生效"),
    NOT_CHANGED(ResponseCode.NOT_CHANGED.getValue(), "成功但无变化"),
    PARAM_ERROR(ResponseCode.PARAM_ERROR.getValue(), "未知参数错误"),
    PARAM_ILLEGAL(ResponseCode.PARAM_ILLEGAL.getValue(), "参数非法（参数不全，参数格式错误等）"),
    PARAM_NULL(ResponseCode.PARAM_NULL.getValue(), "参数为null"),
    SYSTEM_ERROR(ResponseCode.SYSTEM_ERROR.getValue(), "系统内部未知异常"),
    OTHERS_SYSTEM_ERROR(ResponseCode.OTHERS_SYSTEM_ERROR.getValue(), "调用其他系统异常"),
    PERMISSION_FAIL(ResponseCode.PERMISSION_FAIL.getValue(), "权限异常"),
    HOPE_RETRY(ResponseCode.HOPE_RETRY.getValue(), "希望调用方重试");


    private int code;
    private String message;

    HermesResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ThriftResponse of() {
        return new ThriftResponse(code, message);
    }
}
