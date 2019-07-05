<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<script type="text/javascript" src="/WEB-INF/js/common.js"></script>--%>
<table class="easyui-datagrid" id="itemList" title="作业列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/work/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'workId',width:100,hidden:'true'"></th>
        	<th data-options="field:'workName',width:100">作业名称</th>
            <th data-options="field:'collectType',width:100,formatter:formatWorkType">收取类型</th>
            <th data-options="field:'status',width:120,align:'center',formatter:formatWorkStatus">状态(双击改变状态)</th>
            <th data-options="field:'createTime',width:150,formatter:formatDateTime">创建时间</th>
            <th data-options="field:'closeTime',width:152,align:'right',formatter:formatDateTime">截止时间</th>
            <th data-options="field:'classesId',width:70,align:'right'">所属班级</th>
            <th data-options="field:'cid',width:100">科目</th>
            <th data-options="field:'workDesc',width:60,align:'center',formatter:TAOTAO.formatItemStatus">详情</th>
            <th data-options="field:'referenceFileName',width:130,align:'center'">参考文件</th>
            <th data-options="field:'referenceFilePath',width:130,align:'center',formatter:formatDownButton">下载参考文件</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>

<script>

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



    // 格式化下载按钮
    function formatDownButton(val,row){
        if (val == ''){
            return '无';
        } else if(val == null){
            return '空';
        } else {
            var url = val+'?filename='+row.referenceFileName;
            return '<a href="'+url+'" class="easyui-linkbutton" style="color:#2a20ff">下载</a>';
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

    function getSelectionsIds(){
    	var itemList = $("#itemList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].workId);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    function getSelectionsNames(){
    	var itemList = $("#itemList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].workName);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$(".tree-title:contains('新增商品')").parent().click();
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
        	
        	$("#itemEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#itemList").datagrid("getSelections")[0];
        			data.priceView = TAOTAO.formatPrice(data.price);
        			$("#itemeEditForm").form("load",data);
        			
        			// 加载商品描述
        			$.getJSON('/rest/item/query/item/desc/'+data.id,function(_data){
        				if(_data.status == 200){
        					//UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
        					itemEditEditor.html(_data.data.itemDesc);
        				}
        			});
        			
        			//加载商品规格
        			$.getJSON('/rest/item/param/item/query/'+data.id,function(_data){
        				if(_data && _data.status == 200 && _data.data && _data.data.paramData){
        					$("#itemeEditForm .params").show();
        					$("#itemeEditForm [name=itemParams]").val(_data.data.paramData);
        					$("#itemeEditForm [name=itemParamId]").val(_data.data.id);
        					
        					//回显商品规格
        					 var paramData = JSON.parse(_data.data.paramData);
        					
        					 var html = "<ul>";
        					 for(var i in paramData){
        						 var pd = paramData[i];
        						 html+="<li><table>";
        						 html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
        						 
        						 for(var j in pd.params){
        							 var ps = pd.params[j];
        							 html+="<tr><td class=\"param\"><span>"+ps.k+"</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='"+ps.v+"'/></td></tr>";
        						 }
        						 
        						 html+="</li></table>";
        					 }
        					 html+= "</ul>";
        					 $("#itemeEditForm .params td").eq(1).html(html);
        				}
        			});
        			
        			TAOTAO.init({
        				"pics" : data.image,
        				"cid" : data.cid,
        				fun:function(node){
        					TAOTAO.changeItemParam(node, "itemeEditForm");
        				}
        			});
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	var names = getSelectionsNames();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中任务!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除 '+names+'  作业任务吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/work/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除作业成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },'-',{
        text:'下架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定下架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/item/instock",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','下架商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'上架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/item/reshelf",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','上架商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];

    // 当双击一个单元格,开始编辑,使编辑器获得焦点
    $('#itemList').datagrid({
        onDblClickRow: function(rowIndex, rowData){
            var params = {
            "workId": rowData.workId,
            "status": rowData.status,
            };
            $.post("/work/updateStatus",params, function(data){

                if(data.status == 200){
                         $('#itemList').datagrid('reload');
                }else {
                    $.error(data.msg);
                }
            });
        }
    });

</script>