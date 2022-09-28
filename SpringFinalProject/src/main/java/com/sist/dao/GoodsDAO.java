package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.GoodsVO;
/*
 *      MVC 동작 순서 
 *      
 *      사용자 요청 
 *      --------
 *        <a href=".do"> , <form action=".do"> : ~.do
 *         |
 *       DispatcherServlet 
 *         |
 *        HandlerMapping ==> URI 찾기   ===> 등록 위치 @RequestMapping(),GetMapping(),PostMapping()
 *         |
 *        사용자가 처리한 메소드 찾기 
 *         |
 *        invoke() ==> 호출 
 *         |
 *       ViewResolver ===> 찾기(경로명 , 확장자) 
 *         |
 *        JSP
 *         
 */
// 메모리 할당 
/*
 *    ===> Web
 *       Model : 사용자 요청 처리 => 결과값을 브라우저에 전송  
 *         = @Controller 
 *           : 결과값을 전송  (forward (Model), redirect (RedirectAttributes))
 *                        ---------------- ------------------------------
 *                          request유지              request를 초기화 (재전송) ===> .do
 *                                           ==> _ok.do 
 *             화면 변경 (Node.js => Router)
 *         = @RestController : 화면 변경이 아니다 , 실제 데이터만 전송 (Rest:다른 프로그램과 연동)
 *            ============== javascript(ajax,vuejs,reactjs) ==> 전송값 (JSON)
 *            
 *             요청처리 => 결과값 얻기
 *             ====> 통합 예외처리 
 *             @ControllerAdvice , @RestControllerAdvice  
 *         = @Repository : DAO(저장소)
 *         = @Service : BI(DAO를 통합)
 *    메모리 할당 어노테이션 (Spring-Boot)
 *    -----------------
 *      @Component : 일반 클래스 = News읽기 , OpenAPI
 *      @Configuration : XML 없이 자바로 환경 설정시 사용 
 *      ============================================> 패키지 단위로 등록 <context:componentScan base-package="">
 *      
 *    ==> @Autowired ==> 반드시 스프링에 메모리 할당이 되어야 한다 
 */
@Repository
public class GoodsDAO {
   // 구현된 Mapper 읽기
   @Autowired
   private GoodsMapper mapper;
   
   /*
    *   @Select("SELECT no,goods_name,goods_price,goods_poster,num "
		 +"FROM (SELECT no,goods_name,goods_price,goods_poster,rownum as num "
		 +"FROM (SELECT no,goods_name,goods_price,goods_poster "
		 +"FROM ${table_name} ORDER BY no ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<GoodsVO> goodsListData(Map map);
	*/
   public List<GoodsVO> goodsListData(Map map)
   {
	   return mapper.goodsListData(map);
   }
   /*
	  @Select("SELECT * FROM ${table_name} "
			 +"WHERE no=#{no}")
	  public GoodsVO goodsDetailData(Map map); // VO에 존재 (GoodsVO) , VO에 없는 변수 포함 (Map map)
    */
   public GoodsVO goodsDetailData(Map map)
   {
	   mapper.goodsHitIncrement(map);
	   return mapper.goodsDetailData(map);
   }
   /*
    *   @Select("SELECT no,goods_name,goods_price,goods_poster,rownum "
		 +"FROM (SELECT no,goods_name,goods_price,goods_poster "
		 +"FROM ${table_name} ORDER BY no ASC) "
		 +"WHERE rownum<=6")
  public List<GoodsVO> goodsMainData(Map map);
    */
   public List<GoodsVO> goodsMainData(Map map)
   {
	   return mapper.goodsMainData(map);
   }
   
   /*
    *    @Select("SELECT CEIL(COUNT(*)/12.0) FROM ${table_name}")
         public int goodsTotalPage(Map map);
    */
   public int goodsTotalPage(Map map)
   {
	   return mapper.goodsTotalPage(map);
   }
   /*
    *   @Select("SELECT no,goods_name,goods_poster,rownum "
		 +"FROM (SELECT no,goods_name,goods_poster "
		 +"FROM goods_all ORDER BY hit DESC) "
		 +"WHERE rownum<=5")
  public List<GoodsVO> goodsFooterData();
    */
   public List<GoodsVO> goodsFooterData()
   {
	   return mapper.goodsFooterData();
   }
}











