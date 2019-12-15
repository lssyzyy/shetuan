package com.shetuan.servelt;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shetuan.bean.Community;
import com.shetuan.bean.Login;
import com.shetuan.bean.Member;
import com.shetuan.dao.CommunityDao;
import com.shetuan.dao.MemberDao;

/**
 * Servlet implementation class CommunityInfoUpdate
 */
public class CommunityInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CommunityDao communityDao = new CommunityDao();
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			Map<String, String> fromFilds = new HashMap<String, String>();
			String fileName = null;
			if (isMultipart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);

				@SuppressWarnings("unchecked")
				List<FileItem> /* FileItem */ items = upload.parseRequest(request);

				@SuppressWarnings("rawtypes")
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();

					if (item.isFormField()) {
						// 获取文件名和类型
						String name = item.getFieldName();
						String value = item.getString("utf-8");
						fromFilds.put(name, value);

					} 
				}

				Community community = new Community();
				community.setClubId(fromFilds.get("clubid"));
				community.setClubName(fromFilds.get("clubname"));
				MemberDao memberDao=new MemberDao();
				String createrId = memberDao.getLoginNameByName(fromFilds.get("creatername"));
				community.setCreaterid(createrId);
				SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM-dd");
				Date crdate=null;
				try {
					crdate = simdate.parse(fromFilds.get("createtime"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				community.setCreatetime(crdate);
				community.setClubNum(Integer.valueOf(fromFilds.get("clubnum")));
				community.setClubPlace(fromFilds.get("clubplace"));
				community.setClubClassid(Integer.valueOf(fromFilds.get("clubclass")));
				community.setIscreate(Integer.valueOf(fromFilds.get("iscreate")));
				community.setClubInform(fromFilds.get("clubinform"));
				community.setClubFinance(Float.valueOf(fromFilds.get("clubfinance")));

				System.out.println("name:" + community.getClubName());
				int result = communityDao.updateCommunity(community);
				String status=fromFilds.get("status");
				if (result > 0) {
					request.getRequestDispatcher("admin/Query?lru=clist").forward(request, response);
					return;
				} else {
					request.setAttribute("returnURL", "main");
					response.sendRedirect("error.jsp");
					return;
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
