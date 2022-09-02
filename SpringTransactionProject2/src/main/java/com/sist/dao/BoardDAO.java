package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.BoardMapper;

@Repository
public class BoardDAO {
   @Autowired
   private BoardMapper mapper;
   
   public List<BoardVO> boardLisData(Map map)
   {
	   return mapper.boardLisData(map);
   }
   public int boardTotalPage()
   {
	   return mapper.boardTotalPage();
   }
   public int boardCount()
   {
	   return mapper.boardCount();
   }
   public void boardInsert(BoardVO vo)
   {
	   mapper.boardInsert(vo);
   }
   public BoardVO boardDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.boardDetailData(no);
   }
   
   @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
   public void boardReplyInsert(int pno,BoardVO vo)
   {
	   BoardVO pvo=mapper.boardParentInfoData(pno);
	   mapper.boardGroupStepIncrement(pvo);
	   vo.setGroup_id(pvo.getGroup_id());
	   vo.setGroup_step(pvo.getGroup_step()+1);
	   vo.setGroup_tab(pvo.getGroup_tab()+1);
	   vo.setRoot(pno);
	   mapper.boardReplyInsert(vo);
	   mapper.depthIncrement(pno);
	   
   }
   
   public BoardVO boardUpdateData(int no)
   {
	   return mapper.boardDetailData(no);
   }
   public boolean boardUpdate(BoardVO vo)
   {
	   boolean bCheck=false;
	   String db_pwd=mapper.boardGetPassword(vo.getNo());
	   if(db_pwd.equals(vo.getPwd()))
	   {
		   bCheck=true;
		   mapper.boardUpdate(vo);
	   }
	   return bCheck;
   }
   @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
   /*
    *      1.  @Around ==> setAutoCommit(false)
    *             사용자 코딩 부분
    *      1-1 @Around ==> commit
    *      
    *      2. @AfterThrowing ==> rollback()
    *      
    *      3. @After => setAutoCommit(true)
    *      
    *      
    *      try
    *      {
    *          conn.setAutCommit(false)
    *          boolean bCheck=false;
	   
			   // 비밀번호 검색 
			   String db_pwd=mapper.boardGetPassword(no);
			   if(db_pwd.equals(pwd))
			   {
				   bCheck=true;
				   // depth,root를 가지고 온다 
				   BoardVO vo=mapper.boardGetRootDepthData(no);
				   if(vo.getDepth()==0)
				   {
					   mapper.boardDelete(no);
				   }
				   else
				   {
					   vo.setContent("관리자가 삭제한 게시물입니다");
					   vo.setSubject("관리자가 삭제한 게시물입니다");
					   vo.setNo(no);
					   mapper.boardSubjectContentUpdate(vo);
				   }
				   mapper.depthDecrement(vo.getRoot());
	   }
    *          conn.commit();
    *      }catch(Exception ex)
    *      {
    *          try
    *          {
    *             conn.rollback()
    *          }catch(Exception e){}
    *      }
    *      finally
    *      {
    *         try
    *         {
    *            conn.setAutoCommit(true)
    *         }catch(Exception e){}
    *      }
    */
   public boolean boardDelete(int no,String pwd)
   {
	   boolean bCheck=false;
	   
	   // 비밀번호 검색 
	   String db_pwd=mapper.boardGetPassword(no);
	   if(db_pwd.equals(pwd))
	   {
		   bCheck=true;
		   // depth,root를 가지고 온다 
		   BoardVO vo=mapper.boardGetRootDepthData(no);
		   if(vo.getDepth()==0)
		   {
			   mapper.boardDelete(no);
		   }
		   else
		   {
			   vo.setContent("관리자가 삭제한 게시물입니다");
			   vo.setSubject("관리자가 삭제한 게시물입니다");
			   vo.setNo(no);
			   mapper.boardSubjectContentUpdate(vo);
		   }
		   mapper.depthDecrement(vo.getRoot());
	   }
	   
	   return bCheck;
   }
}






