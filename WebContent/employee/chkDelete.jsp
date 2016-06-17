<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href=<html:rewrite page="/css/stylesheet.css"/> type="text/css"/>
 <script type="text/javascript" src="<html:rewrite page="/js/inputCheck.js"/>" ></script>

<title>社員管理システム</title>
</head>
<body>

<div id="contents">
		<div id="header">
			<h1>社員削除画面</h1>


			<p>あなたのIDは${id}です</p>

			<html:link action="/logout">
                     ログアウト
            </html:link>



			<div id="menu">
			</div>
		</div>
			<div id="container">
					<div id="main">



			<!-- 削除内容Check ↓-->

				<html:form method="POST" action="/delete.do" onsubmit="return changeCheck()">

									<p>社員名: ${userEmpDto.empName}</p>
									<p>パスワード: ${userEmpDto.empPass}</p>
									<p>性別: ${userEmpDto.genderName}<p>
									<p>住所: ${userEmpDto.address}<p>
									<p>生年月日:${userEmpDto.birthday}<p>
									<p>権限: ${userEmpDto.authorityName}<p>
									<p>部署名: ${userEmpDto.deptName}<p>

					<html:submit property="method" value='OK'>
							<html:hidden property="userEmpDto" />
                            <bean:message key="button.delete.finish"/>
                    </html:submit>


				</html:form>

			<!-- 登録内容Check ↑-->


					</div>
			</div>
		<div id="footer">
		</div>
</div>


</body>
</html>