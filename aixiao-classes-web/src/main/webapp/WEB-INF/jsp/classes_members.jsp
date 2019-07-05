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
                    <h3 id="submenu"><a class="thuicon-menu menuicon"></a>班级</h3>
                    <ul class="yahei">
                        <li><i class="thuicon-plus"></i><a href="#">班级组成</a>
                            <ul style="display: block;">
                                <li><a href="http://localhost:8090?li=1">班级体系</a></li>
                                <li><a href="http://localhost:8090?li=2">班级成员</a></li>
                            </ul>
                        </li>


                    </ul>
                </section>
            </div>
            <div class="column_2">
                <article class="mainContent">
                        <c:if test="${li==1}">
                            <header class="contentNav">
                                <nav class="nav"><a href="http://localhost:8082/">首页</a> &middot; <a href="./index.html">班级组成</a> &middot; <a href="http://localhost:8090/index.html?li=1">班级体系</a></nav>
                                <h1>班级体系</h1>
                            </header>

                            <section class="article fullwidth">
                                <!--内容-->
                                <div align="center">
                                    <img src="/picture/classes.PNG" style="width: 798px">
                                </div>
                            </section>
                        </c:if>
                    <c:if test="${li==2}">
                        <header class="contentNav">
                            <nav class="nav"><a href="http://localhost:8082/">首页</a> &middot; <a href="/index.html">班级组成</a> &middot; <a href="http://localhost:8090/index.html?li=2">班级成员</a></nav>
                            <h1>班级成员</h1>
                        </header>

                        <c:if test="${userList == null}">
                            <section class="article fullwidth">
                                <h3 class="hhh">您还未登录，请<a href="http://localhost:8088/page/login?redireect=http://localhost:8090/index.html?li=2">登录</a></h3>
                            <section>
                        </c:if>
                        <c:if test="${userList != null}">
                            <c:forEach items="${userList}" var="user" varStatus="index">
                            <section class="article fullwidth">
                                <table cellspacing="0" cellpadding="0" class="liren">
                                <c:if test="${index.index%2 ==0}">
                                    <tr bgcolor="#F7F7F7" >

                                        <td class="tdline nr tdborder" width="15%">${index.index+1}.</td>

                                        <td class="tdline tdborder" width="20%"><a href="#">${user.sno}</a></td>

                                        <td width="15%" class="nr tdborder">姓名</td>

                                        <td class="tdline tdborder"><a href="#" class="_plugbox">${user.username}</a></td>
                                        <td class="tdline tdborder"></td>
                                    </tr>
                                </c:if>
                                    <c:if test="${index.index%2 ==1}">
                                        <tr class="tdline nr">

                                            <td class="tdline nr tdborder" width="15%">${index.index+1}.</td>

                                            <td class="tdline tdborder" width="20%"><a href="#" class="_plugbox">${user.sno}</a></td>

                                            <td width="15%" class="nr tdborder">姓名</td>

                                            <td class="tdline tdborder"><a href="#" class="_plugbox">${user.username}</a></td>
                                            <td class="tdline tdborder"></td>


                                        </tr>
                                    </c:if>




                            </table>
                            <section>
                                </c:forEach>
                          </c:if>

                    </c:if>


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
