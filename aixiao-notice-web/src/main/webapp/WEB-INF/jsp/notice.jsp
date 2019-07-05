<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>aX系统</title>
    <link rel="shortcut icon" type="image/x-icon" href="/images/favicon.ico" />
    <link href="/css/base.css" rel="stylesheet" type="text/css">
    <link href="/css/inner.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/css/thuicon.css">
    <script src="/js/jq.js" type="text/javascript"></script>
    <script src="/js/comm.js" type="text/javascript"></script>
    <!--[if lt IE 9]>
    <script src="/js/html5.js" type="text/javascript"></script>
    <![endif]-->
    <!--[if IE 7]>
    <link rel="stylesheet" href="/css/thuicon-ie7.css">

    <![endif]-->
</head>

<body class="inner">
<header class="header">
    <section class="mainWrap">
        <div class="topLine"></div>
        <section class="topWrap">
            <a class="logo" href="http://localhost:8082/"><img src="/picture/aixiao_logo.png" style="width: 50%;height: 50%;"/></a>
            <section class="search" style="margin-top: 25px;">
                <form id="searchForm" target="_blank">
                    <input name="query" type="text"  class="inp">
                    <input name="ie" type="hidden" value="utf8">
                    <a href="javascript:;"   class="thuicon-search btn"></a><%--onclick="searchSub();"--%>
                </form>
                <script src="/js/searchsub.js"></script>
            </section>
        </section>
        <section class="nav yahei  clearfix">
            <section class="menu" id="smenu"><a class="thuicon-menu menuicon"></a>导航</section>
            <ul id="nav">
                <li><a href="http://localhost:8082/" target="_blank">首页</a></li>
                <li><a href="#" class="">班级活动</a>
                    <ul>
                        <li><a href="#">团日</a></li>
                        <li><a href="#">班会</a></li>
                        <li><a href="#">比赛</a></li>
                        <li><a href="#">日常</a></li>
                    </ul>
                </li>
                <li><a href="http://localhost:8090/index.html?li=1" class="">班级组成</a>
                    <ul>
                        <li><a href="http://localhost:8090/index.html?li=1">班级体系</a></li>
                        <li><a href="http://localhost:8090/index.html?li=2">班级成员</a></li>
                    </ul>
                </li>
                <li><a href="http://localhost:8086/work/index.html?status=1">交作业</a>

                </li>
                <li><a href="#">班级管理</a>
                    <ul>
                        <li><a href="#">考勤</a></li>
                        <li><a href="#">请假</a></li>
                    </ul>
                </li>
                <li><a href="#">通知公告</a>
                    <ul>
                        <li><a href="http://localhost:8089/index.html?categoeyId=117">活动通知</a></li>
                        <li><a href="http://localhost:8089/index.html?categoeyId=1">考试通知</a></li>
                        <li><a href="http://localhost:8089/index.html?categoeyId=1">紧急通知</a></li>
                        <li><a href="#">匿名公告</a></li>
                    </ul>
                </li>
                <li><a href="#" class="">沟通交流</a>
                    <ul>
                        <li><a href="#">班内私信</a></li>
                        <li><a href="#">联系老师</a></li>
                        <li><a href="#">约谈学长</a></li>
                    </ul>
                </li>

                <li><a href="#" class="">走进班级</a>
                    <ul class="last">
                        <li><a href="#">班级目标</a></li>
                        <li><a href="#">班级荣誉</a></li>
                        <li><a href="#">小道消息</a></li>
                    </ul>
                </li>
            </ul>
        </section>
    </section>
</header>
<article class="content">
    <section class="channeltopimg detailtopimg">
        <img src="/picture/intothutop.jpg" class="img1">
    </section>
    <section class="mainWrap relative">
        <div class="detailContent clearfix">
            <div class="column_1">
                <section class="leftNav">
                    <h3 id="submenu"><a class="thuicon-menu menuicon"></a>通知公告</h3>
                    <ul class="yahei">
                        <li><i class="thuicon-plus"></i><a href="#">通知</a>
                            <ul style="display: block;">
                                <li><a href="http://localhost:8089/index.html?categoeyId=117">活动通知</a></li>
                                <li><a href="http://localhost:8089/index.html?categoeyId=1">考试通知</a></li>
                                <li><a href="http://localhost:8089/index.html?categoeyId=1">紧急通知</a></li>
                            </ul>
                        </li>
                        <li><i class="thuicon-plus"></i><a href="#">公告</a>
                            <ul style="display: block;">
                                <li><a href="http://localhost:8089/index.html?categoeyId=1">班级公告</a></li>
                                <li><a href="http://localhost:8089/index.html?categoeyId=1">匿名公告</a></li>
                            </ul>
                        </li>

                    </ul>
                </section>
            </div>
            <div class="column_2">
                <article class="mainContent">

                        <header class="contentNav">
                            <nav class="nav"><a href="http://localhost:8082/">首页</a> &middot; <a href="./index.html">通知</a> &middot; <a href="http://localhost:8086/work/index.html?status=1">活动通知</a></nav>
                            <h1>活动通知</h1>
                        </header>

                        <!--内容图片滚动-->
                        <section class="tPic">
                            <script src="js/slider.js" type="text/javascript"></script>
                            <div id="Bimg">
                                <ul>
                                    <c:forEach items="${List}" var="notice">
                                        <li><img src="${notice.pic}" style="width: 770px;height: 460px"></li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="PicNavWrap clearfix">
                                <a class="thuicon-angle-left left"></a><a class="thuicon-angle-right right"></a>
                                <section><ul class="PicNav" id="PicNav">
                                    <c:forEach items="${List}" var="notice">
                                        <li><img src="${notice.pic}" style="width: 90px;height: 53.76px"></li>
                                    </c:forEach>
                                </ul>
                                </section>
                            </div>
                            <div class="PicIntro">
                                <ul id="PicIntro">
                                    <%--<li style="display:block">
                                        <h3>图书馆</h3>
                                        　　　清华大学图书馆由新馆和老馆两部分组成，整个图书馆的建成共分三期工程进行，时间跨度长达75年。一期工程由美国著名建筑师墨菲设计，1916年4月始建，1919年3月完工，建成的老馆东部是建校初期"四大建筑"中最先动工和建成者，当时的馆舍面积仅有2114平方米。二期工程始于30年代初，因学校发展需要，在有"南杨北梁（梁思成）"之称的著名建筑学家杨廷宝主持下，建成了今老馆之中部和西部，馆舍面积扩建至7700平方米，可容书30万册，阅览座位700余席。三期工程（新馆）开始于九十年代初，由香港邵逸夫先生捐资，关肇业院士设计，1991年9月建成。新馆既保持了同老馆风格上的一致，同时又在许多细节上有所创新，因而获得了1993年"国家优秀工程设计金奖"。至此，清华大学图书馆总建筑面积已经达到2.8万平方米，阅览座位2800余席，馆藏总量已经超过400万册（件），中、外文学术性全文电子期刊逾25000种。
                                        <br><br>

                                        　　有人说：建筑是凝固的音乐。如果把清华园的建筑当成一首曲调优美、旋律高昂的乐曲，图书馆无疑是这首乐曲中最动听的音符之一。无论春夏还是秋冬，无论旭日东升还是红轮西坠，每当你走进清华大学图书馆，扑面而来的是淡淡的书香，映入眼帘的是莘莘学子孜孜以求的身影。这里是知识的海洋，这里是求知的天地，这里是通向彼岸的精神家园，这里是走向辉煌的成功之路……
                                    </li>--%>
                                        <c:forEach items="${List}" var="notice">
                                            <li style="display:block">
                                                <h3>${notice.title}</h3>
                                                　   ${notice.titleDesc}
                                                <br><br>
                                            </li>
                                        </c:forEach>

                                </ul>
                            </div>
                            <script type="text/javascript" src="js/tpicnav.js"></script>
                        </section>
                        <!--内容图片滚动结束-->
                    <!--切换各个作业模块-->

                </article>
            </div>
        </div>
    </section>
</article>
<footer class="footer">
    <section class="footWrap">
        <section class="mainWrap">
            <nav class="footerNav">
                <ul class="clearfix">
                    <li>
                        <h4><a href="/index.html">班级活动</a></h4>
                        <a href="#">团日</a>
                        <a href="#">班会</a>
                        <a href="#">比赛</a>
                        <a href="#">日常</a>
                    </li>
                    <li>
                        <h4><a href="#">班级组成</a></h4>
                        <a href="#">班级体系</a>
                        <a href="#">班级成员</a>

                    </li>
                    <li>
                        <h4><a href="../teacher/index.html">班级管理</a> </h4>
                        <a href="#">考勤</a>
                        <a href="#">请假</a>
                    </li>
                    <li>
                        <h4><a href="../education/index.html">通知公告</a></h4>
                        <a href="#">活动通知</a>
                        <a href="#">考试通知</a>
                        <a href="#">紧急通知</a>
                        <a href="#">匿名公告</a>
                    </li>
                    <li>
                        <h4><a href="../research/index.html">沟通交流</a></h4>
                        <a href="#">班内私信</a>
                        <a href="#">联系老师</a>
                        <a href="#">约谈学长</a>
                    </li>

                    <li>
                        <h4><a href="../intothu/index.html">走进班级</a></h4>
                        <a href="#">班级目标</a>
                        <a href="#">班级荣誉</a>
                        <a href="#">小道消息</a>
                    </li>
                </ul>
            </nav>
        </section>
    </section>
    <section class="copyrights">
        <section class="mainWrap">
            <span class="info"><span>电话：15218230461</span><span>管理员信箱：15218230461@163.com</span><span>地址：广东第二师范学院</span></span>
            <div class="clear"></div>
            <span class="copy">问题反馈 © 丁金斌</span>
        </section>
    </section>
</footer>
</body>
<script type="text/javascript" charset="utf-8" src="/js/jquery-form.js"></script>
<script src="/js/dialog.js" type="text/javascript"></script>
</html>
