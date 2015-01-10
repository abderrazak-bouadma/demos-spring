<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
      <div>
        <h1>Hello World !</h1>
      </div>

      <div><ul id="data"></ul></div>

      <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="<c:url value="/js/handlebars-v2.0.0.js"/> "></script>


    <script>
        var TEMPLATES_SERVICE_URL = "tpl/";

        function loadRenderAndAttachTemplate(templateName, container, model) {
            $.get(TEMPLATES_SERVICE_URL+templateName, function(templateSource){
                var template = Handlebars.compile(templateSource);
                if (container==null)
                    throw new Error("The parent container to which compiled template attempted to be attached was null","");
                container.append(template(model));
            });
        }

        $(function(){
            // load data asynchronously
            $.getJSON("users",function(data){
                var container = $("#data");
                loadRenderAndAttachTemplate("users",container,data);
            });
        });
    </script>
</body>
</html>
