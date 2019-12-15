package com.shetuan.servelt;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shetuan.bean.Activity;
import com.shetuan.bean.Community;
import com.shetuan.dao.ActivityDao;
import com.shetuan.dao.CommunityDao;
import com.shetuan.dao.MemberDao;

/**
 * Servlet implementation class ActivityInfoUpdate
 */
public class ActivityInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActivityDao activityDao = new ActivityDao();
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

				Activity activity = new Activity();
				activity.setActivityName(fromFilds.get("activityname"));
				activity.setMainclub(fromFilds.get("mainclub"));
				activity.setFinance(Float.valueOf(fromFilds.get("finance")));
				SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM-dd");
				Date startdate=null;
				Date enddate=null;
				try {
					startdate = simdate.parse(fromFilds.get("start"));
					enddate = simdate.parse(fromFilds.get("end"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				activity.setStarttime(startdate);
				activity.setEndtime(enddate);
				activity.setPlace(fromFilds.get("place"));
				activity.setIntroduction(fromFilds.get("introduction"));
				activity.setHold(Integer.valueOf(fromFilds.get("hold")));

				System.out.println("name:" + activity.getActivityName());
				int result = activityDao.updateActivity(activity);
				String status=fromFilds.get("status");
				if (result > 0) {
					request.getRequestDispatcher("admin/Query?lru=alist").forward(request, response);
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

