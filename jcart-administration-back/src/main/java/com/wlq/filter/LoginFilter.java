package com.wlq.filter;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.wlq.constant.ClientExceptionConstant;
import com.wlq.exception.ClientException;
import com.wlq.util.JWTUtil;
import com.wlq.vo.AdministratorLoginVO;
import org.apache.catalina.connector.ClientAbortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;
/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-04-20:39
 */
@Order(2)
@Component
public class LoginFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JWTUtil jwtUtil;

    @Value("${jwt.exclude.apiUrls}")
    private Set<String> excludeLoginApiUrls;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        if (method.equals("OPTIONS")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        final String requestURI = request.getRequestURI();

        if (excludeLoginApiUrls.contains(requestURI)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String token = request.getHeader("jcartToken");
        if (token == null || token.isEmpty()){
            throw new ClientException(ClientExceptionConstant.TOKEN_NOT_EXIST_ERRCODE,ClientExceptionConstant.TOKEN_NOT_EXIST_ERRMSG);
        }

        logger.info("verify login with token: {}",token);

        AdministratorLoginVO administratorLoginVO = null;
        try {
            administratorLoginVO = jwtUtil.verifyToken(token);
        }catch (JWTCreationException ex){
            throw new ClientException(ClientExceptionConstant.TOKEN_INVALID_ERRCODE, ex.getMessage());
        }

        request.setAttribute("administratorId",administratorLoginVO.getAdministratorId());
        request.setAttribute("administratorUsername",administratorLoginVO.getUsername());

        filterChain.doFilter(servletRequest,servletResponse);
        return;
    }
}
