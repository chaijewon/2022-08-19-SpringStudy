package com.sist.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
@RestController
@CrossOrigin("http://localhost:3001")
public class SeoulRestController {
     @Autowired
     private LocationDAO dao;
     
     @GetMapping("/seoul/location_react")
     public List<LocationEntity> locationListData(int page)
     {
    	 List<LocationEntity> list=new ArrayList<LocationEntity>();
    	 int rowSize=12;
    	 int start=(rowSize*page)-rowSize;
    	 list=dao.locationListData(start);
    	 return list;// JSON
     }
     
     @GetMapping("/seoul/location_total")
     public int locationTotalPage()
     {
    	 return dao.locationToalPage();
     }
     
     @GetMapping("/seoul/location_detail_react")
     public LocationEntity locationDetailData(int no)
     {
    	 return dao.findByNo(no);
     }
}
