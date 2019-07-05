<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="utf-8" src="js/jquery-easyui-1.4.1/jquery-form.js"></script>
<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false" style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false" style="width:250px;padding:5px">
            <ul id="contentCategoryTree" class="easyui-tree" data-options="url:'/user/category/list',animate: true,method : 'GET'">
            </ul>
        </div>
        <div data-options="region:'center'" style="padding:5px">
            <table class="easyui-datagrid" id="contentList" data-options="toolbar:contentListToolbar,rownumbers:true,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:20,url:'/user/query/list',queryParams:{categoryId:0}">
		    <thead>
		        <tr>
                    <th data-options="field:'ck',checkbox:true"></th>
                    <th data-options="field:'id',width:100,hidden:'true'"></th>
		            <th data-options="field:'sno',width:100">学号</th>
		            <th data-options="field:'username',width:70">姓名</th>
		            <th data-options="field:'sex',width:30,formatter:formatSex">性别</th>
		            <th data-options="field:'phone',width:120">电话</th>
		            <th data-options="field:'hostelNo',width:80,align:'center'">宿舍号</th>
		            <th data-options="field:'birthday',width:100,align:'center',formatter:TAOTAO.formatDateTime">出生日期</th>
		            <th data-options="field:'created',width:130,align:'center',formatter:TT.formatDateTime">创建日期</th>
		            <th data-options="field:'updated',width:130,align:'center',formatter:TT.formatDateTime">更新日期</th>
                    <th data-options="field:'roleName',width:150,align:'center',formatter:formatRole">角色</th>

                </tr>
		    </thead>
		</table>
        </div>
    </div>
    <form action="/file/imput" method="post" id="submitFile" enctype="multipart/form-data">   <!-action为后台给的接口路径->
        <input id="categoryId" name="categoryId" type="hidden" value=""/>
         <input type="file" id="file-input" name="uploadFile" style="visibility: hidden;display: inline-block;width:2px;position: fixed;left: -1000px;" accept=".xls"/>

    </form>
</div>
<script type="text/javascript">

    function formatSex (val,row){
        if (val == "1"){
            return '男';
        } else if(val == "2"){
            return '女';
        } else {
            return '不详';
        }
    }

    // 格式化作业收取类型
    function formatRole(val,row){
        if (val == null){
            return '普通用户';
        }  else {
            return '<span style="color:#2a20ff">'+val+'</span >';
        }
    }

//文档加载时处理以下的逻辑
$(function(){
	var tree = $("#contentCategoryTree");//获取树
	var datagrid = $("#contentList");//获取表格
	tree.tree({//创建一颗树
		//url:'/content/category/list
		//点击树的节点的时候触发
		onClick : function(node){
			//判断如果点击的节点是叶子节点
			if(tree.tree("isLeaf",node.target)){
				//加载表格中的数据  重新发送URL请求 加载数据
				datagrid.datagrid('reload', {
					//发送请求的参数：categoryId :分类的id
					categoryId :node.id
		        });
			}

            $("#categoryId").val(node.id);
		}
	});



});
var contentListToolbar = [{
    text:'新增',
    iconCls:'icon-add',
    //处理点击事件时触发
    handler:function(){
    	//表示获取树中被选中的节点
    	var node = $("#contentCategoryTree").tree("getSelected");
    	//if(node)  表示有节点
    	//$("#contentCategoryTree").tree("isLeaf",node.target)：获取节点，判断是否为叶子节点  表示是叶子
    	//如果没有选择节点或者选择的节点为父节点。
    	if(!node || !$("#contentCategoryTree").tree("isLeaf",node.target)){
    		$.messager.alert('提示','新增内容必须选择一个内容分类!');
    		return ;
    	}
    	//表示选中的是叶子节点，处理以下的业务
    	//创建窗口
    	TT.createWindow({
    		//动态的发送url /content-add  获取JSP页面，展示在窗口中
			url : "/user-add?classesId="+node
		}); 
    }
},{
    text:'编辑',
    iconCls:'icon-edit',
    handler:function(){
    	var ids = TT.getSelectionsIds("#contentList");
    	if(ids.length == 0){
    		$.messager.alert('提示','必须选择一个内容才能编辑!');
    		return ;
    	}
    	if(ids.indexOf(',') > 0){
    		$.messager.alert('提示','只能选择一个内容!');
    		return ;
    	}
		TT.createWindow({
			url : "/user-add",
			onLoad : function(){
				var data = $("#contentList").datagrid("getSelections")[0];
				$("#contentEditForm").form("load",data);
				
				// 实现图片
				if(data.pic){
					$("#contentEditForm [name=pic]").after("<a href='"+data.pic+"' target='_blank'><img src='"+data.pic+"' width='80' height='50'/></a>");	
				}
				if(data.pic2){
					$("#contentEditForm [name=pic2]").after("<a href='"+data.pic2+"' target='_blank'><img src='"+data.pic2+"' width='80' height='50'/></a>");					
				}
				
				contentEditEditor.html(data.content);
			}
		});    	
    }
},{
    text:'删除',
    iconCls:'icon-cancel',
    handler:function(){
    	//获取被选中的内容的id的集合
    	var ids = TT.getSelectionsIds("#contentList");
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中用户!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的内容吗？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("/user/delete",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除内容成功!',undefined,function(){
        					$("#contentList").datagrid("reload");
        				});
        			}
        		});
    	    }
    	});
    }
},{
    //id:'button-import',
    text:'导入',
    iconCls:'icon-redo',
    handler:function(){
        $('#file-input').click();
        $('#file-input').change(function(){
            $('#submitFile').ajaxSubmit({
                type:'post',
                dataType:'json',
                success:function(result){
                    if(result.status == 200){
                        //请求成功后后台会返回一个URL 地址，该地址是你最后保存时需要提交给后台的。
                        //fileUrl=result.url;
                        $('#file-input').val('');
                        $.messager.alert('提示','导入内容成功!',undefined,function(){
                            $("#contentList").datagrid('reload', {
                                //发送请求的参数：categoryId :分类的id
                                categoryId :result.data
                            });
                        });

                    }
                },
                error:function(){
                    //并且清空原文件，不然选择相同文件不能再次传 
                    $('#file-input').val('');
                }
            });
        });

    }
},{
    //id:'button-import',
    text:'角色',
    iconCls:'icon-reload',
    handler:function(){
        //获取被选中的内容的id的集合
        var ids = TT.getSelectionsIds("#contentList");
        var names = getSelectionsStudentNames();
        var roles = getSelectionsRoles();
        if(ids.length == 0){
            $.messager.alert('提示','未选中用户!');
            return ;
        }
        $.messager.confirm('确认','确定改变ID为 '+names+' 的角色吗？',function(r){
            if (r){
                var params = {"ids":ids};
                $.post("/user/reload",params, function(data){
                    if(data.status == 200){
                        $.messager.alert('提示',data.data,undefined,function(){
                            $("#contentList").datagrid("reload");
                        });
                    }
                });
            }
        });

    }
}];

    function getSelectionsStudentNames(){
        var List = $("#contentList");
        var sels = List.datagrid("getSelections");
        var studentNames = [];
        for(var i in sels){
            studentNames.push(sels[i].username);
        }
        studentNames = studentNames.join(",");
        return studentNames;
    }

    function getSelectionsRoles(){
        var List = $("#contentList");
        var sels = List.datagrid("getSelections");
        var roles = [];
        for(var i in sels){
            roles.push(sels[i].roleName);
        }
        roles = roles.join(",");
        return roles;
    }

</script>
