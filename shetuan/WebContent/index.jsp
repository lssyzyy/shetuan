<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>社团生活</title>
<link rel="icon">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Exchange Education a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css files -->
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/chromagallery.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<style type="text/css"> 
#container { width:80%; margin:30px auto; text-align:left; padding:10px; border:1px solid #ccc; height:250px; position:relative; overflow:hidden; font:16px Verdana, Geneva, sans-serif; color:#fff; text-align:left;}
	.noticeList { width:80%; list-style:inside; position:absolute; top:270px; left:10px;}
	.noticeList li { padding-bottom:5px;}
	.noticeList li a { color:#606060; text-decoration:none;}
	.noticeList li a:hover { color:#09F;}
</style>
<!-- /css files -->
<!-- fonts -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Viga' rel='stylesheet' type='text/css'>
<!-- /fonts -->
<!-- js files -->
<script src="js/modernizr.custom.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/speech/jQuery.speech.js"></script>
<script src="js/speech/jQuery.speech.min.js"></script>
<script src="js/backtotop.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/SmoothScroll.min.js"></script>
<!-- /js files -->
</head>

<body id="index.html" data-spy="scroll" data-target=".navbar" data-offset="60">
<!-- Top Bar -->
<section class="top-bar">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
				<a href="#index.html" class="logo"><h1>社团生活</h1></a>
			</div>
			
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
				<ul class="social-icons1">
				
				<c:if test="${login == null}">
					<li class="y-in"><a href="login.jsp" style="{color:#fffff;}">登录</a></li>
					<li ><a href="regist.jsp" style="{color:#fffff;}">注册</a></li>
				</c:if>
				<c:if test="${login != null}">
					<li class="y-in"><a href="MemberInfo?status=index&mname=${login.loginName }">欢迎：${login.loginName }</a></li>  
					<li><a href="loginOut"> | 注销</a></li>
				</c:if>
				
				</ul>
			</div>
			
		</div>
	</div>
</section>
<!-- /Top Bar -->
<!-- Navigation Bar -->
<div class="navbar-wrapper">
    <div class="container">
		<nav class="navbar navbar-inverse navbar-static-top cl-effect-21">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">社团生活</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">首页</a></li>
						<li><a href="#about">人气社团</a></li>
						<li><a href="#services">科技创新类社团</a></li>
						<li><a href="#gallery">校艺术团</a></li>
						<li><a href="#curriculum">五星社团</a></li>
						<li><a href="#notice">活动公告</a></li>
					</ul>
				</div>
			</div>
        </nav>
    </div>
</div>
<!-- /Navigation Bar -->
<!-- Banner Section -->
 <!-- Carousel
    ================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
			<img class="first-slide" src="images/guitar.jpg" alt="First slide">
			<div class="container">
				<div class="carousel-caption">
              
				</div>
			</div>
        </div>
        <div class="item">
			<img class="second-slide" src="images/chenyun2.jpg" alt="Second slide">
			<div class="container">
				<div class="carousel-caption">
              
				</div>
			</div>
        </div>
        <div class="item">
			<img class="third-slide" src="images/daxingkong.jpg" alt="Third slide">
			<div class="container">
				<div class="carousel-caption">
              
				</div>
			</div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->
<!-- /Banner Section -->
<!-- About Section -->
<section class="our-services" id="about">
	<h3 class="text-center slideanim">人气社团</h3>
	<p class="text-center slideanim">人气社团概要</p>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img src="images/guitar.jpg" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a href="community_info.jsp" target="_blank">吉他协会</a></h4>
								<p>吉他协会</p>
							</div>
						</div>	
					</div>	
				</div>
				<div class="serv-info slideanim speech">
					<p>
				                 简介：韵律不觉周围绕，六弦梦圆近咎朝。爱音乐孩子们的天赋，有梦孩子们的天堂。这就是浙江大学城市学院吉他协会。吉他协会是我校一个纯音乐性质的社团，成立于2004年，至今已经对众多爱好吉他的同学进行过吉他入门教学，并在校内外成功举办了多场大型演出。
				                </br>
                                               特色活动：10年，“哇哈哈蓝莓之夜——2010我们最后的校园民谣毕业晚会”用音符为大四毕业生践行。
                                    11年，“放学了！——纪念我们最后的大学时光”毕业晚会
                                    12年，“下一个天亮——破晓”图信大型乐队演出晚会
                                    13年，“唱给过去的自己”大型图信毕业晚会
                                    14年，“既然青春留不住”毕业晚会
                                    15年，“一页四年”大型毕业晚会
                                    17年，“颂·别”毕业乐队专场晚会
                                    以及从10年开始每年一度情人坡草地音乐弹唱会
                     </p>                                                    
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img src="images/moshu.jpg" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a href="community_info.jsp" target="_blank">浙大城院黑翼魔术社</a></h4>
								<p>浙大城院黑翼魔术社</p>
							</div>
						</div>
					</div>
				</div>	
				<div class="serv-info slideanim speech">
					<p>
					   宗旨：疲乏生活中，总是不乏偶得惊喜。愿意与我们来一场惊喜约会吗，希望能在你繁忙的学业中，带与你梦幻般的神奇体验——黑翼魔术社！</br>
					   简介：《遇见奇迹——黑翼魔术社魔术文化月专场演出》旨在通过新颖的创意、真切的表演形式、丰富的表演内容和极具现代化的演出手段，充分展示我们魔术社团的风采，展示魔术的神奇、惊险、 魔幻、引人入胜、耐人寻味，同时展示黑翼魔术社这一独特群体的优秀独特的气质、丰富的内涵、内在的生机活力。演出将以惊奇炫酷的场面，精彩生动的表演和神秘的气氛，充分体现魔术的魅力，从而深刻城院学生对魔术社印象。</br>
					</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /About Section -->	
<div class="line"></div>
<!-- Our Services -->
<section class="our-services" id="services">
	<h3 class="text-center slideanim">科技创新类社团</h3>
	<p class="text-center slideanim">科技创新类社团概要</p>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img src="images/ubi.jpg" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a href="community_info.jsp" target="_blank">ubimaker创意工坊（谷歌实验室）</a></h4>
								<p>ubimaker创意工坊（谷歌实验室）</p>
							</div>
						</div>	
					</div>	
				</div>
				<div class="serv-info slideanim speech">
					<p>
				          简介：在 UbiMaker，你可以领略别样的领域知识，最实际的趣味体验，花样体会技术魅力和多样的前沿技术。
让你紧跟技术产业风向，拥抱时代浪潮，分享、学习、体验、成长！</br>
					</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /Our Services -->
<div class="line"></div>
<!-- Our Gallery -->
<section class="our-services" id="gallery">
	<h3 class="text-center slideanim">校艺术团</h3>
	<p class="text-center slideanim">校艺术团概要</p>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img src="images/chenyun.jpg" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a href="community_info.jsp" target="_blank">晨韵合唱团</a></h4>
								<p>晨韵合唱团</p>
							</div>
						</div>	
					</div>	
				</div>
				<div class="serv-info slideanim speech">
					<p>
				          简介：隶属浙江大学城市学院大学生艺术团，是集大合唱、小合唱、独唱、对唱、小组团体、Acappella（阿卡贝拉），等多种演唱形式于一体的团体。主要在各大院级典礼、晚会中表演以及到国内外校艺术团进行交流。合唱是一种集体性的歌唱艺术。我们在合唱中，人员分成若干声部（常见的女高音（soprano，S）女低音（alto，A）男高音（tenore /tenor，T）男低音（basso/bass，B））分别采用不同的旋律，进行合唱。
作为校艺术团人数最多的团队，歌唱分团自成立以来在来晶老师的指导下，参与了许多活动演出和比赛，深受师生欢迎，并得到浙江省艺术节专家评委们的肯定，硕果累累（浙江省大学生艺术节）</br>
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img src="images/daxingkong.jpg" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a href="community_info.jsp" target="_blank">大猩空嘻哈文化交流社</a></h4>
								<p>大猩空嘻哈文化交流社</p>
							</div>
						</div>
					</div>
				</div>	
				<div class="serv-info slideanim speech">
					<p>
				          简介：作为一个有自己独到理念的社团，我们一直坚持以街舞来张扬个性，展示青春的活力与激情，表现勇于进取的生活态度，大猩空不仅仅是一个社团，更是一群热爱街舞的人的家，我们可以让你了解到正统的街舞文化，感受最纯正的街舞氛围。</br>
					   特色活动：嘻哈之夜，节奏大师
					</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /Our Gallery -->
<div class="line"></div>
<!-- Our  curriculum-->
<section class="our-services" id="curriculum">
	<h3 class="text-center slideanim">五星社团</h3>
	<p class="text-center slideanim">五星社团概要</p>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img src="images/yanjiang.jpg" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a href="community_info.jsp" target="_blank">浙大城院演讲与口才协会</a></h4>
								<p>浙大城院演讲与口才协会</p>
							</div>
						</div>	
					</div>	
				</div>
				<div class="serv-info slideanim speech">
					<p>
				          简介：浙江大学城市学院 演讲与口才协会（简称“口协”）至今成立十五周年，是一个以锻炼口才，培养综合素质为宗旨的协会。自协会成立以来坚持以“实干、智慧、归属感”为指导理念，“实干口协，为梦想发声”为核心目标，成功推出了传媒与人文学院新生辩论赛、浙江省大学生经典诗文诵读大赛（城院赛区）、城院演说家等精品活动，蝉联“五星级社团”的荣誉称号。不仅如此，还有中国演讲口才协会联盟主席丁建明与拱墅区演讲与口才协会会长李郁丰等老师莅临指导。
在成功承办活动的同时，社团内部也走出了众多校内优秀主持人、演说家及出色辩手</br>
					</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /Our curriculum -->
<div class="line"></div>
<!-- /Our contact -->
<!--/notice-->
<section class="our-services" id="notice">
<h3 class="text-center slideanim">活动公告</h3>
<div id="container">
    <ul class="noticeList">
        <li><a href="activityDetil.jsp" title=""  target="_Blank">大猩空嘻哈文化交流社 2019.5.25 风雨操场：嘻哈之夜</a></li>
        <li><a href="activityDetil.jsp" title="" target="_blank">大猩空嘻哈文化交流社 2019.11.6 风雨操场：嘻哈之夜</a></li>
        <li><a href="activityDetil.jsp" title="" target="_blank">大猩空嘻哈文化交流社 2019.10.9 风雨操场：嘻哈之夜</a></li>
        <li><a href="activityDetil.jsp" title="" target="_blank">大猩空嘻哈文化交流社 2019.8.6 风雨操场：嘻哈之夜</a></li>
        <li><a href="activityDetil.jsp" title="" target="_blank">大猩空嘻哈文化交流社 2019.8.20 风雨操场：嘻哈之夜</a></li>
        <li><a href="activityDetil.jsp" title="" target="_blank">大猩空嘻哈文化交流社  2019.9.25 风雨操场：嘻哈之夜</a></li>
        <li><a href="activityDetil.jsp" title="" target="_blank">大猩空嘻哈文化交流社 2019.9.10	风雨操场：嘻哈之夜</a></li>
        <li><a href="activityDetil.jsp" title="" target="_blank">大猩空嘻哈文化交流社	2019.9.26  风雨操场：嘻哈之夜</a></li>
        <li><a href="activityDetil.jsp" title="" target="_blank">大猩空嘻哈文化交流社  2019.10.1  风雨操场：嘻哈之夜</a></li>
        <li><a href="activityDetil.jsp" title="" target="_blank">大猩空嘻哈文化交流社 2019.11.20 风雨操场：嘻哈之夜</a></li>
        <li><a href="activityDetil.jsp" title="" target="_blank">大猩空嘻哈文化交流社  2019.11.23 风雨操场：嘻哈之夜</a></li>
    </ul>
</div>

</section>
<!--/notice-->
<!-- Footer Section -->
<section class="footer">
	<h2 class="text-center">THANKS FOR VISITING US</h2>
		<p>
			<a href="http://www.zucc.edu.cn/" target="_blank">浙江大学城市学院官网</a>
		</p><br>
		<p>QQ群号:123456789</p>
		<div id="Result">
</div>
		
</section>
<!-- /Footer Section -->
<!-- Back To Top -->
<a href="#0" class="cd-top">Top</a>
<!-- /Back To Top -->
<!-- js files -->

<!-- js files for gallery -->
<script src="js/chromagallery.pkgd.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() 
		{
		    $(".mygallery").chromaGallery();
		});
	</script>
<!-- /js files for gallery -->	
<!-- Back To Top -->
<!-- /Back To Top -->
<script>
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

  // Store hash
  var hash = this.hash;

  // Using jQuery's animate() method to add smooth page scroll
  // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
  $('html, body').animate({
    scrollTop: $(hash).offset().top
  }, 900, function(){

    // Add hash (#) to URL when done scrolling (default click behavior)
    window.location.hash = hash;
    });
  });
})
</script>
<script>
$(window).scroll(function() {
  $(".slideanim").each(function(){
    var pos = $(this).offset().top;

    var winTop = $(window).scrollTop();
    if (pos < winTop + 600) {
      $(this).addClass("slide");
    }
  });
});
jQuery(function($) {
	function ScrollAction(listObj, speed, isSeries) {	//listObj为需要滚动的列表，  speed为滚动速度
		var pos, top, aniTop, height;
		var id = '';  //记录setInterval的标记id
 
		pos = listObj.position();	
		top = pos.top;			//列表的top
		aniTop = top;				//记录当前运动时的top
		height = listObj.height();	//列表的高度
 
		var scrollUp = function() {
			aniTop--;
			if(!isSeries) {	//isSeries变量控制是否连续滚动，false不连续，true连续
				if(aniTop == -height) {	//不连续，滚动玩重新滚动
					listObj.css({'top': top});
					aniTop = top;
				};
			} else {
				if(aniTop == -listObj.children().eq(0).height()) {	//连续滚动
					var firstItem = '<li>' + listObj.children().eq(0).html() + '</li>';
					listObj.children().eq(0).remove();
					listObj.append(firstItem);
					aniTop = 4;
				};
			};
			listObj.css({'top': aniTop + 'px'});
		};
 
		var hover = function(id) {
			listObj.hover(function() {
				clearInterval(id);
			}, function() {
				id = setInterval(scrollUp, speed);
			});
		};
 
		this.start = function() {
			id = setInterval(scrollUp, speed);
			hover(id);
		};
 
	};
	var sa = new ScrollAction($('.noticeList'), 30, true);
	sa.start();
});

$('.speech>p').speech({
	"speech": true, //通过点击链接播报，还是直接播报
	"lang": "zh", //语言			
	"speed": 3, //语速			
	"sWidth": 16, //链接按钮的宽度			
	"sHeight": 16, //链接按钮的高度		
	"https": true, //启用https	
	"bg": "./images/speech.jpg", //链接按钮的背景图片			
});
</script>
<!-- /js files -->
<!-- 弹出未登录alert -->
<c:if test="${msg==1}">
	<script type="text/javascript"> 
	alert("您尚未登录，请登录后查看");
	window.location.replace("login.jsp") ;
	
	</script>
</c:if>
</body>
</html>