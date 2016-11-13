<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <% String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <title>新增消费</title>
        <link rel="stylesheet" href="<%=path %>/css/antui.min.css"/>
        <!-- <link rel="stylesheet" href="path/to/antui/dist/widget/list.min.css"/> -->
        <script src="<%=path %>/js/antui.min.js"></script>
        <script src="<%=path %>/js/jquery.js"></script>
        <link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path %>/js/date.js" ></script>
		<script type="text/javascript" src="<%=path %>/js/iscroll.js" ></script>
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
				<a class="am-popmenu-item" href="<%=path%>/page/main">
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
  <div class="am-list form">
    <div class="am-list-header">消费种类</div>
    <div class="am-list-body">
      <div class="am-list-item select">
        <div class="am-list-content">
          <select id="type">
            <option value="1">餐饮费</option>
            <option value="2">水电费</option> 
          </select>
        </div>
        <div class="am-list-arrow"><span class="am-icon arrow vertical"></span></div>
      </div>
    </div>
  
</div>
  <div class="am-list form">
   <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">消费日期:</div>
      <div class="am-list-control">
      <input id="date" class="kbtn" type="text" placeholder="输入消费日期" />
      <!--   <input type="text" placeholder="输入消费日期" id="date" value=""> -->
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">付款人:</div>
      <div class="am-list-control">
        <input type="text" placeholder="输入付款人" id="pay" disabled="disabled" value="">
      </div>
    </div>
    <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">付款金额:</div>
      <div class="am-list-control">
        <input type="text" placeholder="输入付款金额" id="money" value="">
      </div>
    </div>
     <div class="am-list-item am-input-autoclear">
      <div class="am-list-label">消费描述:</div>
      <div class="am-list-control">
        <input type="text" placeholder="输入消费描述" id="desc" value="">
      </div>
    </div>
     <div class="am-list">
      <div class="am-list-header">参与人</div>
  </div>
  <div id="share">
  
  
  </div>
   <!-- <div class="am-checkbox mini argument">
      <input id="agree1" type="checkbox"  checked="checked">
      <span class="icon-check"></span>
      <label for="agree1">刘海龙</label><a  href="" target="_blank"></a>
    </div>
     <div class="am-checkbox mini argument">
      <input id="agree2" type="checkbox">
      <span class="icon-check"></span>
      <label for="agree2">卢林华</label><a  href="" target="_blank"></a>
    </div>
     <div class="am-checkbox mini argument">
      <input id="agree3" type="checkbox">
      <span class="icon-check"></span>
      <label for="agree3">胡胜强</label><a  href="" target="_blank"></a>
    </div> -->
  </div>
   <div class="demo-content" style="margin: 0 15px 60px;">
      <button type="button" id="save" class="am-button blue">保存</button>
    </div>
  
  <div id="datePlugin"></div>
	<script type="text/javascript">
	$(function(){
		$.post("<%=path%>/consumeDetail/initConsumeDetail",
				function(data){
			if(data!=null){
				var pay=data.payPeople;
				$("#pay").val(pay);
				var sharePeople=data.share;
				for(var i=0;i<sharePeople.length;i++){
					createSharePeople(sharePeople[i].name,sharePeople[i].id);
					if(pay==sharePeople[i].name){
						$("#"+sharePeople[i].id).attr({"checked":"checked"});
						
					}
				}
			}
			
		});
		$("#life").click(function(){
			$("#life-menu").toggle();
		});
		getMessageNum();
		
		$("#save").click(function(){
			var date=$.trim($("#date").val()).replace(/\-/g, "/");
			  if(check()){
				$.post("<%=path%>/consumeDetail/addConsumeDetail",{
					date:date,
					money:$.trim($("#money").val()),
					comment:$.trim($("#desc").val()),
					type:$.trim($("#type option:selected").attr("value")),
					shareIds:getShare().toString()
				},function(data){
					if(data=="success"){
						alert("保存成功");
						location.href="<%=path%>/page/addConsumeDetailSuccess";
					}else{
						alert("保存失败");
						location.href="<%=path%>/page/error";
					}
				});
			}  
		});
		$('#date').date({theme:"datetime"});
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
	
	function check(){
		var date=$("#date").val();
		var money=$.trim($("#money").val());
		var desc=$("#desc").val();
		if(date==""){
			alert("请输入消费日期");
			return false;
		}
		if(money==""){
			alert("请输入消费钱数");
			return false;
		}else{
			var rege=new RegExp("^[0-9]+(.[0-9]{2})?$");
			if(!rege.test(money)){
				alert("请输入正确的金额");
				return false;
			}else if(parseFloat(money)>10000){
				alert("金额不能超过10000");
				return false;
			}
		}
		if(desc==""){
			alert("请输入消费描述");
			return false;
		}
		if($("input:checked").length==0){
			alert("请选择参与人");
			return false;
		}
		return true;
	}
	function getShare(){
		var array=new Array();
		$("input:checked").each(function(){
			array.push($(this).attr("id"));
		});
		return array;
	}
	function createSharePeople(name,id){
		var div="<div class='am-checkbox mini argument'><input id='"+id+"' type='checkbox' >"
		+"<span class='icon-check'></span><label for='"+id+"'>"+name+"</label><a  href='' target='_blank'></a></div>";
		$("#share").append(div);
	}
	
	function checkMoney(){
		
		return true;
	}
	</script>

    </body>
</html>