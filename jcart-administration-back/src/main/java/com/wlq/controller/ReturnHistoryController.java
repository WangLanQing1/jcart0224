package com.wlq.controller;

import com.wlq.dto.in.ReturnHistoryCreateInDTO;
import com.wlq.dto.out.ReturnHistoryListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:35
 */
@RestController
@RequestMapping("/returnhistory")
public class ReturnHistoryController {

    @GetMapping("/getListByReturnId")
    public List<ReturnHistoryListOutDTO> getListByReturnId(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        return null;
    }
}
