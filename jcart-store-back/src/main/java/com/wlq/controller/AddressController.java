package com.wlq.controller;

import com.wlq.dto.in.AddressCreateInDTO;
import com.wlq.dto.in.AddressUpdateInDTO;
import com.wlq.dto.out.AddressListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-13:52
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @GetMapping("/getAddressByCustomerId")
    public List<AddressListOutDTO> getAddressByCustomerId(@RequestAttribute Integer customerId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AddressCreateInDTO addressCreateInDTO,
                          @RequestAttribute Integer customerId){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody AddressUpdateInDTO addressUpdateInDTO,
                       @RequestAttribute Integer customerId){
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer addressId){

    }
}
