package com.shetuan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shetuan.bean.Login;
import com.shetuan.bean.Member;
import com.shetuan.util.Page;

/**
 * 成员的增删改查
 * 
 * @author Administrator
 */
public class MemberDao extends BaseDao {
	/**
	 * 获取成员列表
	 * 
	 * @param page
	 * @return
	 */
	public List<Member> getMembersForPage(Page page) {

		List<Member> members = new ArrayList<Member>();
		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "select count(1) from member as m,login as l,club as c ,clubinfo as ci where m.memberid=l.loginname and  m.memberid=ci.memberid and ci.clubid=c.clubid ";
			// 执行SQL
			exeQuery(countsql);
			// 获取结果集
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果结果集存在，获取该字段，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 查询成员的详细信息
			String sql = "select l.loginname,m.membername,m.sex,l.managerid,m.grade,m.memberinstitute,m.phonenumber,m.email,c.clubname from member as m,login as l,club as c,clubinfo as ci where m.memberid=l.loginname and  m.memberid=ci.memberid and ci.clubid=c.clubid limit ?,?";
			//// 执行sql ，传入分页的起始页，每页大小
			exeQuery(sql, page.getItemStart(), page.getPageSize());
			// 获取结果集
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果集存在，获取对应字段将其赋值给一个新的member对象，并将其添加到members集合中
			while (rs.next()) {
				Member member = new Member();
				member.setLoginName(rs.getString("loginname"));
				member.setMemberName(rs.getString("membername"));
				member.setSex(rs.getString("sex"));
				member.setManagerId(rs.getInt("managerid"));
				member.setGrade(rs.getString("grade"));
				member.setMemberInstitute(rs.getString("memberinstitute"));
				member.setPhonenumber(rs.getString("phonenumber"));
				member.setEmail(rs.getString("email"));
				member.setJoinclub(rs.getString("clubname"));
				//将member添加到集合中
				members.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return members;
	}

	/**
	 * 根据登录名名获取成员对象
	 * @param loginname
	 * @return
	 */
	public Member getMemberByName(String loginname) {
		Member member = new Member();
		try {
			//获取连接
			getCon();
			//要执行的SQL
			String sql = "select l.loginname,m.membername,m.sex,l.managerid,m.grade,m.memberinstitute,m.address,m.phonenumber,m.email,memberheader,c.clubname from member as m,login as l,club as c,clubinfo as ci where m.memberid=l.loginname and  m.memberid=ci.memberid and ci.clubid=c.clubid and l.loginname=?";
			//执行查询，并传入参数：登录名
			exeQuery(sql, loginname);
			//获取结果集
			ResultSet rs = (ResultSet) ps.executeQuery();
			//如果结果集存在，获取对应的字段将其赋值都给member对象
			while (rs.next()) {
				member.setLoginName(rs.getString("loginname"));
				member.setMemberName(rs.getString("membername"));
				member.setSex(rs.getString("sex"));
				member.setManagerId(rs.getInt("managerid"));
				member.setGrade(rs.getString("grade"));
				member.setMemberInstitute(rs.getString("memberinstitute"));
				member.setAddress(rs.getString("address"));
				member.setPhonenumber(rs.getString("phonenumber"));
				member.setEmail(rs.getString("email"));
				member.setMemberHeader(rs.getString("memberheader"));
				member.setJoinclub(rs.getString("clubname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return member;
	}

	/**
	 * 主页中的注册
	 * @param login
	 * @param member
	 * @return
	 */
	public String addIndexLogin(Login login, Member member) {
		String judge = null;
		try {
			//获取连接
			Connection con = getCon();
			//根据登录名获取登录对象
			LoginDao logindao = new LoginDao();
			Login l = logindao.getLoginByName(login.getLoginName());
			if (l == null) {//判断该登录名是否可用
				try {
					//设置不自动提交
					con.setAutoCommit(false);
					//要插入到login  和  member  的 SQL
					String sql = "insert into login(loginname,loginpass) values(?,?)";
					String sql1 = "insert into member(memberid,email,phonenumber)values(?,?,?)";
					String sql2 = "insert into clubinfo(memberid,clubid)values(?,?)";
					//获取SQL执行结果	
					int temp = exeUpdate(sql, login.getLoginName(), login.getLoginPass());
					int temp1 = exeUpdate(sql1, login.getLoginName(), member.getEmail(), member.getPhonenumber());
					int temp2 = exeUpdate(sql2, login.getLoginName(), 13);
					//如果两条SQL都执行成功，则提交，否自回滚
					if (temp > 0 && temp1 > 0&&temp2>0) {// 都执行成功
						//提交事务
						con.commit();
						//设置为自动提交
						con.setAutoCommit(true);
						judge = "success";
					} else {//有失败的信息
						//回滚事务，不提交
						con.rollback();
						//设为自动提交
						con.setAutoCommit(true);
						judge = "fail";
					}
				} catch (Exception e) {
					judge = "fail";
				} finally {
					//关闭所有连接
					closeAll();
				}
			} else {//该登录名已经存在，不能注册，退出
				judge = "exist";
			}
		} catch (SQLException e) {
			System.out.println("MemberDao addIndexLogin is wrong");
			judge = "fail";
		}
		return judge;
	}

	/**
	 * 添加成员
	 * @param member
	 * @return
	 */
	public int addMember(Member member) {
		int msg = 0;
		try {
			//获取连接
			getCon();
			int max=0;
			String sql = "SELECT max(memberid) FROM member";
			// 执行sql
			exeQuery(sql);
			ResultSet ResultSet = (ResultSet) ps.executeQuery();
			// 如果存在结果，将其赋值给itemCont
			if (ResultSet.next()) {
				max = ResultSet.getInt(1);
			}
			//要执行的插入SQL语句
			sql = "insert into member(memberid,membername,sex,memberheader,grade,address,email,phonenumber) values(?,?,?,?,?,?,?,?)";
			//执行SQL，并传参数，并获手影响行数
			msg = exeUpdate(sql,max+1, member.getMemberName(), member.getSex(), member.getMemberHeader(),
					member.getGrade(), member.getAddress(), member.getEmail(), member.getPhonenumber());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return msg;
	}

	/**
	 * 根据登录名删除成员
	 * @param loginName
	 * @return
	 */
	public int deleteMember(String loginName) {
		int result = 0;
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		try {
			//获取连接
			Connection con =getCon();
			try {
				//设置不自动提交
				con.setAutoCommit(false);
			//要执行的删除SQL
			String sql = "delete from clubinfo where memberid=?";
			String sql1 = "delete from joinn where memberid=?";
			String sql2 = "delete from evaluate where memberid=?";
			String sql3 = "delete from member where memberid=?";
			//执行SQL传入参数，并获取受影响行数
			result = exeUpdate(sql, new Object[] { loginName });
			result1 = exeUpdate(sql1, new Object[] { loginName });
			result2 = exeUpdate(sql2, new Object[] { loginName });
			result3 = exeUpdate(sql3, new Object[] { loginName });
			if (result3 > 0) {// 都执行成功
				//提交事务
				con.commit();
				//设置为自动提交
				con.setAutoCommit(true);
			} else {//有失败的信息
				//回滚事务，不提交
				con.rollback();
				//设为自动提交
				con.setAutoCommit(true);
			}
		} catch (Exception e) {
		} finally {
			//关闭所有连接
			closeAll();
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return result;
	}

	/**
	 * 更新成员 根据loginname
	 * @param member
	 * @return
	 */
	public int updateMember(Member member) {
		int result = 0;
		try {
			//获取连接
			getCon();
			//要执行的更新SQL
			String sql = "update member set membername=?,sex=?,memberheader=?,grade=?,memberinstitute=?,address=?,email=?,phonenumber=? where memberid=?";
			//执行SQL传入参数，并获取手影响行数
			result = exeUpdate(sql,new Object[] { member.getMemberName(), member.getSex(), member.getMemberHeader(),
							member.getGrade(), member.getMemberInstitute(), member.getAddress(),
							member.getEmail(), member.getPhonenumber(),member.getLoginName() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return result;
	}

	/**
	 * 根据成员名获取登录名
	 * @param membername
	 * @return
	 */
	public String getLoginNameByName(String membername) {
		String loginName = null;
		try {
			//获取连接
			getCon();
			//要执行的查询SQL，
			String sql = "select memberid from member where membername=?";
			//执行SQL并传入参数
			exeQuery(sql, membername);
			//获取结果集
			ResultSet rs = (ResultSet) ps.executeQuery();
			//如果结果集存在，获取对应loginName字段
			while (rs.next()) {
				loginName = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return loginName;
	}

	/**
	 * 未搜索框获取成员列表
	 * @param membername  模糊字段
	 * @param page 分页信息
	 * @return
	 */
	public List<Member> getMemberForSerach(String membername, Page page) {
		List<Member> members = new ArrayList<Member>();

		try {
			//获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "select count(1) from member as m,login as l,club as c,clubinfo as ci where m.memberid=l.loginname and m.memberid=ci.memberid and ci.clubid=c.clubid and m.membername like ? ";
			//执行SQL 并传入参数
			exeQuery(countsql, "%" + membername + "%");
			//获取结果集
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果存在结果，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			//要执行的查询的SQL
			String sql = "select l.loginname,m.membername,m.sex,l.managerid,m.grade,m.memberinstitute,m.phonenumber,m.email,c.clubname from member as m,login as l,club as c,clubinfo as ci where m.memberid=l.loginname and  m.memberid=ci.memberid and ci.clubid=c.clubid and m.membername like ? limit ?,?";
			//执行SQL 并传入参数
			exeQuery(sql, "%" + membername + "%", page.getItemStart(), page.getPageSize());
			//获取结果集
			ResultSet rs = (ResultSet) ps.executeQuery();
			//如果结果集不为空，获取相应字段，赋值给一个新的member对象，并将其添加到members集合
			while (rs.next()) {
				Member member = new Member();
				member.setLoginName(rs.getString("loginname"));
				member.setMemberName(rs.getString("membername"));
				member.setSex(rs.getString("sex"));
				member.setManagerId(rs.getInt("managerid"));
				member.setGrade(rs.getString("grade"));
				member.setMemberInstitute(rs.getString("memberinstitute"));
				member.setPhonenumber(rs.getString("phonenumber"));
				member.setEmail(rs.getString("email"));
				member.setJoinclub(rs.getString("clubname"));
				//将member对象添加到members集合中
				members.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return members;
	}

}
