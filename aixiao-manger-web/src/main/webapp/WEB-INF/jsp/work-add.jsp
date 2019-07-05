<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="js/jquery-easyui-1.4.1/jquery-form.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>班级:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择班级</a>
	            	<input type="hidden" name="cid" style="width: 280px;"></input>
	            </td>
	        </tr>

            <tr>
                <td>科目:</td>
                <td>
                    <input id="cc" class="easyui-combobox" name="classesId"/>

                </td>
                <script type="text/javascript">
                    $('#cc').combobox({

                        url:'/subject/list?classesId='+$("#itemAddForm [name=cid]").val(),

                        valueField:'id',

                        textField:'subjectName'

                    });

                </script>
            </tr>

	        <tr>
	            <td>作业/实验名称:</td>
	            <td><input class="easyui-textbox" type="text" name="workName" data-options="required:true" style="width: 280px;" placeholder="例如：XX课第一次实验"></input></td>
	        </tr>
	        <tr>
	            <td>截止日期:</td>
	            <td>
                    <input class="easyui-datetimebox" name="closeTime" data-options="required:true,showSeconds:true" value="2019-03-03 14:14:14" style="width:150px">

                </td>
	        </tr>

	        <tr>
	            <td>上传参考文件:</td>
	            <td>
                    <input type="text" class="enclosure-text" name="referenceFileName"/>
                    <a href="javascript:void(0)" onclick="$('#file-input').click()" class="easyui-linkbutton">上传文件</a>
                    <span class="file-tip">支持doc/docx/pdf等格式，支持压缩文件</span>
                    <p class="warning-manage enclosure-null hide ">附件不能为空</p>
                    <input id="file_path" type="hidden"  name="referenceFilePath" value=""/>
	            </td>
	        </tr>
	        <tr>
	            <td>作业/实验详情:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="workDesc"></textarea>
	            </td>
	        </tr>
	        <tr class="params hide">
	        	
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
         <div class="comment-right-float">
                  <form action="/file/upload" method="post" id="submitFile" enctype="multipart/form-data">   <!-action为后台给的接口路径->
                           <input type="file" id="file-input" name="uploadFile" style="visibility: hidden;display: inline-block;width:2px;position: fixed;left: -1000px;" accept=".doc,.pdf,.docx,.zip,.rar"/>

                    </form>
         </div>  
    <script type="text/javascript">
        var fileUrl;  //需要的url，在保存时后台需要这个地址
        var saveFileName;  //上传完成后截取的文件名
        var uploadFile = document.getElementById('file-input').files[0];
        $('#file-input').change(function(){
            //判断文件名是否为空，不为空时截取文件的名
            if($(this).val() == ''){
                return false;
            }else{
                saveFileName=$(this).val().slice(12);
                $(".enclosure-text").val(saveFileName);

        }

            $('#submitFile').ajaxSubmit({
                type:'post',
                dataType:'json',
                success:function(result){
                    if(result.error == 0){
                        //请求成功后后台会返回一个URL 地址，该地址是你最后保存时需要提交给后台的。
                        fileUrl=result.url;
                        //alert(fileUrl);
                        $("#file_path").val(fileUrl);
                        //并且清空原文件，不然选择相同文件不能再次传 
                        //$('#file-input').val(''); 
                    }
                },
                error:function(){
                    //并且清空原文件，不然选择相同文件不能再次传 
                    $('#file-input').val(''); 
                }
            });
        })
    </script>

</div>
<script type="text/javascript">
	var itemAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=workDesc]");
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//TAOTAO.changeItemParam(node, "itemAddForm");
		}});
	});
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#itemAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//取商品价格，单位为“分”
		// $("#itemAddForm [name=price]").val(eval($("#itemAddForm [name=priceView]").val()) * 100);
		//同步文本框中的商品描述
		itemAddEditor.sync();
		//取商品的规格
		/*
		var paramJson = [];
		$("#itemAddForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		//把json对象转换成字符串
		paramJson = JSON.stringify(paramJson);
		$("#itemAddForm [name=itemParams]").val(paramJson);
		*/
		//ajax的post方式提交表单
		//$("#itemAddForm").serialize()将表单序列号为key-value形式的字符串
        // alert($("#itemAddForm").serialize());
		$.post("/work/save",$("#itemAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增作业成功!');
			}
		});
	}
	
	function clearForm(){
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	}
</script>
