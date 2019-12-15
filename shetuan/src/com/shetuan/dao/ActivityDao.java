package com.shetuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shetuan.bean.Activity;
import com.shetuan.bean.Community;
import com.shetuan.util.Page;

/**
 * 社团活动的增删改查
 * 
 * @author Administrator
 */
public class ActivityDao extends BaseDao {
	/**
	 * 获取活动列表
	 * 
	 * @param page
	 *            分页信息
	 * @return 社团活动集合
	 */
	public List<Activity> getActivitiesForPage(Page page) {
		List<Activity> activities = new ArrayList<Activity>();

		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(*) FROM activity as a ,hold as h where a.activityid=h.activityid and h.status in('未开始','进行中','已结束')";
			// 执行sql
			exeQuery(countsql);
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果查询结果存在，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 分页查询活动的详细信息
			String sql = "SELECT c.clubname,a.activityname,finance,introduction,starttime,endtime,p.placename,h.status FROM activity as a,hold as h,place as p,club as c WHERE a.activityid=h.activityid and h.placeid=p.placeid and h.status in('未开始','进行中','已结束') and h.clubid=c.clubid limit ?,?";
			// 执行sql ，传入分页的起始页，每页大小
			exeQuery(sql, page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果存在结果将其封装为一个新的activity对象，添加到list集合
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setActivityName(rs.getString(2));
				activity.setMainclub(rs.getString(1));
				activity.setFinance(rs.getFloat(3));
				activity.setIntroduction(rs.getString(4));
				activity.setStarttime(rs.getDate(5));
				activity.setEndtime(rs.getDate(6));
				activity.setPlace(rs.getString(7));
				activity.setStatus(rs.getString(8));
				// 将新的activity对象添加到activities集合中
				activities.add(activity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接，管道
			closeAll();
		}
		return activities;
	}
	
	public List<Activity> getActivitiesForSearch(String act,Page page) {
		List<Activity> activities = new ArrayList<Activity>();

		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(*) FROM activity as a ,hold as h where a.activityid=h.activityid and h.status in('未开始','进行中','已结束') and a.activityname like ?";
			// 执行sql
			exeQuery(countsql,"%" + act + "%");
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果查询结果存在，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 分页查询活动的详细信息
			String sql = "SELECT c.clubname,a.activityname,finance,introduction,starttime,endtime,p.placename,h.status FROM activity as a,hold as h,place as p,club as c WHERE a.activityid=h.activityid and h.placeid=p.placeid and h.status in('未开始','进行中','已结束') and h.clubid=c.clubid and a.activityname like ? limit ?,?";
			// 执行sql ，传入分页的起始页，每页大小
			exeQuery(sql,"%" + act + "%", page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果存在结果将其封装为一个新的activity对象，添加到list集合
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setActivityName(rs.getString(2));
				activity.setMainclub(rs.getString(1));
				activity.setFinance(rs.getFloat(3));
				activity.setIntroduction(rs.getString(4));
				activity.setStarttime(rs.getDate(5));
				activity.setEndtime(rs.getDate(6));
				activity.setPlace(rs.getString(7));
				activity.setStatus(rs.getString(8));
				// 将新的activity对象添加到activities集合中
				activities.add(activity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接，管道
			closeAll();
		}
		return activities;
	}
	public List<Activity> getWaitActivitiesForPage(Page page) {
		List<Activity> activities = new ArrayList<Activity>();

		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(*) FROM activity as a ,hold as h where a.activityid=h.activityid and h.status='待审核'";
			// 执行sql
			exeQuery(countsql);
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果查询结果存在，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 分页查询活动的详细信息
			String sql = "SELECT c.clubname,a.activityname,finance,introduction,starttime,endtime,p.placename,h.status FROM activity as a,hold as h,place as p,club as c WHERE a.activityid=h.activityid and h.placeid=p.placeid and h.status='待审核' and h.clubid=c.clubid limit ?,?";
			// 执行sql ，传入分页的起始页，每页大小
			exeQuery(sql, page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果存在结果将其封装为一个新的activity对象，添加到list集合
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setActivityName(rs.getString(2));
				activity.setMainclub(rs.getString(1));
				activity.setFinance(rs.getFloat(3));
				activity.setIntroduction(rs.getString(4));
				activity.setStarttime(rs.getDate(5));
				activity.setEndtime(rs.getDate(6));
				activity.setPlace(rs.getString(7));
				activity.setStatus(rs.getString(8));
				// 将新的activity对象添加到activities集合中
				activities.add(activity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接，管道
			closeAll();
		}
		return activities;
	}
	public Activity getActivityByName(String activityName) {
		Activity activity = null;
		try {
			// 获取连接
			getCon();
			// 要执行的sql语句
			String sql = "SELECT c.clubname,a.activityid,a.activityname,finance,introduction,starttime,endtime,p.placename,h.status FROM activity as a,hold as h,place as p,club as c WHERE a.activityid=h.activityid and h.placeid=p.placeid and h.clubid=c.clubid and activityname=?";
			// 执行sql，并传入参数：社团名
			exeQuery(sql, activityName);
			// 获取执行结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果存在，将其封装为新的community对象
			if (rs.next()) {
				/*
				 * 获取结果中的每一个字段
				 */
				String clubname=rs.getString("clubname");
				String aName = rs.getString("activityname");
				String id = rs.getString("activityid");
				float finance = rs.getFloat("finance");
				String introduction = rs.getString("introduction");
				String place = rs.getString("placename");
				Date start = rs.getDate("starttime");
				Date end = rs.getDate("endtime");
				String status=rs.getString("status");
				/*
				 * 创建新的community对象，将获取的字段set进community
				 */
				activity = new Activity();
				activity.setPlace(place);
				activity.setActivityId(id);
				activity.setMainclub(clubname);
				activity.setActivityName(aName);
				activity.setFinance(finance);
				activity.setIntroduction(introduction);
				activity.setPlace(place);
				activity.setStarttime(start);
				activity.setEndtime(end);
				activity.setStatus(status);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return activity;
	}
	public String addAdminActivity(Activity activity) {
		String judge = null;
		try {
			// 获取连接
			getCon();
			// 查询社团名称是否可用
			Activity act = getActivityByName(activity.getActivityName());
			getCon();
			if (act == null) {// 社团名可用，执行插入
				int max=0;
				String sql = "SELECT max(CAST(activityid AS SIGNED)) FROM activity";
				// 执行sql
				exeQuery(sql);
				ResultSet ResultSet = (ResultSet) ps.executeQuery();
				// 如果存在结果，将其赋值给itemCont
				if (ResultSet.next()) {
					max = ResultSet.getInt(1)+1;
				}
				String clubid=null;
				sql = "SELECT clubid FROM club where clubname='"+activity.getMainclub()+"'";
				// 执行sql
				exeQuery(sql);
				ResultSet ResultSet1= (ResultSet) ps.executeQuery();
				// 如果存在结果，将其赋值给itemCont
				if (ResultSet1.next()) {
					clubid = ResultSet1.getString(1);
				}
				String placeid=null;
				sql = "SELECT placeid FROM place where placename='"+activity.getPlace()+"'";
				// 执行sql
				exeQuery(sql);
				ResultSet ResultSet2= (ResultSet) ps.executeQuery();
				// 如果存在结果，将其赋值给itemCont
				if (ResultSet2.next()) {
					placeid = ResultSet2.getString(1);
				}
				String placeid1=null;
				sql = "SELECT placeid FROM place where placename='"+activity.getPlace1()+"'";
				// 执行sql
				exeQuery(sql);
				ResultSet ResultSet3= (ResultSet) ps.executeQuery();
				// 如果存在结果，将其赋值给itemCont
				if (ResultSet3.next()) {
					placeid1 = ResultSet3.getString(1);
				}
				String placeid2=null;
				sql = "SELECT placeid FROM place where placename='"+activity.getPlace2()+"'";
				// 执行sql
				exeQuery(sql);
				ResultSet ResultSet4= (ResultSet) ps.executeQuery();
				// 如果存在结果，将其赋值给itemCont
				if (ResultSet4.next()) {
					placeid2 = ResultSet4.getString(1);
				}
				sql = "INSERT INTO activity(activityid,activityname,finance,introduction,activityphoto,starttime,endtime)VALUES(?,?,?,?,?,?,?)";
				// 执行sql 传入相关参数，并获取执行影响行数
				String sql1="insert into hold(activityid,clubid,placeid,status)values(?,?,?,'待审核')";
				if(placeid1 !=null) sql1=sql1+",("+max+","+clubid+","+placeid1+",'待审核')";
				if(placeid2 !=null) sql1=sql1+",("+max+","+clubid+","+placeid2+",'待审核')";
				int temp = exeUpdate(sql,max,activity.getActivityName(), activity.getFinance(),
						activity.getIntroduction(), activity.getActivityPhoto(), activity.getStarttime(),activity.getEndtime());
				int temp1 = exeUpdate(sql1,max,clubid,placeid);
				if (temp > 0&& temp1 > 0) {// 执行成功
					judge = "success";
				} else {// 执行失败
					judge = "fail";
				}
			} else {// 用户名已经存在，退出注册
				judge = "exist";
			}
		} catch (SQLException e) {
			judge = "fail";
		}
		return judge;
	}
	
	public int gethold(String activityname,String clubname,String placename) {
		int hold = 0;
		try {
			// 获取连接
			getCon();
			// 要执行的sql语句
			String sql = "SELECT h.holdid from activity as a,hold as h,place as p,club as c where h.activityid=a.activityid and h.clubid=c.clubid and h.placeid=p.placeid and a.activityname=? and c.clubname=? and p.placename=?";
			// 执行sql，并传入参数：社团名
			exeQuery(sql, activityname,clubname,placename);
			// 获取执行结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果存在，将其封装为新的community对象
			if (rs.next()) {
				hold=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return hold;
	}
	
	public int updateActivity(Activity activity) {
		int result = 0;
		try {
			// 获取连接
			getCon();
			// 查询社团名称是否可用
			Activity act = getActivityByName(activity.getActivityName());
			getCon();
			if (act != null) {// 社团名可用，执行插入	
				String clubid=null;
				String sql = "SELECT clubid FROM club where clubname='"+activity.getMainclub()+"'";
				// 执行sql
				exeQuery(sql);
				ResultSet ResultSet= (ResultSet) ps.executeQuery();
				// 如果存在结果，将其赋值给itemCont
				if (ResultSet.next()) {
					clubid = ResultSet.getString(1);
				}
				String placeid=null;
				sql = "SELECT placeid FROM place where placename='"+activity.getPlace()+"'";
				// 执行sql
				exeQuery(sql);
				ResultSet ResultSet2= (ResultSet) ps.executeQuery();
				// 如果存在结果，将其赋值给itemCont
				if (ResultSet2.next()) {
					placeid = ResultSet2.getString(1);
				}
				sql = "update activity set finance=?,introduction=?,starttime=?,endtime=? where activityname=?";
				// 执行sql 传入相关参数，并获取执行影响行数
				String sql1="update hold set activityid=?,clubid=?,placeid=? where holdid=?";
				int temp = exeUpdate(sql,activity.getFinance(),activity.getIntroduction(),activity.getStarttime(),activity.getEndtime(),activity.getActivityName());
				int temp1 = exeUpdate(sql1,act.getActivityId(),clubid,placeid,activity.getHold());
				if (temp > 0&& temp1 > 0) {// 执行成功
					result=1;
				}
			}}catch (SQLException e) {
			
		}
		return result;
	}
	public int deleteActivity(int holdid) {
		int result = 0;
		try {
			//获取连接
			getCon();
			//要执行的更新SQL
			String sql = "update hold set status='已删除' where holdid=?";
			//执行SQL传入参数，并获取手影响行数
			result = exeUpdate(sql,new Object[] { holdid });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return result;
	}
	public int shenpActivity(int holdid) {
		int result = 0;
		try {
			//获取连接
			getCon();
			//要执行的更新SQL
			String sql = "update hold set status='未开始' where holdid=?";
			//执行SQL传入参数，并获取手影响行数
			result = exeUpdate(sql,new Object[] { holdid });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return result;
	}
	public int updatePlace(int activityname, String place) {
		int result = 0;
		try {
			// 获取连接
			getCon();
			// 要执行的修改SQL
			String sql = "update activity set place=?  where activityname=?";
			// 执行SQL并传入参数
			result = exeUpdate(sql, new Object[] { place, activityname });
		} catch (SQLException e) {
			System.out.println("ActivityDao 更新地点异常");
		}
		return result;
	}
}
