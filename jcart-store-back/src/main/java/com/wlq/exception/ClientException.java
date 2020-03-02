package com.wlq.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletException;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-18:32
 */
@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientException extends ServletException {
    private String errCode;

    public ClientException(String errCode, String errMsg){
        super(errMsg);
        this.errCode = errCode;
    }
}
