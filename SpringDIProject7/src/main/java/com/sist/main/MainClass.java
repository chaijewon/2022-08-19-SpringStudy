package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        MovieManager m=(MovieManager)app.getBean("movieManager");
        Scanner scan=new Scanner(System.in);
        System.out.println("========== 메뉴 ==========");
        System.out.println("1. 일일박스오피스");
        System.out.println("2. 실시간 예매율");
        System.out.println("3. 좌석 점유율");
        System.out.println("4. 온라인 상영관");
        System.out.println("=========================");
        System.out.print("메뉴 선택:");
        int menu=scan.nextInt();
        List<MovieVO> list=m.movieListData(menu);
        for(MovieVO vo:list)
        {
        	System.out.println(vo.getTitle()+" "+vo.getDirector());
        }
        
	}

}
