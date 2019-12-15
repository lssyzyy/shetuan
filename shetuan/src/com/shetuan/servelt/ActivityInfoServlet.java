package com.shetuan.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shetuan.bean.Activity;
import com.shetuan.bean.Community;
import com.shetuan.dao.ActivityDao;
import com.shetuan.dao.CommunityDao;

/**
 * Servlet implementation class ActivityInfoServlet
 */
public class ActivityInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取界面传来的成员姓名
		String activityname = request.getParameter("aname");
		String mainclub = request.getParameter("aclub");
		String place = request.getParameter("place");
		// 调用memberdao方法获取member
		ActivityDao activityDao = new ActivityDao();
		System.out.println(activityname+mainclub+place);
		int holdid = activityDao.gethold(activityname,mainclub,place);
		Activity activity = activityDao.getActivityByName(activityname);
		activity.setHold(holdid);
		request.setAttribute("activity", activity);
		// 返回到成员信息页面
		request.getRequestDispatcher("admin/activityInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
