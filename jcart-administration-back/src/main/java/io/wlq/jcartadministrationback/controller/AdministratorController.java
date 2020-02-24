package io.wlq.jcartadministrationback.controller;

import io.wlq.jcartadministrationback.dto.in.AdministratorLoginInDTO;
import io.wlq.jcartadministrationback.dto.in.AdministratorUpdateProfileInDTO;
import io.wlq.jcartadministrationback.dto.out.AdministratorGetProfileOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping("/login")
    public String login(AdministratorLoginInDTO administratorLoginInDTO){
        return null;
    }

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(Integer adminstratorId){
        return null;
    }

}
