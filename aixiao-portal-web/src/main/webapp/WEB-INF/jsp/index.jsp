<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,viewport-fit=cover"/>
    <meta name="format-detection" content="telephone=no" />
    <title>aX~XX班级</title>
    <link rel="shortcut icon" type="image/x-icon" href="/images/ax.svg" />
    <link rel="stylesheet" href="/css/slick.css">
    <link href="/css/index_2019.css" rel="stylesheet" type="text/css">
    <script src="/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/js/slick.min.js"></script>
    <script src="/js/comm.js" type="text/javascript"></script>
    <script src="/js/jquery.cookie.js" type="text/javascript"></script>
<%--    <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>--%>
<%--    <script type="text/javascript" src="/js/jquery-extend.js"></script>--%>
<%--    <script type="text/javascript" src="/js/lib-v1.js" charset="utf-8"></script>--%>
<%--    <script type="text/javascript" src="/js/taotao.js" charset="utf-8"></script>--%>
</head>
<body >
<div class="header" id="header">
    <div class="topline"></div>
    <div class="masklayer"></div>
    <div class="smenu" id="smenu"><i class="icon-menu"></i></div>
    <div class="navwrapper">
        <div class="logowrapper">
            <a href="http://localhost:8082/" class="logo"><img src="/picture/aixiao_logo.png" alt=""></a>
        </div>
        <div class="nav">
            <div class="mainnav clearfix">
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
                    <li><a href="http://localhost:8089/index.html">通知公告</a>
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
                </ul></div>
            <div class="subnav clearfix">
                <ul>
                    <li class="fore1" id="loginbar" clstag="homepage|keycount|home2013|01b">您好！欢迎来到ax！
                        <a href="javascript:login()" style="display: inline;padding-left:0;">[登录]</a>&nbsp;
                        <a href="javascript:regist()" style="display: inline;padding-left:0;;padding-right: 10px;">[注册]</a></li>

                    <li><a href="http://lib.gdei.edu.cn/" target="_blank">图书馆</a></li>
                    <%--target="_blank"  实现打开个新的页面--%>
                    <li class="search" id="search">
                        <form action="#" target="_blank">
                            <input name="query" style="margin-top: -9px;" type="text" class="motion_1">
                            <input name="ie" style="margin-top: -9px;" type="hidden" value="utf8">
                            <button><i class="icon-search"></i></button>
                        </form>
                        <i class="icon-search active"></i></li>
                </ul></div>
        </div> </div>
    <div class="topimg">
        <ul>
            <c:forEach items="${Ad_big}" var="big">
                <li style="background-image: url(${big.pic})">
                    <a href="${big.url}">
                        <h3>${big.title}</h3>
                    </a>
                </li>
            </c:forEach>


        </ul>
    </div>
</div>
<script type="text/javascript">

    function login() {
        return location.href = "http://localhost:8088/page/login";
    }
    function regist() {
        return location.href = "http://localhost:8088/page/register";
    }

      function checkLogin(){
        // var _ticket = $.cookie("TT_TOKEN");
          var _ticket = $.cookie("TT_TOKEN");
        if(!_ticket){
            return ;
        }
        $.ajax({
            url : "http://localhost:8088/user/token/" + _ticket,
            dataType : "jsonp",
            type : "GET",
            success : function(data){
                if(data.status == 200){
                    var username = data.data.username;
                    var html = username + "，欢迎来到aX！<a href=\"http://localhost:8088/user/logout/"+_ticket+"\" class=\"link-logout\" style=\"display: inline;padding-left:0;;padding-right: 10px;\">[退出]</a>";
                    $("#loginbar").html(html);
                }
            }
        });
    }

    $(function(){
        // 查看是否已经登录，如果已经登录查询登录信息
        checkLogin();
    });

    $('.topimg ul').slick({
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        centerMode: false,
        arrows:true,
        fade:true,
        dots:true,
        speed:1000,
        autoplaySpeed:6000,
        prevArrow:"<div class='pre arrow'><i class='icon-angle-left'></i></div>",
        nextArrow:"<div class='next arrow'><i class='icon-angle-right'></i></div>",
        customPaging:function(slider, i) {
            return '<button>0' + (i + 1) +"</button>";
        },
        responsive: [{
            breakpoint: 1000,
            settings: {
                fade:false,
                speed:300
            }
        }]
    });
    var mr=document.createElement("a");
    mr.text="更多消息 >";
    mr.href="#";
    mr.target="_blank";
    mr.className="moreimg";
    $(".topimg .slick-dots").append(mr);
</script>
<div class="content">
    <div class="section_1">
        <div class="cbg"></div>
        <div class="mainWrap">
            <div class="news clearfix">
                <ul>
                    <li  class="fi" ><a href="${Ad_centre.url}" target="_blank"><img src="${Ad_centre.pic}" alt=""><div class="txtwrapper"><div class="time"><i class="icon-clock"></i> ${Ad_centre.updated}</div><p>${Ad_centre.subTitle}</p></div></a></li>
                    <c:forEach items="${Ad_mins}" var="min">

                        <li ><a href="${min.url}" target="_blank"><img src="${min.pic}" alt=""><div class="txtwrapper"><div class="time"><i class="icon-clock"></i> ${min.updated}</div><p>${min.subTitle}</p></div></a></li>
                    </c:forEach>

                </ul>
            </div>
            <div class="events">
                <h2><b></b>通知<b></b></h2>
                <ul class="clearfix">
                    <li><a href="#" target="_blank">
                        <div class="time">
                            <span>24</span>2019.05
                        </div>
                        <div class="txtwrapper">
                            <h3>java第二次实验</h3>
                            <p> java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验</p>
                        </div>
                    </a></li>
                    <li><a href="#" target="_blank">
                        <div class="time">
                            <span>24</span>2019.05
                        </div>
                        <div class="txtwrapper">
                            <h3>java第二次实验</h3>
                            <p> java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验</p>
                        </div>
                    </a></li>
                    <li><a href="#" target="_blank">
                        <div class="time">
                            <span>24</span>2019.05
                        </div>
                        <div class="txtwrapper">
                            <h3>java第二次实验</h3>
                            <p> java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验java第二次实验</p>
                        </div>
                    </a></li>
                </ul>
            </div>
            <a href="#" target="_blank" class="newsmore">往常通知</a>
        </div>
    </div>
    <div class="section_2">
        <div class="mainWrap relative">
            <h2><span>活动海报</span><a href="#" class="more">更多 ></a></h2>
            <div class="focus">
                <div class="bigpic">
                    <ul>
                        <c:forEach items="${Ad_posters}" var="poster">
                            <li>
                                <a href="${poster.url}" target="_blank"><img src="${poster.pic}" alt=""><div class="txtwrapper"><div class="cata">${poster.title}</div><h3>${poster.subTitle}</h3><p> ${poster.titleDesc} </p></div></a>
                            </li>
                        </c:forEach>

                    </ul>
                </div>
                <div class="smallpic">
                    <ul>
                        <c:forEach items="${Ad_posters}" begin="1" var="poster">
                            <li>
                                <a href="${poster.url}" target="_blank"><img src="${poster.pic}" alt=""><div class="txtwrapper"><div class="cata">${poster.title}</div><h3>${poster.subTitle}</h3><p> ${poster.titleDesc} </p></div></a>
                            </li>
                        </c:forEach>
                        <c:forEach items="${Ad_posters}" end="0" var="poster">
                            <li>
                                <a href="${poster.url}" target="_blank"><img src="${poster.pic}" alt=""><div class="txtwrapper"><div class="cata">${poster.title}</div><h3>${poster.subTitle}</h3><p> ${poster.titleDesc} </p></div></a>
                            </li>
                        </c:forEach>


                    </ul>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $('.smallpic ul').slick({
            infinite: true,
            slidesToShow: 1,
            slidesToScroll: 1,
            autoplay: true,
            centerMode: false,
            arrows:false,
            dots:false,
            asNavFor:$('.bigpic ul')
        });
        $('.bigpic ul').slick({
            infinite: true,
            slidesToShow: 1,
            slidesToScroll: 1,
            autoplay: true,
            centerMode: false,
            arrows:false,
            dots:true,
            autoplaySpeed:4000,
            prevArrow:"<div class='pre arrow'><i class='icon-angle-left'></i></div>",
            nextArrow:"<div class='next arrow'><i class='icon-angle-right'></i></div>",
            asNavFor:$('.smallpic ul')
        });

    </script>


</div>
<div class="footer">
    <div class="mainWrap">
        <div class="ulink clearfix" style="padding-top: 100px;padding-bottom: 50px;">
            <ul class="plink">
<%--                <li><a href="#" target="_blank"><img src="picture/logo.png" alt=""></a></li>--%>

            </ul>
            <div class="tlink">
                <div class="txtwrapper clearfix">
                    <h2>推荐链接</h2>
                    <ul>
                        <li><a href="http://www.gdei.edu.cn/">校园首页</a></li>
                        <li><a href="#" target="_blank">校园地图</a></li>
                        <li><a href="https://www.imooc.com/" target="_blank">慕课网</a></li>
                        <li><a href="#" target="_blank">校园公告</a></li>
                        <li><a href="#" target="_blank">实用信息</a></li>
                        <li><a href="#" target="_blank">校友总会</a></li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
    <div class="copy" style="padding: 0 0 30px 0;">
        <div class="mainWrap">

            <div class="contact">

            </div>

            <div class="copyrights">
                问题反馈 © 丁金斌<span>tel:15218230461</span>
            </div>
        </div>
    </div>

</div></body>
</html>