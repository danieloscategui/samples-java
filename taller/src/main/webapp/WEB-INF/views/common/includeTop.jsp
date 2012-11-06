<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Here include CSS -->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Transrowi S.A.</title>
<link href="<c:url value="/resources/estilo.css" />" rel="stylesheet"  type="text/css" />	
</head>
<body>
<div id="Header">
  <p>SISTEMA DE GESTI&Oacute;N TALLER MEC&Aacute;NICO</p>
</div>
<div id ="QuickLink">
	<a href="<c:url value="/" />">Home</a> | 
	<a href="<c:url value="/catalogo/grupoList" />">Catalogo</a> | 
	<a href="<c:url value="/almacen/createNuevoPedido" />">Crear nuevo pedido almacen</a> |
	<a href="<c:url value="/almacen/listarPedidoAlmacenPendientes" />">Ver Pedidos Pendientes</a> |  
	 
</div>
<div id="Content">
