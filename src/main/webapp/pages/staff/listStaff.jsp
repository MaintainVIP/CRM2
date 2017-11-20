<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
    <%--<script>--%>
        <%--function createXMLHttpRequest() {--%>
            <%--try {--%>
                <%--return new XMLHttpRequest();--%>
            <%--} catch (e) {--%>
                <%--try {--%>
                    <%--return new ActiveXObject("Msxml2.HTTP");--%>
                <%--} catch (e) {--%>
                    <%--try {--%>
                        <%--return new ActiveXObject("Microsoft.HTTP");--%>
                    <%--} catch (e) {--%>
                        <%--throw e;--%>
                    <%--}--%>
                <%--}--%>
            <%--}--%>
        <%--}--%>

        <%--function changePost(obj) {--%>
            <%--//选中部门--%>
            <%--var deptId = obj.value;--%>
            <%--//获取XMLHttpRequest对象--%>
            <%--var xmlHttp = createXMLHttpRequest();--%>
            <%--//打开连接--%>
            <%--var url = "${pageContext.request.contextPath}/findPostByDeptId.action";--%>
            <%--xmlHttp.open("POST", url, true);--%>
            <%--//设置请求头--%>
            <%--xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");--%>
            <%--//发出请求时,给出请求体--%>
            <%--xmlHttp.send("deptId=" + deptId);--%>
            <%--//给xmlHttp对象的onreadystatechange事件注册监听--%>
            <%--xmlHttp.onreadystatechange = function () {--%>
                <%--if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {--%>
                    <%--//获取返回的json数据--%>
                    <%--var jsonData = eval("(" + xmlHttp.responseText + ")");--%>
                    <%--//显示到select的option中--%>
                    <%--var selectE = document.getElementById("postSelectId");--%>
                    <%--selectE.innerHTML = "<option value='-1'>--请选择职务--</option>";--%>
                    <%--for (var i = 0; i < jsonData.length; i++) {--%>
                        <%--var postObj = jsonData[i];--%>
                        <%--selectE.innerHTML += "<option name='post.postId' value='" + postObj.postId + "'>" + postObj.postName + "</option>";--%>
                    <%--}--%>
                <%--}--%>
            <%--}--%>
        <%--}--%>
    <%--</script>--%>
    <script type="text/javascript">
    function condition(){
        document.getElementById("conditionFormId").submit();
    }
</script>
</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[员工管理]</td>

        <td width="57%" align="right">
            <%--高级查询--%><%--高级查询--%>
            <a href="javascript:void(0)" onclick="condition()">
                <img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/></a>
            <%--员工注入--%><%--添加员工--%>
            <a href="${pageContext.request.contextPath}/addStaff.action">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>
        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/findStaffs.action" method="post">
    <table width="88%" border="0" style="margin: 20px;">
        <tr>
            <td width="80px">部门：</td>
            <td width="200px">
                <select name="post.dept.deptId">
                    <option value="">--请选择部门--</option>
                    <s:iterator value="departments" var="d">
                        <option value="${d.deptId}">${d.deptName}</option>
                        <%--查询条件: 部门ID--%>
                    </s:iterator>
                </select>
            </td>
            <td width="80px">职务：</td>
            <td width="200px">
                <select name="post.postId" >
                    <option value="">--请选择职务--</option>
               <s:iterator value="posts" var="p">
                   <option value="${p.postId}">${p.postName}</option>
                   <%--查询条件:职务ID--%>
               </s:iterator>
                </select>
            </td>
            <%--查询条件:姓名 staffName --%>
            <td width="80px">姓名：</td>
            <td width="200px"><input type="text" name="staffName" size="12"/></td>
            <td></td>
        </tr>
    </table>
</form>



<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1">
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">员工姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">职务</td>
        <td width="10%" align="center">编辑</td>
    </tr>
    <s:iterator value="staffs" var="staff">
        <tr class="tabtd2">

            <td align="center">${staff.staffName}</td>
            <td align="center">${staff.gender}</td>
            <td align="center">${staff.onDutyDate}</td>
            <td align="center">${staff.post.dept.deptName}</td>
            <td align="center">${staff.post.postName}</td>
            <td width="7%" align="center">
                <a href="${pageContext.request.contextPath}/editStaff.action?staffId=${staff.staffId}"><img
                        src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
            </td>
        </tr>
    </s:iterator>

</table>


<%-- 
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
--%>
</body>
</html>
