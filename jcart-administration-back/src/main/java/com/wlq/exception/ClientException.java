package com.wlq.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.security.DenyAll;
import javax.servlet.ServletException;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-27-16:09
 */
@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientException extends ServletException {

    private String errCode;

    public ClientException(String errCode,String errMsg){
        super(errMsg);
        this.errCode = errCode;
    }
}
