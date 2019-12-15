<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>成员信息</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Exchange Education a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css files -->
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/chromagallery.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/regist.css" type="text/css" rel="stylesheet" />
<link href="css/info.css" rel="stylesheet" type="text/css"   />
<!-- /css files -->
<!-- fonts -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Viga' rel='stylesheet' type='text/css'>
<!-- /fonts -->
<link rel="icon">

<style>
body {
    font-size: 14px;
    font-family: "微软雅黑";
    background-attachment: fixed;
    z-index: 0;
    background-size: 100%;
    background: linear-gradient(to bottom right,#50a3a2,#53e3a6);
}
.containers input[type='submit'] {
            font-size: 16px;
            color: #FFFFFF;
            background-color: #808080;
        }
      .containers input {
            width: 200px;
            display: block;
            height: 36px;
            border: 0;
            outline: 0;
            padding: 6px 10px;
            line-height: 24px;
			margin-left:250px;
            transition: all 0s ease-in 0.1ms;
        }
        .intro{
		font-size:36px;
        color:#FFFFFF;
        font-family: 'Viga', sans-serif;
		line-height:50px;
        float:right;
		position:relative;
		width:560px;
		text-align: left;
        }
        .text{
        font-size:36px;
        color:#FFFFFF;
        margin-left:10px;
		line-height:40px;
        font-family: 'Viga', sans-serif;
        height:50px;
        float:left;
		position:relative;
        }
		div.row.below{
		display:block;
		height:88px;
       	width:1000px;
        }
		#rr main{
		width: 680px;
		float: left;
		margin-left: 100px;
		}
		#rr aside{
		width: 500px;
		float: left;
		}
		.roww{
		width: 560px;
		height: 588px;
		word-wrap:break-word;
		}
</style>
</head>
<body id="index.html" data-spy="scroll" data-target=".navbar" data-offset="60">

<div class="wrap">
<!-- About Section -->
<section class="about-us">
	
	<div id="rr">
		<!--左边-->
		<main>
		<div class="row">
			<p class="text">社团名：<td align="center" valign="middle" class="borderright borderbottom">吉他协会${community.clubName}</td></p>		
		</div>	
		<div class="row below">
			<div class="col-lg-6 col-md-6">
				<div class="about-details">
					<div class="row">
						<div class="col-sm-10 col-xs-12">	
							<div class="about-info slideanim">
								<p>社长：</p>
								
								<td align="center" valign="middle" class="borderright borderbottom">d${community.creatername}</td>
								
							</div>
						</div>
					</div>					
				</div>		
			</div>
		</div>
		<div class="row below">
			<div class="col-lg-6 col-md-6">
				<div class="about-details">
					<div class="row">
						<div class="col-sm-10 col-xs-12">
							<div class="about-info slideanim">
								<p>地点：</p>
								<td align="center" valign="middle" class="borderright borderbottom">教三${community.clubPlace}</td>
								
							</div>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<div class="row below">
			<div class="col-lg-6 col-md-6">
				<div class="about-details">
					<div class="row">
						<div class="col-sm-10 col-xs-12">
							<div class="about-info slideanim">
								<p>人数：</p>
								<td align="center" valign="middle" class="borderright borderbottom">40${community.clubNum}</td>
								
								
							</div>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<div class="row below">
			<div class="col-lg-6 col-md-6">
				<div class="about-details">
					<div class="row">
						<div class="col-sm-10 col-xs-12">
							<div class="about-info slideanim">
							<p>社团成立时间：</p>
							<td align="center" valign="middle" class="borderright borderbottom">2019-12-01${community.createtime}</td>
							
							</div>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<div class="row below">	
			<div class="col-lg-6 col-md-6">
				<div class="about-details">
					<div class="row">
						<div class="col-sm-10 col-xs-12">
							<div class="about-info slideanim">
							<p>社团资金：</p>
							<td align="center" valign="middle" class="borderright borderbottom">10000.0${community.clubFinance}</td>
							
							</div>
						</div>
					</div>		
				</div>
			</div>
		</div>
			<div class="row below">	
			<div class="col-lg-6 col-md-6">
				<div class="about-details">
					<div class="row">
						<div class="col-sm-10 col-xs-12">
							<div class="containers">
								<input type="submit" value="加入社团" onclick=""/>
							</div>
						</div>
					</div>		
				</div>
			</div>
			
			<div class="col-lg-6 col-md-6">
				<div class="about-details">
					<div class="row">
						<div class="col-sm-10 col-xs-12">
							<div class="containers">
								<input type="submit" value="退出社团" onclick=""/>
							</div>
						</div>
					</div>		
				</div>
			</div>
		</div>	
		</main>
	<!--右边-->
		<aside>
	<div class="roww">
		<p class="intro" align="right">社团介绍：<td align="center" valign="middle" class="borderright borderbottom">文化${community.clubInform}</td></p>	
	</div>
	</aside>
	</div>
</section>
            
<ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
		
</div>
</body>
</html>