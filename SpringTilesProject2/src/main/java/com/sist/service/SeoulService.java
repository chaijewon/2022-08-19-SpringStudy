package com.sist.service;
import java.util.*;

import com.sist.vo.SeoulVO;
public interface SeoulService {
	public List<SeoulVO> seoulListData(Map map);
	public SeoulVO seoulDetailData(Map map);
	public int seoulTotalPage(Map map);
	public List<SeoulVO> seoulTop5(Map map);
}
