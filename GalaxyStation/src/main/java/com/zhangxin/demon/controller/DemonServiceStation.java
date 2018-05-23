package com.zhangxin.demon.controller;

import com.zhangxin.demon.service.DemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemonServiceStation {
    private static final Logger log = LoggerFactory.getLogger(DemonServiceStation.class);

    @Autowired
    private DemonService demonService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String demon() {
        return demonService.getOrg(1).toString();
    }
}
