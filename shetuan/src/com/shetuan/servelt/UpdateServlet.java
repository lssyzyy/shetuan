
package com.shetuan.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shetuan.bean.Activity;
import com.shetuan.bean.Community;
import com.shetuan.bean.Login;
import com.shetuan.bean.Member;
import com.shetuan.dao.ActivityDao;
import com.shetuan.dao.CommunityDao;
import com.shetuan.dao.LoginDao;
import com.shetuan.dao.MemberDao;
/**
 * 所有的更新servlet
 * @author Administrator
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDao logindao = new LoginDao();
		ActivityDao activitydao=new ActivityDao();
		String ope = request.getParameter("ope");
		System.out.println("Updateservlet " + ope);
		if (ope.equals("mupdate")) {
			/**
			 * MemberUpdate
			 */
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String uppass2 = request.getParameter("newpass2");
			// ��ȡ���ݿ����˺����룬�����ж�������Ϣ�Ƿ����
			Login db_login = logindao.getLoginByName(username);

			System.out.println("loginservlet->update");
			if (db_login == null) {
				request.getRequestDispatcher("manager_update.jsp?rs=namewrong").forward(request, response);
			} else {
				String db_pass = db_login.getLoginPass();
				if (!db_pass.equals(userpass)) {
					System.out.println("db_pass!=uppass" + db_pass + " " + userpass);
					request.getRequestDispatcher("manager_update.jsp?rs=wrong").forward(request, response);
				} else {
					int rs = logindao.updatePassword(username, uppass2);
					if (rs > 0) {
						System.out.println("rs>0 " + rs);
						response.sendRedirect("manager_update.jsp?rs=success");
					} else {
						System.out.println("更新失败" + rs);
						request.getRequestDispatcher("manager_update.jsp?rs=fail").forward(request, response);
					}
				}
			}
		} else if (ope.equals("udele")) {
			String loginName = request.getParameter("loginname");
			System.out.print(loginName);
			MemberDao memberdao = new MemberDao();
			memberdao.deleteMember(loginName);
			// 返回到成员信息页面
			request.getRequestDispatcher("Query?lru=ulist").forward(request, response);
		}else if (ope.equals("cdele")) {
			String clubname = request.getParameter("clubname");
			System.out.println(clubname);
			CommunityDao communityDao = new CommunityDao();
			communityDao.deleteCommunity(clubname);
			// 返回到社团信息页面
			request.getRequestDispatcher("Query?lru=clist").forward(request, response);
		}else if (ope.equals("cshenp")) {
			String clubname = request.getParameter("clubname");
			System.out.println(clubname);
			CommunityDao communityDao = new CommunityDao();
			communityDao.shenpCommunity(clubname);
			// 返回到社团信息页面
			request.getRequestDispatcher("Query?lru=slist").forward(request, response);
		}else if (ope.equals("cshenpdele")) {
			String clubname = request.getParameter("clubname");
			System.out.println(clubname);
			CommunityDao communityDao = new CommunityDao();
			communityDao.deleteCommunity(clubname);
			// 返回到社团信息页面
			request.getRequestDispatcher("Query?lru=slist").forward(request, response);
		}else if (ope.equals("adele")) {
			String activityname = request.getParameter("aname");
			String mainclub = request.getParameter("aclub");
			String place = request.getParameter("place");
			ActivityDao activityDao = new ActivityDao();
			System.out.println(activityname+mainclub+place);
			int holdid = activityDao.gethold(activityname,mainclub,place);
			activityDao.deleteActivity(holdid);
			// 返回到社团信息页面
			request.getRequestDispatcher("Query?lru=alist").forward(request, response);
		}else if (ope.equals("ashenp")) {
			String activityname = request.getParameter("aname");
			String mainclub = request.getParameter("aclub");
			String place = request.getParameter("place");
			ActivityDao activityDao = new ActivityDao();
			System.out.println(activityname+mainclub+place);
			int holdid = activityDao.gethold(activityname,mainclub,place);
			activityDao.shenpActivity(holdid);
			// 返回到社团信息页面
			request.getRequestDispatcher("Query?lru=jlist").forward(request, response);
		}else if (ope.equals("ashenpdele")) {
			String activityname = request.getParameter("aname");
			String mainclub = request.getParameter("aclub");
			String place = request.getParameter("place");
			ActivityDao activityDao = new ActivityDao();
			System.out.println(activityname+mainclub+place);
			int holdid = activityDao.gethold(activityname,mainclub,place);
			activityDao.deleteActivity(holdid);
			// 返回到社团信息页面
			request.getRequestDispatcher("Query?lru=jlist").forward(request, response);
		}else if (ope.equals("aupdate")) {
			/**
			 * MemberUpdate
			 */
			String activityname = request.getParameter("activityname");
			String activityname2 = request.getParameter("activityname2");
			
			String place = request.getParameter("place");
			String newplace = request.getParameter("newplace");
			Activity act = activitydao.getActivityByName(activityname);

			System.out.println("updateservlet->update");
			if (act == null) {
				request.getRequestDispatcher("activity_update.jsp?rs=namewrong").forward(request, response);
			} else {
				String aplace = act.getPlace();
				if (!aplace.equals(place)) {
					System.out.println("aplace!=place" + aplace + " " + place);
					request.getRequestDispatcher("activity_update.jsp?rs=wrong").forward(request, response);
				} else {
					int rs = activitydao.updatePlace(Integer.parseInt(activityname), newplace);
					if (rs > 0) {
						System.out.println("rs>0 " + rs);
						response.sendRedirect("activity_update.jsp?rs=success");
					} else {
						System.out.println("更新失败" + rs);
						request.getRequestDispatcher("activity_update.jsp?rs=fail").forward(request, response);
					}
				}
			}
		}

	}

}
