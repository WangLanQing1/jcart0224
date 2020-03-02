package com.wlq.controller;

import com.wlq.dto.out.PageOutDTO;
import com.wlq.dto.out.ReturnShowOutDTO;
import com.wlq.dto.in.ReturnApplyInDTO;
import com.wlq.dto.out.ReturnListOutDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:54
 */
@RestController
@RequestMapping("/return")
public class ReturnController {

    @PostMapping("/apply")
    public Integer apply(@RequestBody ReturnApplyInDTO returnApplyInDTO,
                         @RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getList")
    public PageOutDTO<ReturnListOutDTO> getList(@RequestAttribute Integer customerId,
                                                @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId){

    }
}
