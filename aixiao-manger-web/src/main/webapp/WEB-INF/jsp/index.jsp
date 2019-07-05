<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>淘淘商城后台管理系统</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/taotao.css" />
    <link rel="stylesheet" type="text/css" href="css/default.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="js/jquery.ocupload-1.1.2.js"></script>
    <script src="js/jquery.cookie.js" type="text/javascript"></script>

<script type="text/javascript" src="js/common.js"></script>
<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
</style>
</head>
<body class="easyui-layout">
    <!-- 头部标题 -->
    <div data-options="region:'north',border:false" style="height:60px; padding:5px; background: rgb(214, 236, 255);">
        <span  class="northTitle">&nbsp;&nbsp;aX后台管理系统</span>

        <span id="loginbar" class="loginInfo"></span>
    </div>
    <div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
    	<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
            <li>
                <span>用户管理</span>
            <ul>
                    <c:if test="${role ==2}">
                        <li data-options="attributes:{'url':'user-category'}">用户分类管理</li>
                     </c:if>
                    <li data-options="attributes:{'url':'user'}">用户管理</li>
                </ul>
            </li>
         	<li>
         		<span>作业管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'work-add'}">新增作业</li>
	         		<li data-options="attributes:{'url':'item-list'}">查询作业</li>
	         		<li data-options="attributes:{'url':'work-down-list'}">查看/下载作业</li>
	         	</ul>
         	</li>

            <li>
                <span>班级网站内容管理</span>
                <ul>
                    <li data-options="attributes:{'url':'content-category'}">内容分类管理</li>
                    <li data-options="attributes:{'url':'content'}">内容管理</li>
                </ul>
            </li>


            <li>
                <span>网站索引管理</span>
                <ul>
                    <li data-options="attributes:{'url':'indexManager'}">一键导入索引库</li>
                </ul>
            </li>

         </ul>
    </div>
    <div data-options="region:'center',title:''">
    	<div id="tabs" class="easyui-tabs">
		    <div title="首页" style="padding:20px;">

		    </div>
		</div>
    </div>
    
<script type="text/javascript">
$(function(){
	$('#menu').tree({
		onClick: function(node){
			if($('#menu').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				var tab = tabs.tabs("getTab",node.text);
				if(tab){
					tabs.tabs("select",node.text);
				}else{
					tabs.tabs('add',{
					    title:node.text,
					    href: node.attributes.url,
					    closable:true,
					    bodyCls:"content"
					});
				}
			}
		}
	});
    // 查看是否已经登录，如果已经登录查询登录信息
    checkLogin();

});

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
            // <span class="loginInfo">登录用户：username&nbsp;&nbsp;角色：系统管理员</span>
                var html = "登录用户："+username + "，欢迎来到aX！<a href=\"http://localhost:8088/user/logout/"+_ticket+"\" class=\"link-logout\" style=\"display: inline;padding-left:0;padding-right: 10px;color:#698cba\">[退出]</a>";
                $("#loginbar").html(html);
            }
        }
    });
}

</script>
</body>
</html>