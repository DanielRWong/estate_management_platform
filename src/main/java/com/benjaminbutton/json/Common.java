package com.benjaminbutton.json;

/**
 * @author WWX
 * @description
 * @date 2020-06-25 3:40
 * @modified By
 */
public class Common {
    private String message = "";
    private Integer code = 200;
    private Object result;

    public Common() {
    }

    public Common(Object result) {
        this.result = result;
    }

    public Common(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Common{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", result=" + result +
                '}';
    }
}
