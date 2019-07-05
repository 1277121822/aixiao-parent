<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="contentAddForm" class="itemForm" method="post">
        <input type="hidden" name="classesId" style="width: 280px;"/><%--存放的是被选中的内容的id--%>
        <table cellpadding="5">

            <tr>
                <td>学号:</td>
                <td><input class="easyui-textbox" name="sno" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input class="easyui-textbox" type="text" name="username" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>宿舍号:</td>
                <td><input class="easyui-textbox" type="text" name="hostelNo" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><select  class="easyui-combobox" name="sex" data-options="required:true" style="width: 280px;">
                    <option value="1">男</option>
                    <option value="2">女</option>
                </select ></td>
            </tr>
            <tr>
                <td>出生日期:</td>
                <td><input class="easyui-datebox" type="date" name="birthday" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>手机号码:</td>
                <td><input class="easyui-textbox" type="tel" name="phone" data-options="required:false" style="width: 280px;" placeholder="请在这里输入电话号码"></input></td>
            </tr>

            <tr>
                <td>邮箱:</td>
                <td><input class="easyui-textbox" type="email" name="email" data-options="required:false" style="width: 280px;"  placeholder="请在这里输入邮箱"></input></td>
            </tr>

            <tr class="params hide">

            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentAddPage.submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentAddPage.clearForm()">重置</a>
    </div>
</div>
<script type="text/javascript">
    var contentAddEditor ;
    $(function(){
        //初始化富文本编辑器 放到content 这个textarea 中
        // contentAddEditor = TT.createEditor("#contentAddForm [name=content]");
        TT.initOnePicUpload();
        //$("#contentCategoryTree").tree("getSelected")  是被选中的树的节点  的id 值设置到隐藏域中
        $("#contentAddForm [name=classesId]").val($("#contentCategoryTree").tree("getSelected").id);
    });

    var contentAddPage  = {
        submitForm : function (){
            if(!$('#contentAddForm').form('validate')){
                $.messager.alert('提示','表单还未填写完成!');
                return ;
            }

            // alert($("#contentAddForm").serialize());
            $.post("/user/save",$("#contentAddForm").serialize(), function(data){

                if(data.status == 200){
                    $.messager.alert('提示','新增用户成功!');
                    //重新加载表格中的内容列表数据
                    $("#contentList").datagrid("reload");
                    //关闭窗口
                    TT.closeCurrentWindow();
                }
            });
        },
        clearForm : function(){
            $('#contentAddForm').form('reset');
            contentAddEditor.html('');
        }
    };
</script>
