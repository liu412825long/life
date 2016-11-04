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
        <title>注册界面</title>
        <link rel="stylesheet" href="../css/antui.min.css"/>
        <!-- <link rel="stylesheet" href="path/to/antui/dist/widget/list.min.css"/> -->
        <script src="../js/antui.min.js"></script>
        <script src="../js/jquery.js"></script>
    </head>
    <body>
    
    <div class="demo-content" align="center">
  <div class="am-list form">
    <div class="am-list-header">用户注册</div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">用户名</div>
      <div class="am-list-control">
        <input type="text" placeholder="用户名" id="username" value="">
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">密码</div>
      <div class="am-list-control">
        <input type="password" placeholder="密码" id="password" value="">
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">确认密码</div>
      <div class="am-list-control">
        <input type="password" placeholder="确认密码" id="confirm" value="">
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">用户昵称 </div>
      <div class="am-list-control">
        <input type="text" placeholder="用户昵称 " id="virtualName" value="">
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">真实姓名</div>
      <div class="am-list-control">
        <input type="text" placeholder="真实姓名" id="realName"  value="">
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">手机号码</div>
      <div class="am-list-control">
        <input type="text" placeholder="手机号码"  id="phone"  value="">
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">电子邮箱</div>
      <div class="am-list-control">
        <input type="text" placeholder="电子邮箱"  id="email"  value="">
      </div>
    </div>
    
  </div></div>
  <div class="demo-content" style="margin: 0 15px 60px;">
			<button type="button" id="register" class="am-button blue">注册</button>
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
	 $("#register").click(function(){
		 if(check()){
			 $.post("<%=path%>/registerAccount",{
				 username:$.trim($("#username").val()),
				 password:$.trim($("#password").val()),
				 virtualname:$.trim($("#virtualName").val()),
				 realname:$.trim($("#realName").val()),
				 cellphone:$.trim($("#phone").val()),
				 email:$.trim($("#email").val())
			 },function(data){
				 if(data=="success"){
					 $("#errorInfo").html("注册成功");
					 showErrorInfo();
					 location.href="<%=path%>/page/login";
				 }else{
					 location.href="<%=path%>/page/error";
				 }
			 });
		 }
	 });
	 
	 $("#hideButton").click(function(){
		 hideErrorInfo();
	 });
	 
 });
 
 function showErrorInfo(){
	 $("#info").addClass("show");
 }
 
 function hideErrorInfo(){
	 $("#info").removeClass("show");
 }
 
 function check(){
	var  username=$.trim($("#username").val());
	var  password=$.trim($("#password").val());
	 var virtualname=$.trim($("#virtualName").val());
	 var realname=$.trim($("#realName").val());
	 var cellphone=$.trim($("#phone").val());
	 var email=$.trim($("#email").val());
	 var repassword=$.trim($("#confirm").val());
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
	 if(repassword==""){
		 $("#errorInfo").html("请填写确认密码");
		 showErrorInfo();
		 return false;
	 }else{
		 if(repassword!=password){
			 $("#errorInfo").html("密码和确认密码不一致");
			 showErrorInfo();
			 return false;
		 }
	 }
	 if(virtualname==""){
		 $("#errorInfo").html("请填写昵称");
		 showErrorInfo();
		 return false;
	 }
	 if(realname==""){
		 $("#errorInfo").html("请填写姓名");
		 showErrorInfo();
		 return false;
	 }
	 if(cellphone==""){
		 $("#errorInfo").html("请填写手机号码");
		 showErrorInfo();
		 return false;
	 }
	 if(email==""){
		 $("#errorInfo").html("请填写电子邮箱");
		 showErrorInfo();
		 return false;
	 }
	 return true;
 }

 </script>
    </body>
</html>