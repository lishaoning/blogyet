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
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand navbar-btn" href="/"><span class="icon icon--logo"><svg version="1.0"
                                                                                                       xmlns="http://www.w3.org/2000/svg"
                                                                                                       width="150"
                                                                                                       height="65"
                                                                                                       viewBox="0 0 899.000000 341.000000"
                                                                                                       preserveAspectRatio="xMidYMid meet"><g
                                transform="translate(0.000000,341.000000) scale(0.100000,-0.100000)" fill="#ec4a3f"
                                stroke="none"><path
                                d="M2043 3237 c-178 -95 -323 -174 -323 -177 1 -3 146 -82 323 -175 l322 -171 3 173 c1 95 1 251 0 347 l-3 174 -322 -171z"/><path
                                d="M2983 2917 c-182 -97 -319 -175 -314 -180 5 -5 150 -84 322 -177 l314 -168 3 174 c1 96 1 252 0 348 l-3 175 -322 -172z"/><path
                                d="M7953 2917 c-184 -98 -319 -175 -314 -180 5 -5 150 -85 322 -177 l314 -169 3 174 c1 96 1 254 0 350 l-3 174 -322 -172z"/><path
                                d="M371 2880 c-172 -92 -317 -172 -322 -177 -6 -6 116 -76 312 -181 178 -95 324 -170 326 -168 2 1 2 159 1 349 l-3 346 -314 -169z"/><path
                                d="M2630 2349 l0 -350 138 73 c406 215 511 273 504 280 -4 4 -122 68 -262 143 -140 75 -283 152 -317 171 l-63 34 0 -351z"/><path
                                d="M7600 2350 l0 -352 88 47 c438 233 560 300 556 306 -2 4 -133 75 -291 159 -159 84 -303 161 -320 172 l-33 20 0 -352z"/><path
                                d="M10 2308 c0 -276 3 -349 13 -345 44 17 629 335 630 343 0 5 -145 86 -321 180 l-322 172 0 -350z"/><path
                                d="M3360 1980 c0 -278 3 -351 13 -347 6 2 155 81 330 175 l319 170 -64 35 c-34 19 -146 79 -248 132 -102 54 -222 118 -267 142 l-83 45 0 -352z"/><path
                                d="M8330 1979 c0 -277 3 -350 13 -346 6 2 155 81 330 175 l319 170 -64 35 c-48 27 -468 250 -580 309 -17 8 -18 -11 -18 -343z"/><path
                                d="M2992 2139 c-173 -92 -318 -171 -323 -176 -5 -5 126 -80 314 -180 l322 -172 3 174 c1 96 1 253 0 347 l-3 173 -313 -166z"/><path
                                d="M7962 2139 c-173 -92 -318 -171 -323 -176 -5 -5 123 -79 314 -180 l322 -172 3 174 c1 96 1 253 0 348 l-3 172 -313 -166z"/><path
                                d="M360 2090 c-173 -92 -314 -172 -312 -177 3 -8 621 -342 635 -343 4 0 7 155 7 345 0 190 -3 345 -7 345 -5 -1 -150 -77 -323 -170z"/><path
                                d="M750 1915 c0 -190 3 -345 8 -345 17 1 631 336 631 345 0 9 -614 344 -631 345 -5 0 -8 -155 -8 -345z"/><path
                                d="M5020 1912 l0 -350 317 169 c174 93 321 173 325 177 4 4 -101 66 -235 136 -133 71 -279 149 -324 174 l-83 44 0 -350z"/><path
                                d="M6302 2087 c-304 -162 -321 -173 -302 -187 11 -8 81 -46 155 -85 l135 -70 162 84 c90 46 166 87 171 91 4 3 6 81 5 172 l-3 166 -323 -171z"/><path
                                d="M6680 1916 c0 -243 3 -346 11 -346 11 0 627 326 641 339 5 5 -601 335 -643 349 -5 2 -9 -131 -9 -342z"/><path
                                d="M1690 1885 c0 -190 3 -345 8 -345 14 0 636 335 636 343 1 8 -620 346 -636 347 -5 0 -8 -155 -8 -345z"/><path
                                d="M2630 1568 l0 -350 88 47 c452 240 560 301 553 308 -4 4 -151 84 -325 176 l-316 169 0 -350z"/><path
                                d="M7600 1568 l0 -350 88 47 c460 245 560 301 553 308 -5 5 -151 85 -325 177 l-316 168 0 -350z"/><path
                                d="M10 1522 l0 -350 323 172 c177 94 321 175 320 180 -1 8 -587 327 -630 343 -10 4 -13 -69 -13 -345z"/><path
                                d="M1270 1791 l-145 -79 0 -189 0 -188 153 -81 152 -82 0 349 c0 192 -3 349 -7 349 -5 -1 -73 -36 -153 -79z"/><path
                                d="M4280 1522 l0 -349 325 171 c178 94 325 174 325 177 0 3 -105 61 -232 129 -128 68 -275 145 -325 172 l-93 50 0 -350z"/><path
                                d="M5372 1697 c-309 -165 -322 -173 -301 -187 12 -8 159 -88 326 -176 l303 -162 0 349 c0 192 -1 349 -2 349 -2 0 -148 -78 -326 -173z"/><path
                                d="M5950 1522 l0 -351 93 50 c50 27 197 104 324 171 128 68 233 126 233 129 0 3 -105 61 -232 129 -128 68 -275 145 -325 173 l-93 49 0 -350z"/><path
                                d="M2042 1669 c-178 -94 -320 -175 -315 -180 14 -14 635 -341 639 -336 2 2 3 158 2 345 l-3 342 -323 -171z"/><path
                                d="M2992 1359 c-173 -92 -318 -171 -323 -176 -5 -5 121 -78 314 -180 l322 -172 3 174 c1 96 1 253 0 347 l-3 173 -313 -166z"/><path
                                d="M7961 1358 c-173 -93 -318 -171 -323 -176 -4 -4 137 -85 315 -179 l322 -172 3 174 c1 96 1 253 0 348 l-3 172 -314 -167z"/><path
                                d="M358 1308 c-175 -94 -315 -174 -313 -178 3 -5 121 -70 262 -146 142 -75 286 -153 321 -172 l62 -34 0 351 c0 193 -3 351 -7 350 -5 -1 -151 -78 -325 -171z"/><path
                                d="M750 1130 l0 -351 23 12 c133 69 605 325 615 334 10 9 -57 49 -308 183 -177 95 -323 172 -326 172 -2 0 -4 -158 -4 -350z"/><path
                                d="M4633 1307 c-177 -95 -318 -176 -314 -180 5 -5 149 -84 322 -176 l314 -168 3 173 c1 96 1 252 0 348 l-3 174 -322 -171z"/><path
                                d="M5020 1130 c0 -193 3 -349 8 -347 4 2 144 77 312 167 168 90 311 168 317 174 12 11 -30 35 -549 311 l-88 47 0 -352z"/><path
                                d="M6303 1307 c-186 -99 -319 -175 -314 -180 5 -5 150 -85 323 -177 l313 -168 3 174 c1 96 1 252 0 348 l-3 174 -322 -171z"/><path
                                d="M6680 1130 c0 -192 2 -350 4 -350 4 0 427 226 584 312 l73 40 -326 174 c-179 96 -328 174 -331 174 -2 0 -4 -157 -4 -350z"/><path
                                d="M1690 1100 l0 -351 128 68 c70 37 216 115 325 173 108 58 197 108 197 111 0 6 -608 334 -641 347 -5 2 -9 -154 -9 -348z"/><path
                                d="M5381 918 c-173 -93 -318 -171 -323 -176 -4 -4 137 -85 315 -179 l322 -172 3 174 c1 96 1 253 0 348 l-3 172 -314 -167z"/><path
                                d="M5020 348 l0 -349 128 68 c70 37 216 115 325 173 108 57 193 108 189 112 -4 4 -151 84 -325 177 l-317 169 0 -350z"/></g></svg></span></a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right navbar-btn">
                            <li><a href="#">关于</a></li>
                        </ul>
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="搜索">
                            </div>
                        </form>
                    </div>
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
                <div class="col-md-8"></div>
                <div class="col-md-4">
                    <div>
                        <form id="form_login" method="post">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-user"></span>
                                </div>
                                <input class="form-control" type="text" name="loginId" id="loginId" placeholder="请输入用户名"
                                       required/>
                            </div>
                            <br>
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-lock"></span>
                                </div>
                                <input class="form-control" type="password" name="password" id="password"
                                       placeholder="请输入密码"
                                       required/>
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
        <div class="col-md-2"></div>
    </div>
</div>
<script src="/resources/js/jquery-3.1.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
