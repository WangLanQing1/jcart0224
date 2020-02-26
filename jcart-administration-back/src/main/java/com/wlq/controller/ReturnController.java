package com.wlq.controller;

import com.wlq.dto.in.ReturnSearchInDTO;
import com.wlq.dto.in.ReturnUpdateActionInDTO;
import com.wlq.dto.out.PageOutDTO;
import com.wlq.dto.out.ReturnListOutDTO;
import com.wlq.dto.out.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:21
 */
@RestController
@RequestMapping("/return")
public class ReturnController {

    @GetMapping("/search")
    public PageOutDTO<ReturnListOutDTO> search(ReturnSearchInDTO returnSearchInDTO,
                                               @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO){
        
    }

}
