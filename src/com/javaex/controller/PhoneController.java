package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc") //http://localhost:8088/phonebook2/주소
public class PhoneController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//컨트롤러 테스트
		System.out.println("controller");
		
		//파라미터 action 값을 읽어서
		String action = request.getParameter("action");
		System.out.println(action);
		
		if("list".equals(action)) {
			System.out.println("리스트 처리");
			//리스트 출력 처리
			PhoneDao phoneDao = new PhoneDao();
			List<PersonVo> personList = phoneDao.getPersonList();
			
			//html을 쓰기 복잡하다 ---> jsp에 만든다
			
			//데이터 전달
			request.setAttribute("pList", personList); //(내가정한별명, 실제 전송할 데이터(리스트))
			
			
			//jsp에 포워드 시킨다.
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/list.jsp"); //path에는 jsp파일 위치를 알려준다.
			rd.forward(request, response);
		
		} else if("wform".equals(action)) {
			System.out.println("등록 폼 처리");
			
			//포워드 시키기
			RequestDispatcher rd= request.getRequestDispatcher("./WEB-INF/writeForm.jsp");
			rd.forward(request, response);
			
		} else if("insert".equals(action)) {
			System.out.println("전화번호 저장");
			
			//파라미터 3개값
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			//personVo 묶고
			PersonVo personVo = new PersonVo(name, hp, company);
			
			//new dao --> 저장
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.personInsert(personVo);
			
			response.sendRedirect("/phonebook2/pbc?action=list"); //주소를 보내줘야한다
			
		}  else if("uform".equals(action)) {
			System.out.println("수정 폼 처리");
			//사람조회 처리
			int personId = Integer.parseInt(request.getParameter("id"));
			
			PhoneDao phoneDao = new PhoneDao();
			PersonVo personVo = phoneDao.getPerson(personId); //id를 주고 정보를 가져온다
			
			//html 복잡 --> jsp 만들고 데이터 전달 후 포워드
			
			//데이터전달
			request.setAttribute("pVo", personVo);
			
			//포워드 시키기
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/updateForm.jsp");
			rd.forward(request, response);
			
		} else if("update".equals(action)) {
			System.out.println("전화번호 수정");
			
			//파라미터 4개
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			int personId = Integer.parseInt(request.getParameter("id"));
			
			PersonVo personVo = new PersonVo(personId, name, hp, company);
			
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.personUpdate(personVo);
			
			response.sendRedirect("/phonebook2/pbc?action=list");
			
		} else if("delete".equals(action)) {
			System.out.println("전화번호 삭제");
			
			int personId = Integer.parseInt(request.getParameter("id"));
			
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.personDelete(personId);
			
			response.sendRedirect("/phonebook2/pbc?action=list");
			
		}
		
		
		
	} //get방식

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}//post방식

}
