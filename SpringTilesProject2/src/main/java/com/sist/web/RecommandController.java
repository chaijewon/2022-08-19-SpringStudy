package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*
 *   상황
        휴식 드라이브 산책 집 출/퇴근길 휴가/여행 운동 하우스파티 시상식 일/공부 카페 거리 클럽 고백 해변 공연 라운지 애도 집중
          감성
         외로움 기분전환 슬픔 힘찬 이별 지침/힘듦 설렘 오후 위로 밤 새벽 저녁 아침 사랑 스트레스/짜증 그리움 추억 우울 행복 불안 분노 기쁨 축하
         스타일
         밝은 신나는 웅장한 따뜻한 편안한 그루브한 부드러운 로맨틱한 매혹적인 영화음악 잔잔한 댄서블한 달콤한 몽환적인 시원한 애절한 어두운 연주음악 발렌타인데이 화이트데이
        날씨/계절
        봄 여름 가을 겨울 맑은날 추운날 흐린날 비오는날 더운날 안개낀날 눈오는날
 */
@Controller
public class RecommandController {
     @GetMapping("recommand/recommand.do")
     public String food_recommand()
     {
    	 return "recommand/recommand";
     }
}
