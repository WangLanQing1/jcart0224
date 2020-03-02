package com.wlq.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wlq.dto.out.CustomerLoginOutDTO;
import com.wlq.po.Customer;
import com.wlq.vo.CustomerLoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-18:11
 */
@Component
public class JWTUtil {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("1800000")
    private Long jwtValidDuration;

    @Value("jcart")
    private String issuer;

    private Algorithm algorithm;

    public JWTUtil(@Value("${jwt.HS256.secret}")String jwtHs256Secret){
        logger.info("init jwt util");
        algorithm = Algorithm.HMAC256(jwtHs256Secret);
    }

    public CustomerLoginOutDTO issueToken(Customer customer){
        Date now = new Date();
        long nowTimestamp = now.getTime();
        long expireTimestamp = nowTimestamp+jwtValidDuration;
        Date expireTime = new Date(expireTimestamp);
        Integer customerId = customer.getCustomerId();
        String username = customer.getUsername();

        String token = JWT.create()
                .withIssuer(issuer)
                .withIssuedAt(now)
                .withSubject(username)
                .withClaim("customerId",customerId)
                .withExpiresAt(expireTime)
                .sign(algorithm);

        logger.info("jwt token: {}",token);
        logger.info("jwt expire date: {}",expireTimestamp);
        CustomerLoginOutDTO customerLoginOutDTO = new CustomerLoginOutDTO();
        customerLoginOutDTO.setToken(token);
        customerLoginOutDTO.setExpireTimestamp(expireTimestamp);

        return customerLoginOutDTO;
    }

    public CustomerLoginVO verifyToken(String token){
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .build();
        DecodedJWT jwt;
        jwt = verifier.verify(token);

        CustomerLoginVO customerLoginVO = new CustomerLoginVO();
        customerLoginVO.setCustomerId(jwt.getClaim("customerId").asInt());
        customerLoginVO.setUsername(jwt.getSubject());
        return customerLoginVO;
    }
}
