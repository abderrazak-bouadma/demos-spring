<%--
  Created by IntelliJ IDEA.
  User: abderrazak
  Date: 09/01/15
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
      <div>
        <h1>Hello World !</h1>
      </div>

      <div id="data"></div>

      <script src="http://code.jquery.com/jquery-1.10.2.js"></script>

    <script>
        $(function(){
            $.getJSON("users",function(data){
                console.log(data);
            });
        });
    </script>
</body>
</html>
