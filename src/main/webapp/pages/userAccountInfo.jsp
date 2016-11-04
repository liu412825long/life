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
        <title>个人信息</title>
        <link rel="stylesheet" href="../css/antui.min.css"/>
        <!-- <link rel="stylesheet" href="path/to/antui/dist/widget/list.min.css"/> -->
        <script src="../js/antui.min.js"></script>
        <script src="../js/jquery.js"></script>
    </head>
   <style>
html{height: 100%;}
body{height:100%;overflow-x: hidden;}
.widget-list-panel{
	position: relative;
	background: -webkit-linear-gradient(-120deg, #2288CD, #1471B2) top right no-repeat;
	-webkit-background-size:100%;
	height: 100%;
}
.widget-list-panel .header{
	position:relative;
	padding-bottom: 32px;
	color: #fff;
	text-align: center;
	z-index: 1;
}
.widget-list-panel h1{
	font-size: 40px;
	line-height: 48px;
	font-weight: 300;
	padding-top: 32px;
}
.widget-list-panel .header-info{
	font-size: 17px;
	line-height: 21px;
	padding-top: 6px;
}
.x-bg{
	position: absolute;
	width: 50%;
	min-width: 325px;
	height: 100%;
	right: 0;
	top: 0;
	background: url('https://os.alipayobjects.com/rmsportal/ZbQiBgorAUacvlC.png') no-repeat right top;
	background-size: 100% auto;
	z-index: 1;
}

.widget-list{
	padding: 0px 15px 15px 0;
	list-style: none;
	display:table;
	table-layout: fixed;
	box-sizing: border-box;
	width: 100%;
	max-width: 1200px;
	margin: 0 auto;
}
.widget-list .widget-item {
	display: inline-block;
	list-style: none;
	width: 50%;
	padding: 15px 0 0 15px;
	box-sizing: border-box;
	text-align: center;
}
.widget-list .widget-wrap{
	display: block;
	width: 100%;
	height: 100%;
	background: rgba(255, 255, 255, 0.8);
	border-radius: 3px;
	padding: 23px 15px 20px;
	box-sizing: border-box;
}
.widget-list .widget-wrap:active{
	background: rgba(238, 238, 238, 0.85);
	border-radius: 3px;
}
.widget-list .icon{
	display: inline-block;
	width: 30px;
	height: 30px;
	background: url('https://os.alipayobjects.com/rmsportal/ErzQirFUtUPzGTm.png') no-repeat center;
	background-size: 32px auto;
}
.widget-list .icon.button{
	background-position: -1px -1px;
}

.widget-list .icon.list {
	background-position: -1px -65px;
}
.widget-list .icon.message {
	background-position: -1px -97px;
}
.widget-list .icon.notice {
	background-position: -1px -129px;
}

.widget-list .icon.popmenu {
	background-position: -1px -193px;
}
.widget-list .icon.process {
	background-position: -1px -225px;
}

.widget-list .icon.search {
	background-position: -1px -289px;
}

.widget-list .icon.tab {
	background-position: -1px -321px;
}

.widget-list .icon.dialog {
	background-position: -1px -33px;
}

.widget-list .icon.loading {
	background-position: -1px -256px;
}

.widget-list .icon.page-result {
	background-position: -1px -160px;
}

.widget-list .name{
	font-size: 15px;
	color: #000;
	margin: 9px 0 4px;
	line-height: 17px;
	font-weight: 300;
}
.widget-list .info{
	font-size: 12px;
	color: #888;
}
.widget-demo-show-panel{
	background: #f5f5f9;
}

.demo .am-button, .demo .am-tab, .demo .am-message, .demo .am-notice, .demo .am-inform{
	margin-bottom: 21px;
}

.demo .am-message.multi,
.demo .am-button-wrap .am-button,
.demo .am-button-group .am-button,
.demo .am-button.bottom:last-child{
	margin-bottom: 0;
}
.demo .am-button.bottom{
	position: relative;
}

.demo .demo-content{
	padding-bottom: 0px;
}

.demo.demo-button .demo-content:last-child,
.demo.demo-loading .demo-content{
	padding-bottom: 0;
}

.demo-dialog .demo-content{
	min-height: 450px;
	background: rgba(1,1,1,0.35);
	position: relative;
}
.demo-toast .demo-content{
	 min-height: 300px;
	position: relative;
}
.demo-toast .am-toast{
	position: absolute;
}
.demo-page-result .demo-content{
	min-height: 300px;
}
.demo-header{
	text-align: center;
	font-size: 30px;
	padding-top: 32px;
	color: #108ee9;
}
.demo-header-brief{
	text-align: center;
	color: #888;
	font-size: 18px;
	padding-bottom: 32px;
	font-weight: 300;
}
.demo-search .demo-type-title{
	font-weight: 300;
}
.demo-search .demo-type-title,
.demo-notice .demo-type-title{
	color: #888;
	font-size: 13px;
	padding: 60px 15px 9px;
	display: inline-block;
	width: 100%;
	box-sizing: border-box;
}
.demo-popmenu .demo-type-title,
.demo-dialog .demo-type-title,
.demo-page-result .demo-type-title,
.demo-toast .demo-type-title,
.demo-loading .demo-type-title{
	margin-top: 0px;
	font-size: 15px;
	padding: 11px 15px;
	background-color: #3a3a3a;
	color: #fff;
	text-align: center;
	position: relative;
}
.demo-loading .demo-type-title{
	margin-top: 0;
}
.demo-popmenu .demo-type-title i.dot{
	position: absolute;
	right: 15px;
	top: 0px;
	font-size: 24px;
	line-height: 30px;
}
.demo-popmenu .demo-content{
	position: relative;
	 /* min-height: 100%;  */
}
.demo-popmenu .am-popmenu-mask{
	position: absolute;
}



.swiper-slide{
	height: auto;
	position: static;
	display: block;

}

@media only screen and (min-width: 800px) {
	.widget-list .widget-item{
		width: 33%;
	}
}
</style>
    <body>
    <div class="demo demo-popmenu" style="background:#E0EEEE">
		<div class="demo-type-title">消费管理系统<i class="dot" id="life" >...</i></div>
		<div class="demo-content">
			<!-- <div class="am-popmenu-mask show"></div> -->
			<div class="am-popmenu" id="life-menu" style="display:none">
				<a class="am-popmenu-item" href="<%=path %>/page/addConsumeDetail">
					<div class="am-popmenu-content">添加账单</div>
				</a>
				<a class="am-popmenu-item" href="<%=path%>/page/index">
					<div class="am-popmenu-content">查看账单</div>
				</a>
				<a class="am-popmenu-item " href="<%=path%>/page/showMessage">
					<div class="am-popmenu-content">我的消息<span class="am-bubble two-num" id="messageNum">25</span></div>
				</a>
				<%-- <a class="am-popmenu-item " href="<%=path%>/page/login">
					<div class="am-popmenu-content">登录界面</div>
				</a> --%>
				<a class="am-popmenu-item" href="<%=path%>/page/userAccountInfo">
					<div class="am-popmenu-content">个人信息</div>
					
				</a>
				<a class="am-popmenu-item" href="<%=path%>/page/modifyPassword">
					<div class="am-popmenu-content">修改密码</div>
				</a>
				<a class="am-popmenu-item " href="<%=path%>/logoutAccount">
					<div class="am-popmenu-content">退出</div>
				</a>
			</div>
		</div>
	</div>
    <div class="demo-content" align="center">
  <div class="am-list form">
    <div class="am-list-header">个人信息</div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">用户名</div>
      <div class="am-list-control">
        <input type="text" placeholder="用户名" id="username" value="">
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">用户昵称 </div>
      <div class="am-list-control">
        <input type="text" placeholder="用户昵称 "   id="virtualName" value="">
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">真实姓名</div>
      <div class="am-list-control">
        <input type="text" placeholder="真实姓名"   id="realName"  value="">
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">手机号码</div>
      <div class="am-list-control">
        <input type="text" placeholder="手机号码"    id="phone"  value="">
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">电子邮箱</div>
      <div class="am-list-control">
        <input type="text" placeholder="电子邮箱"  id="email" >
      </div>
    </div>
    
  </div></div>
  <div class="demo-content" style="margin: 0 15px 60px;">
			<button type="button" id="update" name="remove" class="am-button blue">修改个人信息</button>
			 <div style="height: 5px;"></div>
			<button type="button" id="back" class="am-button blue">返回</button>
		</div>
<!-- <div class="demo-content">

  <div class="demo-mobile">
    <div class="am-dialog image show">
      <div class="am-dialog-wrap">
        <div class="am-dialog-header">
          <h3>标题文字</h3>
        </div>
        <div class="am-dialog-img">
          <img src="https://zos.alipayobjects.com/rmsportal/MerSoqDoDahCExq.png">
        </div>
        <div class="am-dialog-body">
          <p class="am-dialog-brief">辅助说明文字辅助说明文字辅助说明文字辅助说明文字</p>
        </div>
        <div class="am-dialog-footer">
          <a class="am-button blue" style="display:block;">行动按钮</a>
        </div>
        <a class="am-dialog-close"></a>
      </div>
    </div>
  </div>
</div> -->
		
  <div class="demo-mobile ">
    <div class="am-dialog " id="info">
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
	 $("#life").click(function(){
			$("#life-menu").toggle();
		});
	 $("#back").click(function(){
		 window.history.back(-1);
	 });
	 init();
	 $("#update").click(function(){
			  if(check()){
				 $.post("<%=path%>/modifyAccountDetail",{
					 username:$.trim($("#username").val()),
					 virtualname:$.trim($("#virtualName").val()),
					 realname:$.trim($("#realName").val()),
					 cellphone:$.trim($("#phone").val()),
					 email:$.trim($("#email").val())
				 },function(data){
					 if(data=="success"){
						 alert("修改成功");
						/*  $("#errorInfo").html("修改成功");
						 showErrorInfo(); */
						 location.href="<%=path%>/page/userAccountInfo";
					 }else{
						 location.href="<%=path%>/page/error";
					 }
				 });
			 } 
	 });
		
	 
	 $("#hideButton").click(function(){
		 hideErrorInfo();
	 });
	 getMessageNum();
	 
 });
 function getMessageNum(){
		$.post("<%=path%>/message/getMessage",{
			status:1
		},function(data){
			if(data!=null&&data.length>0){
				 if(data.length>99){
					$("#messageNum").html("99+");
				 }else{
					$("#messageNum").html(data.length);
				}
			}else{
				$("#messageNum").remove();
				$("#messageNum").html("");
			}
		});
	}
 function init(){
	 $.post("<%=path%>/showAccountDetailInfo",
			 function(data){
		 $("#username").val(data.username);
		 $("#virtualName").val(data.virtualname);
		 $("#realName").val(data.realname);
		 $("#phone").val(data.cellphone);
		 $("#email").val(data.email);
	 });
 }
 
 function removeDisable(){
	 $(":text").each(function(){
		 $(this).removeAttr("disabled")
	 });
 }
 
 function showErrorInfo(){
	 $("#info").addClass("show");
 }
 
 function hideErrorInfo(){
	 $("#info").removeClass("show");
 }
 
 function check(){
	var  username=$.trim($("#username").val());
	 var virtualname=$.trim($("#virtualName").val());
	 var realname=$.trim($("#realName").val());
	 var cellphone=$.trim($("#phone").val());
	 var email=$.trim($("#email").val());
	 if(username==""){
		 $("#errorInfo").html("请填写用户名");
		 showErrorInfo();
		 return false;
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