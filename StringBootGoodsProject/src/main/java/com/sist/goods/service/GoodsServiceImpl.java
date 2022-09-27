package com.sist.goods.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.goods.dao.*;
import com.sist.goods.vo.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper dao;
	
	@Override
	public List<GoodsVO> goodsMainData(Map map) {
		// TODO Auto-generated method stub
		return dao.goodsMainData(map);
	}

	@Override
	public List<GoodsVO> goodsListData(Map map) {
		// TODO Auto-generated method stub
		return dao.goodsListData(map);
	}

	@Override
	public int goodsTotalPage(Map map) {
		// TODO Auto-generated method stub
		return dao.goodsTotalPage(map);
	}

}
