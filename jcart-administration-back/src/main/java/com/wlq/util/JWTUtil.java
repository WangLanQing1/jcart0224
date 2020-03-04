package com.wlq.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.wlq.dto.in.AdministratorLoginInDTO;
import com.wlq.dto.out.AdministratorLoginOutDTO;
import com.wlq.po.Administrator;
import com.wlq.po.Customer;
import com.wlq.vo.AdministratorLoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-03-17:53
 */
@Component
public class JWTUtil {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("1800000")
    private Long jwtValidDuration;

    @Value("jcart")
    private String issuer;

    private Algorithm algorithm;

    public JWTUtil(@Value("654321")String jwtHs256Secret){
        logger.info("init jwt util");
        algorithm = Algorithm.HMAC256(jwtHs256Secret);
    }

    public AdministratorLoginOutDTO issueToken(Administrator administrator){
        Date now = new Date();
        long nowTiestamp = now.getTime();
        long exireTimestamp = nowTiestamp+jwtValidDuration;
        Date exireTime = new Date(exireTimestamp);
        Integer administratorId = administrator.getAdministratorId();
        String username = administrator.getUsername();

        String token = JWT.create()
                .withIssuer(issuer)
                .withIssuedAt(now)
                .withSubject(username)
                .withClaim("administratorId",administratorId)
                .withExpiresAt(exireTime)
                .sign(algorithm);

        logger.info("jwt token {}",token);
        logger.info("jwt expire date: {}",exireTimestamp);
        AdministratorLoginOutDTO administratorLoginOutDTO = new AdministratorLoginOutDTO();
        administratorLoginOutDTO.setToken(token);
        administratorLoginOutDTO.setExipreTimestamp(exireTimestamp);

        return administratorLoginOutDTO;
    }

    public AdministratorLoginVO verifyToken(String token){
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .build();
        DecodedJWT jwt;
        jwt = verifier.verify(token);

        AdministratorLoginVO administratorloginVO = new AdministratorLoginVO();
        administratorloginVO.setAdministratorId(jwt.getClaim("administratorId").asInt());
        administratorloginVO.setUsername(jwt.getSubject());
        return administratorloginVO;
    }
}
