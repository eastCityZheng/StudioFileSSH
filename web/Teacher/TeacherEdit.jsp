<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/28
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>教师信息编辑</title>
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
        <legend>教师信息编辑</legend>
    </fieldset>
    <form method="post"  action="user_teaupdate"   >
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">工号</label>
                <div class="layui-input-inline">
                    <input type="text" name="uAccount" value="${us.uAccount}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="uName" value="${us.uName}" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input type="text" name="uPassword" value="${us.uPassword}" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <input value="${us.uId}" name="uId" type="hidden">
        <input value="${us.wId}" name="wId" type="hidden">
        <input value="${us.uType}" name="uType" hidden>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            </div>
        </div>
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
