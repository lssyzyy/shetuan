package com.shetuan.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shetuan.bean.Community;
import com.shetuan.bean.Member;
import com.shetuan.dao.CommunityDao;
import com.shetuan.dao.MemberDao;

/**
 * Servlet implementation class CommunityInfoServlet
 */
public class CommunityInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取界面传来的成员姓名
		String clubname = request.getParameter("cname");
		// 调用memberdao方法获取member
		CommunityDao communityDao = new CommunityDao();
		Community community = communityDao.getCommunityByName(clubname);
		request.setAttribute("community", community);
		// 返回到成员信息页面
		request.getRequestDispatcher("admin/communityInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
