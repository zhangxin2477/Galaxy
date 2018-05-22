package com.zhangxin.demon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.zhangxin.demon.entity.Org;
import com.zhangxin.demon.service.DemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
        Org org = demonService.getOrg(1);
        log.info(org.toString());
        return org.toString();
    }
}
