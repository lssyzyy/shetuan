<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<link rel="icon">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/css.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/main.css" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(images/main/add.jpg) no-repeat 0px 6px; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
.main-for{ padding:10px;}
.main-for input.text-word{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
.main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
.main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:left; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
#addinfo a{ font-size:14px; font-weight:bold; background:url(images/main/addinfoblack.jpg) no-repeat 0 1px; padding:0px 0 0px 20px; line-height:45px;}
#addinfo a:hover{ background:url(images/main/addinfoblue.jpg) no-repeat 0 1px;}
</style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：社团管理&nbsp;&nbsp;>&nbsp;&nbsp;社团信息</td>
  </tr>
  <tr>
    <td align="left" valign="top" id="addinfo">
    <a  target="mainFrame"  class="">更新社团</a>
         <c:if test="${param.rs =='namewrong' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>没有此社团，请先添加</b></font></c:if>
	    <c:if test="${param.rs =='success' }"><font -size="4px"; color=blue>&nbsp;&nbsp;&nbsp;<b>更新成功</b></font></c:if>
    	<c:if test="${param.rs =='fail' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>更新失败，请重新尝试</b></font></c:if>
    	<c:if test="${param.rs =='wrong' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>旧密码错误</b></font></c:if>    
 	</td>
  </tr>
  <tr>
    <td align="left" valign="top">
       <!-- 上传文件时 要改enctype="multipart/from-data-->
    <form action="${pageContext.request.contextPath}/CommunityInfoUpdate" method="post" enctype="multipart/form-data"">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">

      <tr>
        <td align="left" valign="middle" class="borderright borderbottom main-for" colspan="4" style="border-left:none; border-right:none;"></td>
      </tr>

      <tr>
        <td align="right" valign="middle" class="borderright borderbottom bggray">社团编号：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="clubid" value="${community.clubId }" class="text-word">

        <td align="right" valign="middle" class="borderright borderbottom bggray">社团名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="clubname" value="${community.clubName }" class="text-word">
        </td>
      </tr>
        <tr>
        <td align="right" valign="middle" class="borderright borderbottom bggray">创建者：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="creatername" value="${community.creatername }" class="text-word">

        <td align="right" valign="middle" class="borderright borderbottom bggray">创建时间：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="createtime" value="${community.createtime }" class="text-word">
        </td>
        </tr>
        <tr>
        <td align="right" valign="middle" class="borderright borderbottom bggray">人数：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="clubnum" value="${community.clubNum }" class="text-word">

        <td align="right" valign="middle" class="borderright borderbottom bggray">办公地点：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="clubplace" value="${community.clubPlace }" class="text-word">
        </td>
        </tr>
        <tr>
        <td align="right" valign="middle" class="borderright borderbottom bggray">社团类别：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="clubclass" value="${community.clubClassid }" class="text-word">

        <td align="right" valign="middle" class="borderright borderbottom bggray">是否审批通过：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="iscreate" value="${community.iscreate }" class="text-word">
        </td>
        </tr>
        <tr>
        
        <td align="right" valign="middle" class="borderright borderbottom bggray">社团简介：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="clubinform" value="${community.clubInform }" class="text-word">
        
        <td align="right" valign="middle" class="borderright borderbottom bggray">社团经费：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="clubfinance" value="${community.clubFinance }" class="text-word">
        </td>
        </tr>
       
      <tr>
      	<td>
      		 <input name="ope" type="hidden" value="minfo"/>
      	</td>
      </tr>
      
      <tr>
        <td align="center" valign="middle" class="borderright borderbottom main-for" colspan="2" style="padding-left:38%; border-right:none;">
          <input name="" type="submit" value="更新" class="text-but" >
        </td>
        <td align="center" valign="middle" class="borderright borderbottom main-for" colspan="2" style="padding-right:38%; border-right:none;">
              <input name="" type="reset" value="重置" class="text-but" >
        </td>
      </tr>

    </table>
    </form>
    </td>
    </tr>
</table>
</body>
</html>