package com.wlq.controller;

import com.wlq.dao.AddressMapper;
import com.wlq.dto.in.AddressCreateInDTO;
import com.wlq.dto.in.AddressUpdateInDTO;
import com.wlq.dto.out.AddressListOutDTO;
import com.wlq.dto.out.AddressShowOutDTO;
import com.wlq.po.Address;
import com.wlq.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-13:52
 */
@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getAddressByCustomerId")
    public List<AddressListOutDTO> getAddressByCustomerId(@RequestAttribute Integer customerId){
        List<Address> addresses = addressService.getByCustomerId(customerId);

        List<AddressListOutDTO> addressListOutDTOS = addresses.stream().map(address -> {
            AddressListOutDTO addressListOutDTO = new AddressListOutDTO();
            addressListOutDTO.setAddressId(address.getAddressId());
            addressListOutDTO.setTag(address.getTag());
            addressListOutDTO.setReceiverMobile(address.getReceiverMobile());
            addressListOutDTO.setReceiverName(address.getReceiverName());
            addressListOutDTO.setContent(address.getContent());
            return addressListOutDTO;
        }).collect(Collectors.toList());

        return addressListOutDTOS;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AddressCreateInDTO addressCreateInDTO,
                          @RequestAttribute Integer customerId){
        Address address = new Address();
        address.setTag(addressCreateInDTO.getTag());
        address.setContent(addressCreateInDTO.getContent());
        address.setReceiverMobile(addressCreateInDTO.getReceiverMobile());
        address.setReceiverName(addressCreateInDTO.getReceiverName());
        address.setCustomerId(customerId);

        Integer addressId = addressService.create(address);
        return addressId;
    }

    @PostMapping("/update")
    public void update(@RequestBody AddressUpdateInDTO addressUpdateInDTO,
                       @RequestAttribute Integer customerId){
        Address address = new Address();
        address.setAddressId(addressUpdateInDTO.getAddressId());
        address.setTag(addressUpdateInDTO.getTag());
        address.setContent(addressUpdateInDTO.getContent());
        address.setReceiverMobile(addressUpdateInDTO.getReceiverMobile());
        address.setReceiverName(addressUpdateInDTO.getReceiverName());
        address.setCustomerId(customerId);

        addressService.update(address);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer addressId){
        addressService.delete(addressId);
    }

    @GetMapping("/getById")
    public AddressShowOutDTO getById(@RequestParam Integer addressId){
        Address address = addressService.getById(addressId);
        AddressShowOutDTO addressShowOutDTO = new AddressShowOutDTO();

        addressShowOutDTO.setAddressId(address.getAddressId());
        addressShowOutDTO.setTag(address.getTag());
        addressShowOutDTO.setReceiverMobile(address.getReceiverMobile());
        addressShowOutDTO.setReceiverName(address.getReceiverName());
        addressShowOutDTO.setContent(address.getContent());

        return addressShowOutDTO;
    }
}
