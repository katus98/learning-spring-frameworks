<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/index.js"></script>
</head>
<body>

<h1>快速入门</h1>
<a href="/hello/hello">programme sayHello</a>
<a href="/hello/test?username=katus">programme test</a>
<hr>

<h1>请求参数绑定</h1>
<a href="/params/testParams1?name=katus&password=skrv587">请求参数绑定testParams1</a>
<form action="/params/saveAccount" method="post">
    username: <input type="text" name="username"/><br>
    password: <input type="text" name="password"/><br>
    money: <input type="text" name="money"/><br>
<%--    user name: <input type="text" name="user.name"/><br>--%>
<%--    user age: <input type="text" name="user.age"/><br>--%>
    user name:<input type="text" name="list[0].name"/><br>
    user age:<input type="text" name="list[0].age"/><br>

    map user name: <input type="text" name="map['one'].name"/><br>
    map user age: <input type="text" name="map['one'].age"/><br>
    <input type="submit" value="submit">
</form>
<form action="/params/saveUser" method="post">
    user name: <input type="text" name="name"/><br>
    user age: <input type="text" name="age"/><br>
    user date: <input type="text" name="date"/><br>
    <input type="submit" value="submit">
</form>
<a href="/hello/testServlet">测试Servlet原生API</a>
<hr>

<h1>测试常用注解</h1>
<a href="/an/testRequestParam?username=katus">RequestParam</a>
<form action="/an/testRequestBody" method="post">
    name: <input type="text" name="name"/><br>
    age: <input type="text" name="age"/><br>
    <input type="submit" value="submit">
</form>
<a href="/an/testPathVariable/59">PathVariable</a><br>
<a href="/an/testRequestHeader">RequestHeader</a><br>
<a href="/an/testCookieValue">CookieValue</a>
<form action="/an/testModelAttribute" method="post">
    name: <input type="text" name="name"/><br>
    age: <input type="text" name="age"/><br>
    <input type="submit" value="submit">
</form>
<a href="/an/testSessionAttributes">SessionAttributes</a><br>
<a href="/an/getSharedMsg">getSharedMsg</a><br>
<a href="/an/delAll">delAll</a>
<hr>

<h1>响应返回值</h1>
<a href="/user/testString">testString</a>
<a href="/user/testVoid">testVoid</a>
<a href="/user/testModelAndView">testModelAndView</a>
<a href="/user/testForwardOrRedirect">testForwardOrRedirect</a>
<button id="btn1">testAjax</button>
<button id="btn2">testAjax2</button>
<hr>

<h1>文件上传</h1>
<form action="/file/upload1" method="post" enctype="multipart/form-data">
    文件上传: <input type="file" name="upload"/>
    <input type="submit" value="传统文件上传"/>
</form>
<form action="/file/upload2" method="post" enctype="multipart/form-data">
    文件上传: <input type="file" name="upload"/>
    <input type="submit" value="SpringMVC文件上传"/>
</form>
<hr>

<h1>异常处理</h1>
<a href="/user/testException">异常处理</a>
<hr>

<h1>拦截器</h1>
<a href="/user/testInterceptor">拦截器测试</a>

</body>
</html>
