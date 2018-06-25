<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/20
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>项目文件编辑</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
</head>

<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>项目文件编辑</legend>
    </fieldset>
    <form method="post"  action="software_update" enctype="multipart/form-data" >
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">软件名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="sName" value="${sw.sName}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">上传日期</label>
                <div class="layui-input-block">
                    <input type="text" name="sTime" value="${sw.sTime}" id="date" lay-verify="date" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
                </div>
            </div>
            <input name="uId" value="${sessionScope.user.uId}" hidden >
        </div>

        <%--software--%>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">软件</label>
            <div class="layui-input-inline">
                <input type="file"  name="software" >
            </div>
        </div>
        <input type="hidden" value="${sw.sSoftware}" name="c_certificate">

        <div class="layui-form-item">
        <div class="layui-block">
            <label class="layui-form-label">版本号</label>
            <div class="layui-input-block">
                <input type="text" name="sVersion" value="${sw.sVersion}" autocomplete="off" class="layui-input" >
            </div>
        </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            </div>
        </div>
        <input value="${sw.sId}" name="sId" type="hidden">
    </form>

    <input type="hidden" id="result" name="result" value="${result}">
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/layui/layui.js"></script>

<script>
    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form(),
            layer = layui.layer,
            layedit = layui.layedit,
            laydate = layui.laydate;
    });

    layui.use('layer',function(){
        var layer=layui.layer,$=layui.jquery;

        var res=$("#result").attr("value");
        if(res=="true"){
            layer.msg("编辑成功!");
            setTimeout(function (args) {
                    window.parent.location.reload();//刷新父页面
                    var index=parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index); }
                , 1000);
        }else if(res=="false"){
            layer.msg("编辑失败，请稍后再试！");
            setTimeout(function (args) {
                    window.parent.location.reload();//刷新父页面
                    var index=parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index); }
                , 1000);
        }
    });
</script>
</body>
</html>
