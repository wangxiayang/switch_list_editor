<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="me.horzwxy.server.fileserver.model.Rule" %>
<% 
	List<Rule> ruleList = (List<Rule>)request.getAttribute("rules");
%>
<html>
	<head>
		<title>rule list editor</title>
		<script type="text/javascript">
			function addrule() {
				var ruleContent = document.getElementById("ruleInput").value;
				
				var xmlhttp = new XMLHttpRequest();
				xmlhttp.onreadystatechange=function() {
					if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				    	alert(xmlhttp.responseText);
				    	location.reload();
				    }
				}
				xmlhttp.open("GET","/addrule?rule=" + escape(ruleContent),true);
				xmlhttp.send();
			}
			
			function removerule(id) {
				var xmlhttp = new XMLHttpRequest();
				xmlhttp.onreadystatechange=function() {
					if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				    	alert(xmlhttp.responseText);
				    	location.reload();
				    }
				}
				xmlhttp.open("GET","/removerule?ruleId=" + id,true);
				xmlhttp.send();
			}
		</script>
	</head>
	<body>
		<div>
			<p>rules:</p>
			<% for(int i = 0; i < ruleList.size(); i++) { %>
				<p>
					<span><%=i + 1 %>:&nbsp;</span>
					<span><%=ruleList.get(i).content %></span>
					<span><a onclick="removerule(<%=ruleList.get(i).id%>)" href="javascript:void(0)">X</a></span>
				</p>
			<% } %>
		</div>
		<div>
			<input id="ruleInput" type="text" name="rule"/>
			<input type="button" value="add rule" onclick="addrule()"/>
		</div>
	</body>
</html>