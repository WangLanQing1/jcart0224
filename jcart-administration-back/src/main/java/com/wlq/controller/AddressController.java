package com.wlq.controller;

import com.wlq.dto.out.AddressListOutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:41
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @GetMapping("/getListByCustomerId")
    public List<AddressListOutDTO> getListByCustomerId(@RequestParam Integer customerId){
        return null;
    }
}
