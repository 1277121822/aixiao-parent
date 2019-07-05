<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
    <title> Login </title>
    <link href="/css/bootstrap_1.css" rel="stylesheet">
    <link href="/css/bootstrap-responsive_1.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
    <style type="text/css">
        body,a,p,input,button{font-family:Arial,Verdana,"Microsoft YaHei",Georgia,Sans-serif}
        body{
            background-size: cover;
        }
        .blank-area{
            height:100px;
        }
        .form-signin {
            max-width: 1000px;
            padding: 19px 29px 29px;
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
    </style>
</head>
<body  background="/images/p1_1.jpg" >

<div class="blank-area">
</div>

<div class="container form-signin">
    <div class="row-fluid">
        <h3 class="form-signin-heading text-warning " style="display: inline"><strong>登录aX~</strong>

        </h3>
        <a href="http://localhost:8082/" style="display: inline;padding: 0 20px;">[回首页]</a>
        <form id="loginform" method="post" onsubmit="return false;">
            <input type='hidden' name='csrfmiddlewaretoken' value='o8MXBEeBvicPdzt1FTgmvsVc7UCJdRqg' />
            <div  class="field">
                <label><font color="#FFFFFF">学号 :</font></label>
                <input id="id_student_id" name="sno" type="text" />
            </div>
            <div  class="field">
                <label><font color="#FFFFFF">密码 :</font></label>
                <input id="id_password" name="password" type="password" />
            </div>

            <div id="codeInputLine" class="field">
                <label><font color="#FFFFFF">验证码：</font></label>
                <input id="loginform:codeInput" class="loginFormTdIpt" type="text"
                       name="checkcode" title="请输入验证码" style="width: 120px;"/>
                <img id="loginform:vCode" src="http://localhost:8088/page/validatecode" style="margin-bottom:15px;"
                     onclick="javascript:document.getElementById('loginform:vCode').src='http://localhost:8088/page/validatecode?'+Math.random();" />
            </div>
            <%--管理员还是用户登录--%>
            <div style="display: block;color: rgba(253,244,244,1);">
                <label class="radio-inline" style="display: inline;">
                    <input type="radio"  name="code" id="inlineRadio1" value="admin"> 管理员
                </label>
                <label class="radio-inline" style="display: inline;margin-left: 50px;">
                    <input type="radio"  name="code" id="inlineRadio2" value="consumer"> 用户
                </label>
            </div>

            <input type="button" style="display: inline;margin-top: 10px;margin-right: 20px" class="btn btn-success" id="loginsubmit" value="登录">
            <input type="button" style="display: inline;margin-top: 10px;" class="btn btn-info"  value="注册">
        </form>



    </div>
</div>
</div>
</div>
<div class="blank-area">
</div>
<hr>
<script type="text/javascript">

    var redirectUrl = "${redirect}";
    var LOGIN = {
        checkInput:function() {
            if ($("#id_student_id").val() == "") {
                alert("学号不能为空");
                $("#id_student_id").focus();
                return false;
            }
            if ($("#id_password").val() == "") {
                alert("密码不能为空");
                $("#id_password").focus();
                return false;
            }
            return true;
        },
        doLogin:function() {
            $.post("/user/login", $("#loginform").serialize(),function(data){
                if (data.status == 200) {
                    alert("登录成功！");
                    if (redirectUrl == "") {
                        location.href = data.msg;
                    } else {
                        location.href = redirectUrl;
                    }
                } else if (data.status == 201){
                    alert("班级管理员，登录成功！");
                    if (redirectUrl == "") {
                        location.href = data.msg;
                    } else {
                        location.href = redirectUrl;
                    }
                }else if (data.status == 202){
                    alert("超级管理员，登录成功！");
                    if (redirectUrl == "") {
                        location.href = data.msg;
                    } else {
                        location.href = redirectUrl;
                    }
                } else {
                    alert("登录失败，原因是：" + data.msg);
                    $("#id_student_id").select();
                }
            });
        },
        login:function() {
            if (this.checkInput()) {
                this.doLogin();
            }
        }

    };
    $(function(){
        $("#loginsubmit").click(function(){
            LOGIN.login();
        });
    });


</script>
</body>
</html>
