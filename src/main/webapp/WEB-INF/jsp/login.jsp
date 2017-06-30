<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/include/include.jsp" %>
<!DOCTYPE html>
<html>
<%@ include file="/resources/include/head.html" %>
<body>
<header>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-vertical-middle" href="/">
                            <span class="navbar-logo-text">
                                blog
                            </span>
                        </a>
                    </div>
                    <%--<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right navbar-btn">
                            <li><a href="#">关于</a></li>
                        </ul>
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="搜索">
                            </div>
                        </form>
                    </div>--%>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
    </nav>
</header>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="container-fluid">
                <div class="col-md-8">
                    <div class="background-text hidden-xs">
                        <p><b style="color:black;">Hello,World</b></p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div style="margin-top: 60%">
                        <form:form modelAttribute="loginCommand" name="loginForm" id="loginForm">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-user"></span>
                                </div>
                                <form:input path="username" cssClass="form-control" />
                            </div>
                            <br>
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-lock"></span>
                                </div>
                                <form:input type="password" path="password" id="password" cssClass="form-control"/>
                            </div>
                            <br>
                            <input class="btn btn-primary btn-block" type="button" value="登陆" onclick="encryptPasswd()"/>
                            <br>
                            <form:checkbox path="rememberMe"/>
                            <span class="r-checkbox-text">记住我</span>
                            <a class="btn btn-primary btn-xs pull-right" href="./register">注册</a>
                        </form:form>
                    </div>
                </div>
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<script src="/resources/js/jquery-3.1.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/cryptico.min.js"></script>
<script>
    $(function(){
    });
    function encryptPasswd(){
        $.getJSON('/getPublicKey',function (key) {
            $("#password").val(cryptico.encrypt($("#password").val(),key).cipher);
            $("#loginForm").submit();
        })
    }
</script>
</body>
</html>
