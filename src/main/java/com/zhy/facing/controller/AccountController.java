package com.zhy.facing.controller;

import com.zhy.facing.dto.InputDto;
import com.zhy.facing.dto.OutputDto;
import com.zhy.facing.form.AccountForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/register")
    @ResponseBody
    public OutputDto register(@RequestBody InputDto<AccountForm> inputDto){

        return null;
    }
}
