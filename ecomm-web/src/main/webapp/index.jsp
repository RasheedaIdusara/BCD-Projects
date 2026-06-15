<%@ page import="jakarta.ejb.EJB" %>
<%@ page import="lk.rasheeda.ecomm.user.remote.TestRemote" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/15/2026
  Time: 8:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
//    @EJB
//    private TestRemote testRemote;

%>

<h1>Index Page...</h1>

<%

    try{

        InitialContext ic = new InitialContext();
        TestRemote testRemote = (TestRemote) ic.lookup("java:global/ecomm-user-1.0/TestRemoteBean!lk.rasheeda.ecomm.user.remote.TestRemote");
        testRemote.test();

    }catch (NamingException e){
        e.printStackTrace();
    }


%>

</body>
</html>
