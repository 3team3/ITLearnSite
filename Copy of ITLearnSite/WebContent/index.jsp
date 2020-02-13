<%@page import="java.net.InetAddress"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	//response.sendRedirect("http://192.168.2.15:8090/ITLearnSite/index.do");
	InetAddress local = InetAddress.getLocalHost();
	response.sendRedirect(request.getScheme() +"://" + local.getHostAddress()+":"+request.getLocalPort() +request.getContextPath()+"/"+"index.do");
	System.out.println(request.getScheme() +"://" + local.getHostAddress()+":"+request.getLocalPort() +request.getContextPath()+"/"+"index.do");
%>
  
  
