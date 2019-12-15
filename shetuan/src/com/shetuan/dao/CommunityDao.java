package com.shetuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shetuan.bean.Community;
import com.shetuan.bean.Member;
import com.shetuan.util.Page;

/**
 * 社团信息的增删改查
 * 
 * @author Administrator
 */
public class CommunityDao extends BaseDao {

	/**
	 * 获取社团列表
	 * 
	 * @param page
	 *            分页信息
	 * @return 社团集合
	 */
	public List<Community> getCommunitiesForPage(Page page) {
		List<Community> communitys = new ArrayList<Community>();
		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(*) FROM club as c,member as m,clubclass as cl WHERE c.createrid=m.memberid and cl.classid=c.clubclass and c.iscreate=1";
			// 执行sql
			exeQuery(countsql);
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果存在结果，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				System.out.println("CommunityDaozhognde count:" + count);
				page.setItemCont(count);
			}
			// 查询社团的详细信息
			String sql = "SELECT clubname,c.clubfinance,c.createrid,m.membername,c.createtime,c.clubnumber,c.clubplace,cl.classname,c.iscreate FROM club as c,member as m,clubclass as cl WHERE c.createrid=m.memberid and cl.classid=c.clubclass and c.iscreate=1 ORDER BY c.clubid limit ?,?";
			// 执行sql ，传入分页的起始页，每页大小
			exeQuery(sql, page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果存在结果将其封装为一个新的community对象，添加到list集合
			while (rs.next()) {
				Community community = new Community();
				community.setClubName(rs.getString(1));
				community.setClubFinance(rs.getFloat(2));
				community.setCreaterid(rs.getString(3));
				community.setCreatername(rs.getString(4));
				community.setCreatetime(rs.getDate(5));
				community.setClubNum(rs.getInt(6));
				community.setClubPlace(rs.getString(7));
				community.setClubClassname(rs.getString(8));
				community.setIscreate(rs.getInt(9));
				// 将新的community对象添加到communitys集合中
				communitys.add(community);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return communitys;
	}
	
	
	public List<Community> getWaitCommunitiesForPage(Page page) {
		List<Community> communitys = new ArrayList<Community>();
		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(*) FROM club as c,member as m,clubclass as cl WHERE c.createrid=m.memberid and cl.classid=c.clubclass and c.iscreate=0";
			// 执行sql
			exeQuery(countsql);
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果存在结果，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				System.out.println("CommunityDaozhognde count:" + count);
				page.setItemCont(count);
			}
			// 查询社团的详细信息
			String sql = "SELECT clubname,c.clubfinance,c.createrid,m.membername,c.createtime,c.clubnumber,c.clubplace,cl.classname,c.iscreate FROM club as c,member as m,clubclass as cl WHERE c.createrid=m.memberid and cl.classid=c.clubclass and c.iscreate=0 ORDER BY c.clubid limit ?,?";
			// 执行sql ，传入分页的起始页，每页大小
			exeQuery(sql, page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果存在结果将其封装为一个新的community对象，添加到list集合
			while (rs.next()) {
				Community community = new Community();
				community.setClubName(rs.getString(1));
				community.setClubFinance(rs.getFloat(2));
				community.setCreaterid(rs.getString(3));
				community.setCreatername(rs.getString(4));
				community.setCreatetime(rs.getDate(5));
				community.setClubNum(rs.getInt(6));
				community.setClubPlace(rs.getString(7));
				community.setClubClassname(rs.getString(8));
				community.setIscreate(rs.getInt(9));
				// 将新的community对象添加到communitys集合中
				communitys.add(community);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return communitys;
	}
	/**
	 * 根据社团名获取社团详细信息
	 * 
	 * @param communityName
	 * @return
	 */
	public Community getCommunityByName(String communityName) {
		Community community = null;
		try {
			// 获取连接
			getCon();
			// 要执行的sql语句
			String sql = "SELECT c.clubid,c.clubname,c.clubfinance,c.createrid,m.membername,c.createtime,c.clubnumber,c.clubplace,c.clubclass,cl.classname,c.iscreate,c.clubinform FROM club as c,member as m,clubclass as cl WHERE c.createrid=m.memberid and cl.classid=c.clubclass and c.clubname=? and c.iscreate=1";
			// 执行sql，并传入参数：社团名
			exeQuery(sql, communityName);
			// 获取执行结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果存在，将其封装为新的community对象
			if (rs.next()) {
				/*
				 * 获取结果中的每一个字段
				 */
				String cId=rs.getString("clubid");
				String cName = rs.getString("clubname");
				float finance=rs.getFloat("clubfinance");
				String creatername = rs.getString("membername");
				String createrid = rs.getString("createrid");
				Date cDate = rs.getDate("createtime");
				int cNum = rs.getInt("clubnumber");
				String cplace = rs.getString("clubplace");
				int cClass = rs.getInt("clubclass");
				int isCreate = rs.getInt("iscreate");
				String cinfo = rs.getString("clubinform");
				/*
				 * 创建新的community对象，将获取的字段set进community
				 */
				community = new Community();

				community.setClubId(cId);
				community.setClubName(cName);
				community.setClubFinance(finance);
				community.setCreaterid(createrid);
				community.setCreatername(creatername);
				community.setCreatetime(cDate);
				community.setClubNum(cNum);
				community.setClubPlace(cplace);
				community.setClubClassid(cClass);
				community.setIscreate(isCreate);
				community.setClubInform(cinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return community;
	}
	public int maxid() {
		int max=0;
		try {
			// 获取连接
			getCon();
			// 查询社团名称是否可用
				
				String msql = "SELECT max(CAST(clubid AS SIGNED)) FROM club";
				// 执行sql
				exeQuery(msql);
				ResultSet ResultSet = (ResultSet) ps.executeQuery();
				// 如果存在结果，将其赋值给itemCont
				if (ResultSet.next()) {
					max = ResultSet.getInt(1);
				}
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					// 关闭所有连接
					
				}
				return max;
		}
	/**
	 * 管理员添加社团
	 * 
	 * @param community
	 * @return
	 */
	public String addAdminCommunity(Community community) {
		String judge = null;
		try {
			// 获取连接
			getCon();
			// 查询社团名称是否可用
			Community comm = getCommunityByName(community.getClubName());
			int max=maxid();
			if (comm == null) {// 社团名可用，执行插入
				
				String sql = "INSERT INTO club(clubid,clubname,createrid,createtime,clubnumber,clubplace,clubclass,iscreate,clubinform)VALUES(?,?,?,?,?,?,?,?,?)";
				// 执行sql 传入相关参数，并获取执行影响行数
				int temp = exeUpdate(sql,max+1,community.getClubName(), community.getCreaterid(),
						community.getCreatetime(), community.getClubNum(), community.getClubPlace(),
						community.getClubClassid(), community.getIscreate(), community.getClubInform());
				if (temp > 0) {// 执行成功
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
	public int updateCommunity(Community community) {
		int result = 0;
		try {
			//获取连接
			getCon();
			//要执行的更新SQL
			String sql = "update club set clubname=?,clubplace=?,clubfinance=?,clubnumber=?,createtime=?,clubinform=?,createrid=?,iscreate=?,clubclass=? where clubid=?";
			//执行SQL传入参数，并获取手影响行数
			result = exeUpdate(sql,new Object[] { community.getClubName(), community.getClubPlace(), community.getClubFinance(),
							community.getClubNum(), community.getCreatetime(), community.getClubInform(),
							community.getCreaterid(),community.getIscreate() ,community.getClubClassid(),community.getClubId() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return result;
	}

	public int deleteCommunity(String clubname) {
		int result = 0;
		try {
			//获取连接
			getCon();
			//要执行的更新SQL
			String sql = "update club set iscreate=2 where clubname=?";
			//执行SQL传入参数，并获取手影响行数
			result = exeUpdate(sql,new Object[] { clubname });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return result;
	}
	public int shenpCommunity(String clubname) {
		int result = 0;
		try {
			//获取连接
			getCon();
			//要执行的更新SQL
			String sql = "update club set iscreate=1 where clubname=?";
			//执行SQL传入参数，并获取手影响行数
			result = exeUpdate(sql,new Object[] { clubname });
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
	 * 根据社团名获取社团id
	 * 
	 * @param cname
	 * @return
	 */
	public int getCommunityIdByCName(String cname) {
		int communityid = 0;
		try {
			// 如果当前连接为空，则创建新的连接，否则使用当前连接
			if (connection == null) {
				getCon();
			}
			// 要执行sql
			String sql = "select clubid from club where clubname=? and iscreate=1";
			// 执行sql。传入参数：社团名称
			exeQuery(sql, cname);
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 若果结果存在，获取 community_id 值
			if (rs.next()) {
				communityid = rs.getInt("clubid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return communityid;
	}

	/**
	 * 为搜索框，获取所有相关社团
	 * 
	 * @param com
	 *            模糊查询的字段
	 * @param page
	 *            分页信息
	 * @return 相关社团结果集合
	 */
	public List<Community> getCommunitiesForSearch(String com, Page page) {
		List<Community> communitys = new ArrayList<Community>();
		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(1) FROM club as c,member as m,clubclass as cl WHERE c.iscreate=1 and c.createrid=m.memberid and cl.classid=c.clubclass and clubname like ?";
			// 执行sql，并传入参数：模糊字段
			exeQuery(countsql, "%" + com + "%");
			// 获取查询结果
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果结果存在,将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 要查询的社团详细信息
			String sql = "SELECT clubname,m.membername,c.createtime,c.clubnumber,c.clubplace,cl.classname,c.iscreate,c.clubfinance FROM club as c,member as m,clubclass as cl WHERE c.createrid=m.memberid and cl.classid=c.clubclass and c.iscreate=1 and clubname like ? ORDER BY c.clubid limit ?,?";
			// 执行sql，并传入参数：模糊字段，查询起始页，每页大小
			exeQuery(sql, "%" + com + "%", page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果存在，将其封装为新的community对象，添加到list集合
			while (rs.next()) {
				Community community = new Community();
				community.setClubName(rs.getString(1));
				community.setCreatername(rs.getString(2));
				community.setCreatetime(rs.getDate(3));
				community.setClubNum(rs.getInt(4));
				community.setClubPlace(rs.getString(5));
				community.setClubClassname(rs.getString(6));
				community.setIscreate(rs.getInt(7));
				community.setClubFinance(rs.getFloat(8));
				// 添加到communitys集合中
				communitys.add(community);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return communitys;
	}
	public List<Community> getWaitCommunitiesForSearch(String com, Page page) {
		List<Community> communitys = new ArrayList<Community>();
		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(1) FROM club as c,member as m,clubclass as cl WHERE c.iscreate=0 and c.createrid=m.memberid and cl.classid=c.clubclass and clubname like ?";
			// 执行sql，并传入参数：模糊字段
			exeQuery(countsql, "%" + com + "%");
			// 获取查询结果
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果结果存在,将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 要查询的社团详细信息
			String sql = "SELECT clubname,m.membername,c.createtime,c.clubnumber,c.clubplace,cl.classname,c.iscreate,c.clubfinance FROM club as c,member as m,clubclass as cl WHERE c.createrid=m.memberid and cl.classid=c.clubclass and c.iscreate=0 and clubname like ? ORDER BY c.clubid limit ?,?";
			// 执行sql，并传入参数：模糊字段，查询起始页，每页大小
			exeQuery(sql, "%" + com + "%", page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果存在，将其封装为新的community对象，添加到list集合
			while (rs.next()) {
				Community community = new Community();
				community.setClubName(rs.getString(1));
				community.setCreatername(rs.getString(2));
				community.setCreatetime(rs.getDate(3));
				community.setClubNum(rs.getInt(4));
				community.setClubPlace(rs.getString(5));
				community.setClubClassname(rs.getString(6));
				community.setIscreate(rs.getInt(7));
				community.setClubFinance(rs.getFloat(8));
				// 添加到communitys集合中
				communitys.add(community);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return communitys;
	}
}
