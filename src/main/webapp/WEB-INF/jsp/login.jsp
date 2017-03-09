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
                        <p>public static void main(String [] args) {</p>
                        <p>&emsp;System.out.println("<b style="color:black">Hello,World</b>");</p>
                        <p>}</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div style="margin-top: 50%">
                        <form id="form_login" method="post">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-user"></span>
                                </div>
                                <input class="form-control" type="text" name="loginId" id="loginId"
                                       placeholder="请输入用户名" required/>
                            </div>
                            <br>
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-lock"></span>
                                </div>
                                <input class="form-control" type="password" name="password" id="password"
                                       placeholder="请输入密码" required/>
                            </div>
                            <br>
                            <input class="btn btn-primary btn-block" type="button" id="submit" value="登陆"/>
                            <br>
                            <input type="checkbox" name="autoLogin"/>
                            <span class="r-checkbox-text">记住我</span>
                            <a class="btn btn-primary btn-xs pull-right" href="./register">注册</a>
                        </form>
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
</body>
</html>
