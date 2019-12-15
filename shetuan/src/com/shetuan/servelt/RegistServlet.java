package com.shetuan.servelt;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * 所有的注册servlet
 * 
 * @author Administrator
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDao logindao = new LoginDao();
		MemberDao memberDao = new MemberDao();
		CommunityDao communitydao = new CommunityDao();
		ActivityDao activitydao=new ActivityDao();
		Object ope = request.getParameter("ope");
		System.out.println("registServlet" + ope);

		if (ope.equals("manager")) {
			/**
			 * LoginRegist
			 */
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String managerId = request.getParameter("power");
			Login login = new Login();
			login.setLoginName(username);
			login.setLoginPass(userpass);
			login.setManagerId(Integer.parseInt(managerId));
			String judge = logindao.addLogin(login);
			if (judge.equals("success")) {
				System.out.println("登录成功");
				request.getRequestDispatcher("admin/manager_add.jsp?rs=success").forward(request, response);
			} else if (judge.equals("exist")) {
				request.getRequestDispatcher("admin/manager_add.jsp?rs=exist").forward(request, response);
			} else {
				request.getRequestDispatcher("admin/manager_add.jsp?rs=fail").forward(request, response);
			}
		} else if (ope.equals("index")) {
			/**
			 * IndexRegist
			 */
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String useremail = request.getParameter("email");
			String userphone = request.getParameter("phone");
			Login login = new Login();
			login.setLoginName(username);
			login.setLoginPass(userpass);
			Member member = new Member();
			member.setEmail(useremail);
			member.setPhonenumber(userphone);
			String judge = memberDao.addIndexLogin(login, member);
			if (judge.equals("success")) {
				System.out.println("注册成功");
				request.getRequestDispatcher("regist.jsp?rs=success").forward(request, response);
			} else if (judge.equals("exist")) {
				request.getRequestDispatcher("regist.jsp?rs=exist").forward(request, response);
			} else {
				request.getRequestDispatcher("regist.jsp?rs=fail").forward(request, response);
			}

		} else if (ope.equals("community")) {
			/**
			 * CommunityRegist
			 */

			String cname = request.getParameter("clubName");
			String crname = request.getParameter("creatername");

			String createrId = memberDao.getLoginNameByName(crname);
			if (createrId == null) {
				System.out.println("创建者 " + crname );
				request.getRequestDispatcher("admin/community_add.jsp?rs=mNotIn").forward(request, response);
			} else {
				SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM-dd");
				Date crdate=null;
				try {
					crdate = simdate.parse(request.getParameter("createtime"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int csum = Integer.parseInt(request.getParameter("clubNum"));
				String crange = request.getParameter("clubPlace");
				int cclass = Integer.parseInt(request.getParameter("clubClassid"));
				String cInfo = request.getParameter("clubInform");
				int isCreate = Integer.parseInt(request.getParameter("iscreate"));

				Community community = new Community();
				community.setClubName(cname);
				community.setCreaterid(createrId);
				community.setCreatetime(crdate);
				community.setClubNum(csum);
				community.setClubPlace(crange);
				community.setClubClassid(cclass);
				community.setClubInform(cInfo);
				community.setIscreate(isCreate);

				String judge = communitydao.addAdminCommunity(community);
				if (judge.equals("success")) {
					System.out.println("创建成功");
					request.getRequestDispatcher("admin/community_add.jsp?rs=success").forward(request, response);
				} else if (judge.equals("exist")) {
					request.getRequestDispatcher("admin/community_add.jsp?rs=exist").forward(request, response);
				} else {
					request.getRequestDispatcher("admin/community_add.jsp?rs=fail").forward(request, response);
				}
			}
		}else if(ope.equals("activity")) {
			String aname = request.getParameter("activityname");
			String clubname = request.getParameter("clubname");
			String introduction = request.getParameter("introduction");
			Float finance = Float.valueOf(request.getParameter("finance"));
				SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM-dd");
				Date starttime=null;
				Date endtime=null;
				try {
					starttime = simdate.parse(request.getParameter("starttime"));
					endtime = simdate.parse(request.getParameter("endtime"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String place1 = request.getParameter("activityplace1");
				String place2 = request.getParameter("activityplace2");
				String place3 = request.getParameter("activityplace3");
				Activity activity = new Activity();
				
				activity.setActivityName(aname);
				activity.setFinance(finance);
				activity.setIntroduction(introduction);
				activity.setMainclub(clubname);
				activity.setStarttime(starttime);
				activity.setEndtime(endtime);
				activity.setPlace(place1);
				activity.setPlace1(place2);
				activity.setPlace2(place3);

				String judge = activitydao.addAdminActivity(activity);
				if (judge.equals("success")) {
					System.out.println("创建成功");
					request.getRequestDispatcher("admin/activity_add.jsp?rs=success").forward(request, response);
				} else if (judge.equals("exist")) {
					request.getRequestDispatcher("admin/activity_add.jsp?rs=exist").forward(request, response);
				} else {
					request.getRequestDispatcher("admin/activity_add.jsp?rs=fail").forward(request, response);
				}
		}

	}

}
