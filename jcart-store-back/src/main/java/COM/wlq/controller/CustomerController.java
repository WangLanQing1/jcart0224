package com.wlq.controller;

import com.wlq.dto.in.*;
import com.wlq.dto.out.CustomerGetProfileOutDTO;
import com.wlq.dto.out.CustomerLoginOutDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:05
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping("/register")
    public Integer register(@RequestBody CustomerRegisterInDTO customerRegisterInDTO){
        return null;
    }

    @GetMapping("/login")
    public CustomerLoginOutDTO login(CustomerLoginInDTO customerLoginInDTO){
        return null;
    }

    @GetMapping("/getProfile")
    public CustomerGetProfileOutDTO getProfile(@RequestAttribute Integer customerId){
        return null;
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody CustomerUpdateProfileInDTO customerUpdateProfileInDTO,
                              @RequestAttribute Integer customerId){

    }

    @PostMapping("/changePwd")
    public void changePwd(@RequestBody CustomerChangePwdInDTO customerChangePwdInDTO,
                          @RequestAttribute Integer customerId){

    }

    @GetMapping("/getPwdResetCode")
    public String getpwdResetCode(@RequestParam String email){
        return null;
    }

    @PostMapping("/resetPwd")
    public void resetPwd(@RequestBody CustomerResetPwdInDTO customerResetPwdInDTO){

    }
}
