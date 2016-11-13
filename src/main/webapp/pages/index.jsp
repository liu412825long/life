<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <title>消费管理</title>
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
				<a class="am-popmenu-item" href="<%=path%>/page/main">
					<div class="am-popmenu-content">查看账单</div>
				</a>
				<a class="am-popmenu-item " href="<%=path%>/page/showMessage">
					<div class="am-popmenu-content">我的消息<span class="am-bubble two-num" id="messageNum"></span></div>
				</a>
				<a class="am-popmenu-item " href="<%=path%>/page/showStatistics">
					<div class="am-popmenu-content">统计管理</div>
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
<div class="am-list">
    <div class="am-list-header">消费列表</div>
    <div class="am-list-body">
      	<div class="am-list twoline" id="show">
   
 	 	</div>
    
    
   </div>
</div>
<input type="hidden" id="currentPage" value="1" />
<input type="hidden" id="totalPage" value="1" />
 <button type="button" class="am-button blue" id="next">下一页</button>
  
	<script type="text/javascript">
	$(function(){
		$("#life").click(function(){
			$("#life-menu").toggle();
		});
		getList(1);
		getMessageNum();
		$("#next").click(function(){
			var currentPage=parseInt($("#currentPage").val());
			getList(currentPage);
		});
		
	});
	
	function showButton(){
		var currentPage=parseInt($("#currentPage").val());
		var totalPage=parseInt($("#totalPage").val());
		//alert(currentPage+"..."+totalPage);
		if(currentPage!=null&&totalPage!=null){
			if(currentPage<totalPage){
				currentPage=currentPage+1;
				$("#currentPage").val(currentPage);
				$("#next").html("下一页");
				$("#next").removeAttr("disabled");
			}else if(currentPage==totalPage){
				$("#currentPage").val(totalPage);
				$("#next").html("没有数据了");
				$("#next").attr("disabled","disabled");
			}
		}
	}
	
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
	
	function getList(current){
		//var current=$("#currentPage").val();
		$.post("<%=path%>/consumeDetail/queryAllConsumeDetail",{
			currentPage:current
		},function(data){
			//alert(data.length);
			if(data!=null){
				var list=data.list;
				for(var i=0;i<list.length;i++){
					var detail=list[i];
					var pic="";
					if(detail.paied==15){
						pic="liu.jpg";
					}else if(detail.paied==16){
						pic="lu.jpg";
					}else{
						pic="hu.jpg";
					}
					var href="<%=path%>/page/showConsumeDetail?id="+detail.id;
					createDiv(href,pic,detail.payName,detail.count,detail.showDate,detail.money);
				$("#currentPage").val(data.currentPage);
				$("#totalPage").val(data.totalPage);
					showButton();
				}
			}
		});
	}
	
	function createDiv(href,pic,name,shareCount,dateTime,money){
		//../img/people.jpg
		var createA="<a href='"+href+"' class='am-list-item'><div class='am-list-thumb'>"+
		"<img src='../img/"+pic+"' alt=''></div><div class='am-list-content'><div class='am-list-title twocolumn'>"+
		"<label>"+name+"</label><div class='am-list-right-brief'>人数: "+shareCount+"</div></div><div class='am-list-brief twocolumn'>"+
		"<label>"+dateTime+"</label><div class='am-list-right-brief'>"+money+"元</div></div></div><div class='am-list-arrow'>"+
		"<span class='am-icon arrow horizontal'></span></div></a>";
		$("#show").append(createA);
	}
	
	
	</script>

    </body>
</html>