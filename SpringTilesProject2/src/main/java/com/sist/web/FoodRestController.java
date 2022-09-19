package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.sist.dao.FoodDAO;
import com.sist.service.*;
import com.sist.vo.*;
/*
 *  <!--
[MainComponent.vue 설명]
1. App.vue 에 포함된 자식 컴포넌트입니다

2. template : 
   - 화면 상에 표시할 요소 작성 실시
   - 컴포넌트의 모든 마크업 구조와 디스플레이 로직 작성

3. script : 
   - import 구문을 사용해 template에서 사용할 컴포넌트 불러온다
   - export default 구문에서 모듈의 함수, 객체, 변수 등을 다른 모듈에서 가져다 사용 할 수 있도록 내보냅니다

4. style : 
   - 스타일 지정 실시

5. props : 부모가 전달한 데이터를 받을 때 사용합니다 (부모 쪽에서 자식 객체 생성 필요) : 자식쪽에서 동적 변경 불가능

6. {{ message }} : 데이터 바인딩 시 사용

7. @click : 클릭 이벤트 적용 약어 (원본 : v-on:click)

8. data : 컴포넌트 생성 시 초기 데이터 설정 (리턴 값 지정)

9. methods : 메소드 정의 실시

10. this.$parent.부모 메소드 명칭 : 부모 메소드 호출 실시

11. v-model : 데이터 양방향 바인드를 실시합니다 (ex: input text 수정 시 <h1> 태그 값도 동시 변경)

12. v-html : 원시 HTML 형식 문자열 데이터를 실제 HTML 로 변경해줍니다

13. v-bind : disabled : 버튼 사용 가능 여부 (클릭) 처리 설정

14. v-for : 배열 데이터를 for 반복문을 돌면서 순차적으로 확인합니다

15. v-bind:class : 특정 조건을 만족 (true) 할 시 삼항식을 사용해 클래스 지정 분기 처리 실시

16. v-bind:style : css 스타일 코드를 지정할 수 있습니다

17. v-if : 조건 값에 따라서 렌더링 (표시) 를 수행합니다

18. v-if v-else : 조건 값이 true 일 경우 if 분기 처리 false 일 경우 else 분기 처리를 수행합니다

19. v-show : v-if 문과 유사 하지만, 초기 렌더링 시 true, false 상관 없이 무조건 dom에 렌더링 됩니다

20. @click.prevent : 원래 동작하는 클릭 이벤트 막고 , 지정한 메소드로 이벤트 핸들링 수행

21. @keydown : 키 입력 이벤트 값을 확인 할 수 있습니다 (한글 경우는 Process 가 출력됨)

22. @input : 특정 변수에 입력한 값을 대입 할 수 있습니다

23. watch : data 및 computed 속성의 값이 변경 된 상태 감지 실시

24. style scoped : scoped 를 써주어야 해당 컴포넌트의 요소들에만 스타일이 적용됩니다 . (아니면 프로젝트 전체 요소에 스타일 적용됨)

25. router-view : 라우터에서 설정한 뷰 로드 실시

26. :href : a 태그를 사용해서 url 이동을 실시합니다

27. input checkbox : 체크 박스를 지정하며, v-model 을 사용해 그룹 체크 박스 선택 된 value 값을 확인할 수 있습니다

28. input radio : 라디오 버튼을 지정하며, v-model 을 사용해 선택 된 value 값을 확인할 수 있습니다

29. computed : 종속 대상을 따라 저장 (캐싱) 됩니다. (종속된 대상이 변경될 때만 함수를 실행)

30. split : 문자열을 한글자씩 분리합니다

31. reverse : 데이터를 반대로 출력합니다

32. join : 데이터 결합을 수행합니다
-->






<!-- [개별 템플릿 (뷰) 설정 실시] -->
<template>

  <hr>

  <!-- [data : 데이터 바인딩 지정] -->
  <div>
    <h1> name : {{ name }} </h1>
  </div>

  <hr>

  <!-- [reverse join 사용해 문자열 반대로 출력] -->
  <div>
    <h1> reverse : {{ name.split('').reverse().join('') }} </h1>
  </div>

  <hr>

</template>

 */
@RestController
public class FoodRestController {
    @Autowired
    private FoodService service;
    
    @Autowired
    private FoodDAO dao;
    
    @GetMapping(value = "food/vue_find.do",produces = "text/plain;charset=UTF-8")//JSON
    public String food_find(String ss,String page)
    {
    	System.out.println("ss="+ss);
    	System.out.println("page="+page);
    	String result="";
    	try
    	{
    		if(page==null)
    			page="1";
    		if(ss==null)
    			ss="강남";
    		
    		int curpage=Integer.parseInt(page);
    		Map map=new HashMap();
    		int rowSize=12;
    		int start=(rowSize*curpage)-(rowSize-1);
    		int end=(rowSize*curpage);
    		map.put("start", start);
    		map.put("end", end);
    		map.put("address", ss);
    		
    		List<FoodVO> list=service.foodFindData(map);
    		int totalpage=service.foodLocationTotalPage(ss);
    		
    		JSONArray arr=new JSONArray(); //List  => [] => 자바스크립트 객체표현법 
    		// FoodVO ==> JSONObject  => {}
    		// [{},{},{}...]
    		int k=0;
    		for(FoodVO vo:list)
    		{
    			JSONObject obj=new JSONObject(); //{"fno":1,"name":"ddd"}
    			obj.put("fno", vo.getFno());
    			obj.put("name", vo.getName());
    			obj.put("poster", vo.getPoster().substring(0,vo.getPoster().indexOf("^")));
    			if(k==0)
    			{
    				obj.put("curpage", curpage);
    				obj.put("totalpage", totalpage);
    			}
    			
    			arr.add(obj);
    			k++;
    		}
    		result=arr.toJSONString();
    	}catch(Exception ex){}
    	return result;
    }
    
    @GetMapping(value="food/detail_vue.do",produces = "text/plain;charset=UTF-8")
    public String detail_vue(int fno)
    {
    	String result="";
    	try
    	{
    		FoodVO vo=service.foodDetailVueData(fno);
    		JSONObject obj=new JSONObject();
    		obj.put("fno", vo.getFno());
    		obj.put("name", vo.getName());
    		obj.put("poster", vo.getPoster());
    		obj.put("address", vo.getAddress().substring(0,vo.getAddress().lastIndexOf("지")).trim());
    		obj.put("tel", vo.getTel());
    		obj.put("type", vo.getType());
    		obj.put("time", vo.getTime());
    		obj.put("parking", vo.getParking());
    		obj.put("price", vo.getPrice());
    		obj.put("menu", vo.getMenu());
    		obj.put("score", vo.getScore());
    		
    		result=obj.toJSONString();
    		System.out.println(result);
    	}catch(Exception ex) {}
    	return result;
    }
    
    @GetMapping(value = "food/food_all_vue.do",produces = "text/plain;charset=utf-8")
    public String food_all_vue(String page)
    {
    	String result="";
    	try
    	{
    		if(page==null)
    			page="1";
    		int curpage=Integer.parseInt(page);
    		Map map=new HashMap();
    		int rowSize=12;
    		int start=(rowSize*curpage)-(rowSize-1);
    		int end=(rowSize*curpage);
    		map.put("start", start);
    		map.put("end", end);
    		
    		
    		List<FoodVO> list=dao.foodAllData(map);
    		System.out.println("갯수:"+list.size());
    		int totalpage=dao.foodTotalPage();
    		
    		JSONArray arr=new JSONArray(); //List  => [] => 자바스크립트 객체표현법 
    		// FoodVO ==> JSONObject  => {}
    		// [{},{},{}...]
    		int k=0;
    		for(FoodVO vo:list)
    		{
    			JSONObject obj=new JSONObject(); //{"fno":1,"name":"ddd"}
    			obj.put("fno", vo.getFno());
    			obj.put("name", vo.getName());
    			obj.put("poster", vo.getPoster().substring(0,vo.getPoster().indexOf("^")));
    			if(k==0)
    			{
    				obj.put("curpage", curpage);
    				obj.put("totalpage", totalpage);
    			}
    			
    			arr.add(obj);
    			k++;
    		}
    		result=arr.toJSONString();
    	}catch(Exception ex){}
    	return result;
    }
    
}









