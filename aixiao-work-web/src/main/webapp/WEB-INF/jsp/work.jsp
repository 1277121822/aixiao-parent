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
                <li><a href="http://localhost:8089/index.html?categoeyId=117">通知公告</a>
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
                    <h3 id="submenu"><a class="thuicon-menu menuicon"></a>作业管理</h3>
                    <ul class="yahei">
                        <li><i class="thuicon-plus"></i><a href="#">作业</a>
                            <ul style="display: block;">
                                <li><a href="http://localhost:8086/work/index.html?status=1">未交作业</a></li>
                                <li><a href="http://localhost:8086/work/index.html?status=2">已交作业</a></li>
                                <li><a href="#">作业反馈</a></li>
                            </ul>
                        </li>

                    </ul>
                </section>
            </div>
            <div class="column_2">
                <article class="mainContent">
                    <!--切换各个作业模块-->
                    <%--                    <jsp:include page="work-commit.jsp" />--%>
                    <c:if test="${status ==1}">
                        <header class="contentNav">
                            <nav class="nav"><a href="/">首页</a> &middot; <a href="./index.html">作业管理</a> &middot; <a href="http://localhost:8086/work/index.html?status=1">未交作业</a></nav>
                            <h1>未交作业</h1>
                        </header>

                    <section class="article fullwidth">
                        <h3 class="hhh">${user.username}</h3>

                            <c:forEach items="${workItemInfoList}" var="workItem" varStatus="index">

                        <form id="workForm${index.index+1}" method="post">
                            <input type="hidden" value="${workItem.id}" name="id"/>
                            <input type="hidden" value="${workItem.workId}" name="workId"/>
                            <input type="hidden" value="${user.id}" name="studentId"/>

                            <table cellspacing="0" cellpadding="0" class="liren">
                            <tr bgcolor="#F7F7F7">

                                    <td class="tdline nr tdborder" width="15%">${index.index+1}.</td>

                                    <td class="tdline tdborder"><a href="#" class="_plugbox" boxid="${index.index+1}">${workItem.workName}</a></td>

                                    <td width="15%" class="nr tdborder">截止时间</td>

                                    <td class="tdline tdborder"><a href="#" class="_plugbox" >${workItem.time}</a></td>
                                    <td class="tdline tdborder"></td>
                                </tr>

                                <tr class="tdline nr">

                                    <td class="tdline nr tdborder" width="15%">参考文件</td>

                                    <td class="tdline tdborder"><a href="${workItem.referenceFilePath}?filename=${workItem.referenceFileName}" class="_plugbox">${workItem.referenceFileName}</a></td>

                                    <td width="15%" class="nr tdborder">交作业</td>

                                    <td class="tdline tdborder"><%--<a href="#" class="_plugbox" boxid="5"></a>--%>
                                        <input id="file_name${index.index+1}" type="text" class="enclosure-text" name="workFileName"/>
                                        <input id="file_path${index.index+1}" type="hidden"  name="workFilePath" value=""/>

                                        <a href="javascript:void(0)" onclick="$('#file-input${index.index+1}').click()" class="easyui-linkbutton">上传作业</a>
                                        <div class="comment-right-float">

                                        </div>

                                    </td>
                                    <td class="tdline tdborder">
                                        <input type="button" onclick="submitForm()" value="确定提交"/>

                                    </td>

                                </tr>
                            </table>
                        </form>

                        <form action="/file/upload" method="post" id="submitFile${index.index+1}" enctype="multipart/form-data">   <!-action为后台给的接口路径->
                            <input type="file" id="file-input${index.index+1}" name="uploadFile" style="visibility: hidden;display: inline-block;width:2px;position: fixed;left: -1000px;" accept=".doc,.pdf,.docx,.zip,.rar"/>

                        </form>
                        <script type="text/javascript">

                            //提交表单
                            function submitForm(){
                                //有效性验证
                                /*   if(!$('#workForm${index.index+1}').form('validate')){
                                    $.messager.alert('提示','表单还未填写完成!');
                                    return ;
                                }*/

                                $.post("/work/commit",$("#workForm${index.index+1}").serialize(), function(data){
                                    if(data.status == 200){
                                        $alert('提示','提交作业成功!');
                                        location.href="/work/index.html?status=1";
                                    }
                                });
                            }

                            var fileUrl;  //需要的url，在保存时后台需要这个地址
                            var saveFileName;  //上传完成后截取的文件名
                            var uploadFile = document.getElementById('file-input${index.index+1}').files[0];
                            $('#file-input${index.index+1}').change(function(){
                                //判断文件名是否为空，不为空时截取文件的名
                                if($(this).val() == ''){
                                    return false;
                                }else{
                                    saveFileName=$(this).val().slice(12);
                                    $("#file_name${index.index+1}").val(saveFileName);

                                }

                                $('#submitFile${index.index+1}').ajaxSubmit({
                                    type:'post',
                                    dataType:'json',
                                    success:function(result){
                                        if(result.error == 0){
                                            //请求成功后后台会返回一个URL 地址，该地址是你最后保存时需要提交给后台的。
                                            fileUrl=result.url;
                                            // alert(fileUrl);
                                            $("#file_path${index.index+1}").val(fileUrl);
                                            //并且清空原文件，不然选择相同文件不能再次传 
                                            //$('#file-input').val(''); 
                                        }
                                    },
                                    error:function(){
                                        //并且清空原文件，不然选择相同文件不能再次传 
                                        $('#file-input${index.index+1}').val('');
                                    }
                                });
                            })
                        </script>
                                <div class="_plugLayer ulayer" boxid="${index.index+1}">

                                    <a class="close thuicon-cancel"></a>

                                    <div class="layerbox clearfix">

                                        <span class="imgwrap"><img src="/picture/work.png" width="98"></span>

                                        <div class="leftarea">

                                            <div class="innerarea">

                                                <h3 class="uname">${workItem.workName}<span class="r">截止时间：${workItem.time}</span>

                                                </h3>

                                                <p>作业详情：</p>

                                                <p>${workItem.workDesc}</p>

                                                <p>作业反馈：</p>
                                                <p>${workItem.studentMessage}</p>

                                            </div>

                                        </div>

                                    </div>

                                </div>
                            </c:forEach>
                    </section>

                    </c:if>
                    <c:if test="${status ==2}">
                        <header class="contentNav">
                            <nav class="nav"><a href="/">首页</a> &middot; <a href="./index.html">作业管理</a> &middot; <a href="intothu-2.html">已交作业</a></nav>
                            <h1>已交作业</h1>
                        </header>

                        <section class="article fullwidth">
                            <h3 class="hhh">${user.username}</h3>

                            <c:forEach items="${workItemInfoList}" var="workItem" varStatus="index">

                                <form id="workForm${index.index+1}" method="post">
                                    <input type="hidden" value="${workItem.id}" name="id"/>
                                    <input type="hidden" value="${workItem.workId}" name="workId"/>
                                    <input type="hidden" value="${user.id}" name="studentId"/>

                                    <table cellspacing="0" cellpadding="0" class="liren">
                                        <tr bgcolor="#F7F7F7" >

                                            <td class="tdline nr tdborder" width="15%">${index.index+1}.</td>

                                            <td class="tdline tdborder" width="20%"><a href="#" class="_plugbox" boxid="${index.index+1}">${workItem.workName}</a></td>

                                            <td width="15%" class="nr tdborder">上次提交时间</td>

                                            <td class="tdline tdborder"><a href="#" class="_plugbox">${workItem.commitT}</a></td>
                                            <td class="tdline tdborder"></td>
                                        </tr>

                                        <tr class="tdline nr">

                                            <td class="tdline nr tdborder" width="15%">参考文件</td>

                                            <td class="tdline tdborder"><a href="${workItem.referenceFilePath}?filename=${workItem.referenceFileName}" class="_plugbox">${workItem.referenceFileName}</a></td>

                                            <td width="15%" class="nr tdborder">已交作业</td>

                                            <td class="tdline tdborder"><%--<a href="#" class="_plugbox" boxid="5"></a>--%>
                                                <input id="file_name${index.index+1}" value="${workItem.workFileName}" type="text" class="enclosure-text" name="workFileName"/>
                                                <input id="file_path${index.index+1}" type="hidden"  name="workFilePath" value=""/>

                                                <a href="javascript:void(0)" onclick="$('#file-input${index.index+1}').click()" style="padding-left: 10px;"  class="easyui-linkbutton">重新上传</a>
                                                <div class="comment-right-float">

                                                </div>

                                            </td>
                                            <td class="tdline tdborder">
                                                <input type="button" onclick="submitForm()" style="background-color: #0d6fc4;color: #ffffff;padding-right: 20px;" value="确定提交"/>

                                            </td>

                                        </tr>
                                    </table>
                                </form>

                                <form action="/file/upload" method="post" id="submitFile${index.index+1}" enctype="multipart/form-data">   <!-action为后台给的接口路径->
                                    <input type="file" id="file-input${index.index+1}" name="uploadFile" style="visibility: hidden;display: inline-block;width:2px;position: fixed;left: -1000px;" accept=".doc,.pdf,.docx,.zip,.rar"/>

                                </form>
                                <script type="text/javascript">

                                    //提交表单
                                    function submitForm(){
                                        //有效性验证
                                        /*   if(!$('#workForm${index.index+1}').form('validate')){
                                    $.messager.alert('提示','表单还未填写完成!');
                                    return ;
                                }*/

                                        $.post("/work/commit",$("#workForm${index.index+1}").serialize(), function(data){
                                            if(data.status == 200){
                                                alert("提交作业成功!");
                                                location.href="/work/index.html?status=2";
                                            }else {
                                                alert(data.msg);
                                            }
                                        });
                                    }

                                    var fileUrl;  //需要的url，在保存时后台需要这个地址
                                    var saveFileName;  //上传完成后截取的文件名
                                    var uploadFile = document.getElementById('file-input${index.index+1}').files[0];
                                    $('#file-input${index.index+1}').change(function(){
                                        //判断文件名是否为空，不为空时截取文件的名
                                        if($(this).val() == ''){
                                            return false;
                                        }else{
                                            saveFileName=$(this).val().slice(12);
                                            $("#file_name${index.index+1}").val(saveFileName);

                                        }

                                        $('#submitFile${index.index+1}').ajaxSubmit({
                                            type:'post',
                                            dataType:'json',
                                            success:function(result){
                                                if(result.error == 0){
                                                    //请求成功后后台会返回一个URL 地址，该地址是你最后保存时需要提交给后台的。
                                                    fileUrl=result.url;
                                                    // alert(fileUrl);
                                                    $("#file_path${index.index+1}").val(fileUrl);
                                                    //并且清空原文件，不然选择相同文件不能再次传 
                                                    //$('#file-input').val(''); 
                                                }
                                            },
                                            error:function(){
                                                //并且清空原文件，不然选择相同文件不能再次传 
                                                $('#file-input${index.index+1}').val('');
                                            }
                                        });
                                    })
                                </script>
                                <div class="_plugLayer ulayer" boxid="${index.index+1}">

                                    <a class="close thuicon-cancel"></a>

                                    <div class="layerbox clearfix">

                                        <span class="imgwrap"><img src="/picture/work.png" width="98"></span>

                                        <div class="leftarea">

                                            <div class="innerarea">

                                                <h3 class="uname">${workItem.workName}<span class="r">截止时间：${workItem.time}</span>

                                                </h3>

                                                <p>作业详情：</p>

                                                <p>${workItem.workDesc}</p>

                                                <p>作业反馈：</p>
                                                <p>${workItem.studentMessage}</p>

                                            </div>

                                        </div>

                                    </div>

                                </div>
                            </c:forEach>
                        </section>

                    </c:if>
                    <c:if test="${status == null}">
                        <header class="contentNav">
                            <nav class="nav"><a href="/">首页</a> &middot; <a href="./index.html">作业管理</a> &middot; <a href="#">作业</a></nav>
                            <h1>点击左侧按钮查看作业吧</h1>
                        </header>

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
