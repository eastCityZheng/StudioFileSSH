<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/28
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css" />
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>图书列表</legend>
</fieldset>
<div class="layui-form">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>工作室</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${usList}" var="us" >
            <tr>
                <td>${us.userEntity.uAccount}</td>
                <td>${us.userEntity.uName}</td>
                <td>${us.workroomName}</td>
                <td id="layer">
                    <button  id="edit" data-method="edit" data-path="<%=basePath%>" data-id="${us.userEntity.uId}" class="layui-btn layui-btn-mini">编辑</button>
                    <button  id="deletee" data-method="deletee"  data-id="${us.userEntity.uId}" class="layui-btn layui-btn-mini">删除</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<input type="hidden" id="message" value="${message}">
<input type="hidden" id="result" value="${result}">
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/layui/layui.js"></script>
</body>
<script>

    layui.use('layer', function() { //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
//触发事件
        var active = {

            deletee: function (othis) {
                var type = othis.data('type');
                var id=othis.data('id');
                layer.open({
                    type: 1
                    , offset: '100px'
                    , content: '<form class="layui-form" action="user_teadel" method="get">' +
                    '<p style="position:absolute;top:90px;left:95px;font-size:18px;">确定要删除么？</p>' +
                    '<input type="text" name="uId" hidden="hidden" value="' + id + '">' +
                    '<div style="position:absolute;top:120px;left:160px;"><button type="submit" class="layui-btn layui-btn-normal">确定</button></div></form>'
                    , btnAlign: 'c' //按钮居中
                    , shade: [0.8, '#393D49'] //显示遮罩
                    , area: ['400px', '300px']
                });
            },edit: function(othis){
                var id=othis.data('id');
                var path=othis.data('path');
                layer.open({
                    type: 2
                    ,offset:'20px'
                    ,content:''+path+'user_teaedit?uId='+id+''
                    ,shade: [0.8, '#393D49'] //显示遮罩
                    ,area: ['800px', '500px']
                });
            }

        };

        $('#layer .layui-btn').on('click', function () {
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';

        });

        var error=$("#message").attr("value");
        if(error!=null && error!=""){
            layer.msg(error);
        }

        var res=$("#result").attr("value");
        if(res=="true"){
            layer.msg("操作成功!");
        }else if(res=="false"){
            layer.msg("操作失败，请稍后再试！")
        }
    })
</script>
</html>
