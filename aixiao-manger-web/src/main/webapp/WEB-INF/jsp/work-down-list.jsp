<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:300,noheader:true,border:false" style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false" style="width:250px;padding:5px">
            <ul id="contentCategoryTree" class="easyui-tree" data-options="url:'/user/category/list',animate: true,method : 'GET'">
            </ul>
        </div>
        <div data-options="region:'center'" style="padding:5px">
            <table class="easyui-datagrid" id="contentList" data-options="toolbar:contentListToolbar,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:20,url:'/work/list',queryParams:{classesId:0}">
		    <thead>
            <tr>
                <th data-options="field:'workId',width:100,hidden:'true'"></th>
                <th data-options="field:'workName',width:100">作业名称</th>
                <th data-options="field:'collectType',width:100,formatter:formatWorkType">收取类型</th>
                <th data-options="field:'status',width:100,formatter:formatWorkStatus">状态</th>
                <th data-options="field:'createTime',width:100,formatter:formatDateTime">创建时间</th>
                <th data-options="field:'closeTime',width:70,align:'right',formatter:formatDateTime">截止时间</th>
                <th data-options="field:'classesId',width:70,align:'right'">所属班级</th>
                <th data-options="field:'cid',width:100">科目</th>
                <th data-options="field:'workDesc',width:60,align:'center'">详情</th>
                <th data-options="field:'referenceFileName',width:130,align:'center'">参考文件</th>
                <th data-options="field:'referenceFilePath',width:130,align:'center',formatter:formatReferenceDownButton">下载参考文件</th>
            </tr>
		    </thead>
		</table>
        </div>
    </div>
</div>

<!-- 下载作业管理 -->
<div id="downWork" class="easyui-tabs" data-options="width:'100%',minHeight:500,noheader:true,border:false">

    <div title="未下载" data-options="iconCls:'icon-reload'" style="padding:20px;">
        <table class="easyui-datagrid" id="noDownList" data-options="toolbar:contentListToolbar,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:20,url:'/workItem/list',queryParams:{status:2,workId:''}">
            <thead>
            <tr>
                <th data-options="field:'ck',checkbox:true"></th>
                <th data-options="field:'id',width:100,hidden:'true'"></th>
                <th data-options="field:'studentId',width:100,hidden:'true'"></th>
                <th data-options="field:'sno',width:100">学号</th>
                <th data-options="field:'username',width:100,align:'center'">姓名</th>
                <th data-options="field:'createTime',width:120,formatter:formatDateTime">创建时间</th>
                <th data-options="field:'updateTime',width:120,align:'right',formatter:formatDateTime">提交时间</th>
                <th data-options="field:'workFileName',width:120,align:'center'">作业名称</th>
                <th data-options="field:'workFilePath',width:130,align:'center',formatter:formatDownButton">下载作业</th>
            </tr>
            </thead>
        </table>
    </div>

    <div title="已下载" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:20px;">
        <table class="easyui-datagrid" id="downedList" data-options="toolbar:contentListToolbar,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:20,url:'/workItem/list',queryParams:{status:3,workId:''}">
            <thead>
            <tr>
                <th data-options="field:'id',width:100,hidden:'true'"></th>
                <th data-options="field:'sno',width:100">学号</th>
                <th data-options="field:'studentId',width:100,hidden:'true'"></th>
                <th data-options="field:'username',width:100,align:'center'">姓名</th>
                <th data-options="field:'createTime',width:120,formatter:formatDateTime">创建时间</th>
                <th data-options="field:'updateTime',width:120,align:'right',formatter:formatDateTime">提交时间</th>
                <th data-options="field:'workFileName',width:120,align:'center'">作业名称</th>
                <th data-options="field:'workFilePath',width:130,align:'center',formatter:formatDownButton">下载作业</th>
            </tr>
            </thead>
        </table>
    </div>

    <div title="未提交" data-options="iconCls:'icon-tip'" style="padding:20px;">
        <table class="easyui-datagrid" id="notSubimtList" data-options="toolbar:contentListToolbar,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:20,url:'/workItem/list',queryParams:{status:1,workId:''}">
            <thead>
            <tr>
                <th data-options="field:'ck',checkbox:true"></th>
                <th data-options="field:'id',width:100,hidden:'true'"></th>
                <th data-options="field:'studentId',width:100,hidden:'true'"></th>
                <th data-options="field:'sno',width:100">学号</th>
                <th data-options="field:'username',width:100,align:'center'">姓名</th>
                <th data-options="field:'createTime',width:120,formatter:formatDateTime">创建时间</th>
                <th data-options="field:'updateTime',width:120,align:'right',formatter:formatDateTime">提交时间</th>
                <th data-options="field:'workFileName',width:120,align:'center'">作业名称</th>
                <th data-options="field:'workFilePath',width:130,align:'center',formatter:formatDownButton">下载作业</th>
            </tr>
            </thead>
        </table>
    </div>

</div>


<script type="text/javascript">

    //日期格式
    function formatDateTime(val,row){
        var now = new Date(val);
        return now.format("yyyy-MM-dd hh:mm:ss");
    }

    // 格式化作业的状态
    function formatWorkStatus(val,row){
        if (val == 1){
            return '<a href="#" class="easyui-linkbutton" style="color:#2a20ff">未完成</a>';
        } else if(val == 2){
            return '<span class="easyui-linkbutton" style="color:#16ff25">已完成</span>';
        } else {
            return '<span class="easyui-linkbutton" style="color:red">错误</span >';
        }
    }


    // 格式化参考文件下载按钮
    function formatReferenceDownButton(val,row){
        if (val == ''){
            return '无';
        } else if(val == null){
            return '空';
        } else {
            var url = val+'?filename='+row.referenceFileName;
            return '<a href="'+url+'" class="easyui-linkbutton" style="color:#2a20ff">下载</a>';
        }
    }

    // 格式化作业下载按钮
    function formatDownButton(val,row){
        if (val == ''){
            return '无';
        } else if(val == null){
            return '空';
        } else {
            var rows = [];
            rows = row;
            return '<a href="#" class="mydown" style="color:#2a20ff">双击下载</a>';
        }
    }






    // 格式化作业收取类型
    function formatWorkType(val,row){
        if (val == 1){
            return '在线收取';
        } else if(val == 2){
            return '线下收取';
        } else {
            return '未知';
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
                    classesId :node.id
		        });
			}
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
			url : "/user-add?classesId"+node
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
			url : "/content-edit",
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
    		$.messager.alert('提示','未选中商品!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的内容吗？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("/content/delete",params, function(data){

        			if(data.status == 200){
        				$.messager.alert('提示','删除内容成功!',undefined,function(){
        					$("#contentList").datagrid("reload");
        				});
        			}
        		});
    	    }
    	});
    }
},
    {
        text:'下载',
        iconCls:'icon-ok',
        handler:function(){
            //获取被选中的内容的id的集合
            var filePaths = getSelectionsFilePath();
            var students =  getSelectionsStringNames();
            var filenames =  getSelectionsFileName();
            var ids = TT.getSelectionsIds("#noDownList");
            if(ids.length == 0){
                $.messager.alert('提示','未选中下载项!');
                return ;
            }
            $.messager.confirm('确认','确定下载 '+students+' 的作业吗？',function(r){
                if (r){
                    var params = {"fileUrls":filePaths,"ids":ids,"filenames":filenames};
                    $.post("/file/down",params, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示',"下载成功!",function(){
                                $("#noDownList").datagrid("reload");
                            });
                        }else {
                            $.messager.alert("提示",data.message);
                        }
                    },"json");
                }
            });
        }
    },

    {
        text:'提醒',
        iconCls:'icon-ok',
        handler:function(){
            //获取被选中的内容的id的集合
            var ids = TT.getSelectionsIds("#contentList");
            if(ids.length == 0){
                $.messager.alert('提示','未选中商品!');
                return ;
            }
            $.messager.confirm('确认','确定删除ID为 '+ids+' 的内容吗？',function(r){
                if (r){
                    var params = {"ids":ids};
                    $.post("/content/delete",params, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','删除内容成功!',undefined,function(){
                                $("#contentList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }];

    function getSelectionsFilePath(){
        var itemList = $("#noDownList");
        var sels = itemList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].workFilePath);
        }
        ids = ids.join(",");
        return ids;
    }

    function getSelectionsStringNames(){
        var itemList = $("#noDownList");
        var sels = itemList.datagrid("getSelections");
        var username = [];
        for(var i in sels){
            username.push(sels[i].username);
        }
        username = username.join(",");
        return username;
    }

    function getSelectionsStudent(){
        var itemList = $("#noDownList");
        var sels = itemList.datagrid("getSelections");
        var student = [];
        for(var i in sels){
            student.push(sels[i].studentId);
        }
        student = student.join(",");
        return student;
    }
    function getSelectionsFileName(){
        var itemList = $("#noDownList");
        var sels = itemList.datagrid("getSelections");
        var student = [];
        for(var i in sels){
            student.push(sels[i].workFileName);
        }
        student = student.join(",");
        return student;
    }

    // 当双击一个单元格,开始编辑,使编辑器获得焦点
    $('#contentList').datagrid({
        onDblClickRow: function(rowIndex, rowData){
            alert("打开班级同学的作业收取情况！");
            $("#noDownList").datagrid('reload', {
                //发送请求的参数：categoryId :分类的id
                status :2,
                workId :rowData.workId
            });
            $("#downedList").datagrid('reload', {
                //发送请求的参数：categoryId :分类的id
                status :3,
                workId :rowData.workId
            });
            $("#notSubimtList").datagrid('reload', {
                //发送请求的参数：categoryId :分类的id
                status :1,
                workId :rowData.workId
            });
        }
    });

    // 当双击一个单元格,开始编辑,使编辑器获得焦点
        $('#noDownList').datagrid({
            onDblClickRow: function(rowIndex, rowData){
                $.messager.confirm("确认","是否要下载"+rowData.studentId+"的作业？",function (r) {
                    if(r){
                        var params = {"workItemId":rowData.id};
                        location.href=rowData.workFilePath+"?filename="+rowData.workFileName;
                        $.post("/workitem/down",params, function(data){
                            if(data.status == 200){
                                $.messager.alert('提示','下载成功!',undefined,function(){
                                    $("#noDownList").datagrid("reload");
                                });
                            }else {
                                $.error("下载失败请重试！！");
                            }
                        });
                    }

                })
            }
        });

</script>