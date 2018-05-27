package com.zhangxin.demon.controller;

import com.zhangxin.demon.entity.User;
import com.zhangxin.demon.service.DemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DemonServiceStation {
    private static final Logger log = LoggerFactory.getLogger(DemonServiceStation.class);

    @Autowired
    private DemonService demonService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return demonService.hello("欢迎...");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String demon(@PathVariable("id") int oid) {
        return demonService.getOrg(oid).toString();
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(@RequestBody User user){

        log.info("name:"+user.getName()+",password:"+user.getPassword());
        return true;
    }
}
