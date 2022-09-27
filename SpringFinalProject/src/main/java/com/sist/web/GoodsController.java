package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.*;
import com.sist.vo.GoodsVO;
@Controller
public class GoodsController {
	
    @Autowired
    private GoodsDAO dao;
    
    private String[] tbls={"","goods_all","goods_new","goods_special","goods_best"};//컬럼이 동일 
    private String[] title={"","전체상품","신상품","특가상품","베스트상품"};
    
    @GetMapping("goods/list.do")
    public String goods_list(String page,String type,Model model)
    {
    	if(page==null)
    		page="1";
    	if(type==null)
    		type="1";
    	
    	int curpage=Integer.parseInt(page);
    	Map map=new HashMap();
    	int rowSize=12;
    	int start=(rowSize*curpage)-(rowSize-1);
    	int end=rowSize*curpage;
    	map.put("start", start);
    	map.put("end", end);
    	map.put("table_name", tbls[Integer.parseInt(type)]);
    	List<GoodsVO> list=dao.goodsListData(map);
    	for(GoodsVO vo:list)
    	{
    		String s=vo.getGoods_name();
    		if(s.length()>25)
    		{
    			s=s.substring(0,25)+"...";
    			vo.setGoods_name(s);
    		}
    		vo.setGoods_name(s);
    	}
    	int totalpage=dao.goodsTotalPage(map);
    	
    	model.addAttribute("curpage", curpage);
    	model.addAttribute("totalpage", totalpage);
    	model.addAttribute("list", list);
    	model.addAttribute("type", type);
    	model.addAttribute("title", title[Integer.parseInt(type)]);
    	model.addAttribute("main_jsp", "../goods/list.jsp");
    	return "main/main";
    	//tiles ==> goods/list
    	
    }
    
    @GetMapping("goods/detail.do")
    public String goods_detail(int no,int type,Model model)
    {
    	Map map=new HashMap();
    	map.put("no", no);
    	map.put("table_name", tbls[type]);
        GoodsVO vo=dao.goodsDetailData(map);
        
        model.addAttribute("type", type);
        model.addAttribute("vo", vo);
    	model.addAttribute("main_jsp", "../goods/detail.jsp"); // thymeleaf
    	return "main/main"; // goods/detail(tiles)
    }
}










