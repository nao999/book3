<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<%--    静态包含base标签、css样式、jQuery文件--%>
	<%@ include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<a href="pages/user/login.jsp">登录</a> |
				<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="" method="get">
					价格：<input id="min" type="text" name="min" value=""> 元 - 
						<input id="max" type="text" name="max" value=""> 元 
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有3件商品</span>
				<div>
					您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
				</div>
			</div>

			
			<c:forEach items="${requestScope.page.items}" var="book">

				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.imgPath}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">￥${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<button>加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<div id="page_nav">
			<!--大于首页才显示-->
			<c:if test="${requestScope.page.pageNo > 1}">
				<a href="client/bookServlet?action=page&pageNo=1">首页</a>
				<a href="client/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>
			<%--页码输出的开始--%>
			<%--情况1：如果总页码小于等于5的情况，页码的范围是:1-总页码--%>
			<c:choose>

				<c:when test="${requestScope.page.pageTotal <= 5}">
					<c:set var="begin" value="1"/>
					<c:set var="end"   value="${requestScope.page.pageTotal}"/>

				</c:when>
				<%--情况2：总页码大于5的情况，假设一共10页--%>
				<c:when test="${requestScope.page.pageTotal > 5}">
					<c:choose>
						<%--小情况1:当前页码为前面3个:1,2,3情况,页码范围是：1-5--%>
						<c:when test="${requestScope.page.pageNo <= 3}">
							<c:set var="begin" value="1"/>
							<c:set var="end"   value="5"/>
						</c:when>
						<%--小情况2：当前页码为最后3个，8,9,10,页码范围是:总页码-4	总页码--%>
						<c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
							<c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
							<c:set var="end"   value="${requestScope.page.pageTotal}"/>
						</c:when>
						<%--小情况3:4,5,6,7页码范围是:当前页码减2 - 当前页码加2--%>
						<c:otherwise>
							<c:set var="begin" value="${requestScope.page.pageNo-2}"/>
							<c:set var="end"   value="${requestScope.page.pageNo+2}"/>
						</c:otherwise>
					</c:choose>
				</c:when>

			</c:choose>

			<c:forEach begin="${begin}" end="${end}" var="i">
			<c:if test="${i==requestScope.page.pageNo}">
				【${i}】
			</c:if>
			<c:if test="${i!=requestScope.page.pageNo}">
			<a href="client/bookServlet?action=page&pageNo=${i}">${i}<a/>
				</c:if>
				</c:forEach>


				<%--如果已经是最后一页，则不显示下一页，末页--%>
				<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="client/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="client/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
				</c:if>
				共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
				到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
				<input id="searchPageBtn" type="button" value="确定">
				<script type="text/javascript">
					$(function () {
						//跳到指定页码
						$("#searchPageBtn").click(function () {
							var pageNo = $("#pn_input").val();

							var pageTotal = ${requestScope.page.pageTotal};

							//javascript语言提供了一个Location地址栏对象
							//它有一个属性ref,它可以获取浏览器地址栏中的地址
							//href可读可写还可以赋值
							location.href = "${pageScope.basePath}client/bookServlet?action=page&pageNo=" + pageNo;
						});
					});
				</script>
		</div>
	
	</div>
<%--	静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>