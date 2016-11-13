<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path=request.getContextPath();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <title>登录界面</title>
        <link rel="stylesheet" href="<%=path %>/css/antui.min.css"/>
        <!-- <link rel="stylesheet" href="path/to/antui/dist/widget/list.min.css"/> -->
        <script src="<%=path %>/js/antui.min.js"></script>
         <script src="<%=path %>/js/jquery.js"></script>
    </head>
    <body>
    
    <div class="demo-content" align="center">
  <div class="am-list form">
    <div class="am-list-header">用户登录</div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">用户名</div>
      <div class="am-list-control">
        <input type="text" placeholder="用户名" id="username" value="">
      </div>
      <!-- <div class="am-list-clear"><i class="am-icon-clear am-icon"></i></div>
      <div class="am-list-button">
        <button type="button">发送校验码</button>
      </div> -->
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">密码</div>
      <div class="am-list-control">
        <input type="password" placeholder="密码" id="password" value="">
      </div>
    </div>
  </div></div>
  <div class="demo-content">
      <!--<div class="demo-type-title">组合按钮</div>-->
      <div class="am-button-group">
        <button type="button" class="am-button blue" id="login">登录</button>
        <button type="button" class="am-button blue" id="register">注册</button>
      </div>
    </div>
    <div class="demo-mobile">
    <div class="am-dialog" id="info">
      <div class="am-dialog-wrap">
        <div class="am-dialog-header">
          <h3>提示信息</h3>
        </div>
        <div class="am-dialog-body">
          <p class="am-dialog-brief" id="errorInfo"></p>
        </div>
        <div class="am-dialog-footer">
          <button type="button" id="hideButton" class="am-dialog-button">确定</button>
        </div>
      </div>
    </div>
  </div>
    <script type="text/javascript">
    $(function(){
    	$("#login").click(function(){
    		if(check()){
    			$.post("<%=path%>/loginAccount",{
    				username:$.trim($("#username").val()),
    				password:$.trim($("#password").val())
    			},function(data){
    				if(data=="success"){
    					location.href="<%=path%>/page/main";
    				}else{
    					 $("#errorInfo").html("用户名或者密码错误");
    		    		 showErrorInfo();
    				}
    			});
    		}
    	});
    	
    	$("#register").click(function(){
    		location.href="<%=path%>/page/register";
    	});
    	 $("#hideButton").click(function(){
    		 hideErrorInfo();
    	 });
    })
    
 function showErrorInfo(){
	 $("#info").addClass("show");
 }
 
 function hideErrorInfo(){
	 $("#info").removeClass("show");
 }
    
    function check(){
    	var username=$.trim($("#username").val());
    	var password=$.trim($("#password").val());
    	 if(username==""){
    		 $("#errorInfo").html("请填写用户名");
    		 showErrorInfo();
    		 return false;
    	 }
    	 if(password==""){
    		 $("#errorInfo").html("请填写密码");
    		 showErrorInfo();
    		 return false;
    	 }
    	 return true;
    }
    </script>
    </body>
</html>