<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/20
  Time: 13:03
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
    <legend>用户列表</legend>
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
            <th>姓名</th>
            <th>学号</th>
            <th>班级</th>
            <th>年级</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${usList}" var="us" >
            <c:choose>

                <c:when test="${us.uType!=2}">
                    <tr>
                        <th>${us.uName}</th>
                        <th>${us.uAccount}</th>
                        <th>${us.uClass}</th>
                        <th>${us.uGrade}</th>
                        <th id="layer">
                            <c:choose>
                                <c:when test="${sessionScope.user.uType==0}">
                                    无权操作
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${sessionScope.user.uType==2}">
                                            <c:choose>
                                                <c:when test="${us.uType==0}">
                                                    <button  id="settype" data-method="settype" data-type="1" data-uid="${us.uId}" class="layui-btn layui-btn-mini">设置为负责人</button>
                                                </c:when>
                                                <c:when test="${us.uType==1}">
                                                    <button  id="settype" data-method="settype" data-type="0" data-uid="${us.uId}" class="layui-btn layui-btn-mini">取消负责人</button>
                                                </c:when>
                                            </c:choose>
                                        </c:when>
                                    </c:choose>
                                    <button  id="edit" data-method="edit" data-type="${us.uId}" data-path="<%=basePath%>" class="layui-btn layui-btn-mini">编辑</button>
                                    <button  id="deletee" data-method="deletee" data-type="${us.uId}" class="layui-btn layui-btn-mini">删除</button>
                                </c:otherwise>
                            </c:choose>
                        </th>
                    </tr>
                </c:when>
            </c:choose>
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
                text = othis.text();
                layer.open({
                    type: 1
                    , offset: '100px'
                    , content: '<form class="layui-form" action="user_del" method="get">' +
                    '<p style="position:absolute;top:90px;left:95px;font-size:18px;">确定要删除此用户信息么？</p>' +
                    '<input type="text" name="uId" hidden="hidden" value="' + type + '"></input>' +
                    '<div style="position:absolute;top:120px;left:160px;"><button type="submit" class="layui-btn layui-btn-normal">确定</button></div></form>'
                    , btnAlign: 'c' //按钮居中
                    , shade: [0.8, '#393D49'] //显示遮罩
                    , area: ['400px', '300px']
                });
            },
            settype: function (othis) {
                var type = othis.data('type');
                var uid=othis.data('uid');
                text = othis.text();
                layer.open({
                    type: 1
                    , offset: '100px'
                    , content: '<form class="layui-form" action="user_type" method="get">' +
                    '<p style="position:absolute;top:90px;left:95px;font-size:18px;">确定要修改此用户类型么？</p>' +
                    '<input type="text" name="uId" hidden="hidden" value="' + uid + '"></input>' +
                    '<input type="text" name="uType" hidden="hidden" value="' + type + '"></input>' +
                    '<div style="position:absolute;top:120px;left:160px;"><button type="submit" class="layui-btn layui-btn-normal">确定</button></div></form>'
                    , btnAlign: 'c' //按钮居中
                    , shade: [0.8, '#393D49'] //显示遮罩
                    , area: ['400px', '300px']
                });
            },
            edit: function(othis){
                var type = othis.data('type');
                var path=othis.data('path');

                layer.open({
                    type: 2
                    ,offset:'20px'
                    ,content:''+path+'user_edit?uId='+type+''
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
