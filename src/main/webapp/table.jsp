<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="static HelpMyself.Helper.getTable" %>
<html lang="ru">
<jsp:useBean id="results" scope="session" class="Model.Results"/>

<%if (!(results==null)) out.print(getTable(results)); %>
