<%@page import="java76.pms.domain.Product"%>
<%@page import="java76.pms.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<link rel="stylesheet" type="text/css" href="../css/chartStyle.css" />

<h4>판매 현황</h4>
<hr>
<br>
<h5>연간 판매 총액</h5>
<table id="hor-minimalist-b" summary="Employee Pay Sheet" border="0">
  <tr>
    <c:forEach var="chart" items="${charts}">
      <th scope="col" width="80px">${chart.m}년</th>
    </c:forEach>
  </tr>
  <tr>
    <c:forEach var="chart" items="${charts}">
      <td>${chart.s} 원</td>
    </c:forEach>
  </tr>
</table>

<hr>

<h5>판매 내용</h5>
<table id="hor-minimalist-b" summary="Employee Pay Sheet" border="0">
  <thead>
    <tr>
      <th scope="col" width="130px">판매일</th>
      <th scope="col" width="100px">이름</th>
      <th scope="col" width="150px">이메일</th>
      <th scope="col" width="200px">상품명</th>
      <th scope="col" width="100px">총액</th>
    </tr>
  </thead>
  
  <tbody>
    <c:forEach var="purchase" items="${purchases}">
     
     <form action="update.do" method="post" >
       <tr>
         <td>${purchase.bDate}</td>
         <td>${purchase.buname}</td>
         <td>${purchase.buemail}</td>
         <td>${purchase.bpname}</td>
         <td align="right">${purchase.bpsum} 원</td>
       </tr>
    </form>
    
    </c:forEach>
  </tbody>

</table>

