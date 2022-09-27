package com.sist.goods.service;
import java.util.List;
import java.util.Map;

import com.sist.goods.vo.GoodsVO;

public interface GoodsService {
	public List<GoodsVO> goodsMainData(Map map);
	public List<GoodsVO> goodsListData(Map map);
	public int goodsTotalPage(Map map);
}
