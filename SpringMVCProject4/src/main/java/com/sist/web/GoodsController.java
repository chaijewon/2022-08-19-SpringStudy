package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class GoodsController {
    @Autowired
    private GoodsService service;
    
    @GetMapping("goods/main.do")
    public String goods_main()
    {
    	return "goods/main";
    }
    
    
}
