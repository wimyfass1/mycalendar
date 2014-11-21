<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>
<!-- css 외부 참조 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/styles.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/hanna.css">
</head>
<body>
	<h1>각 배열 내의 속성</h1>
	<h2>calendarUser</h2>
	<table width="70%" cellpadding="5" cellspacing="0" border="1" align="center" style="border-collapse:collapse; border:1px gray solid;text-align:center">
		<tr>
			<td>No.</td>
			<td>ID</td>
			<td>EMAIL</td>
			<td>PASSWORD</td>
			<td>NAME</td>
		</tr>

		<!-- item 이름은 addAttribute에 넣어준 이름으로! -->
		<c:forEach var="calendarUsers" items="${calendarUsers}"
			varStatus="status">
			<tr>
				<td align="center" class="calendarusers"><c:out
						value="${status.count}" /></td>
				<td align="center" class="listtd"><c:out
						value="${calendarUsers.id}" /></td>
				<td align="center" class="listtd"><c:out
						value="${calendarUsers.email}" /></td>
				<td align="center" class="listtd"><c:out
						value="${calendarUsers.password}" /></td>
				<td align="center" class="listtd"><c:out
						value="${calendarUsers.name}" /></td>
			</tr>

		</c:forEach>
	</table>
	<h2>event</h2>
	<table width="70%" cellpadding="5" cellspacing="0" border="1" align="center" style="border-collapse:collapse; border:1px gray solid;text-align:center">
		<tr>
			<td>No.</td>
			<td>ID</td>
			<td>SUMMARY</td>
			<td>DESCRIPTION</td>
			<td>OWNER</td>
			<td>NUM_LIKE</td>
			<td>ENEN_TLEVEL</td>
		</tr>
		<c:forEach var="events" items="${events}" varStatus="status">
			<tr>
				<td align="center" class="events"><c:out
						value="${status.count}" /></td>
				<td align="center" class="listtd"><c:out value="${events.id}" /></td>
				<td align="center" class="listtd"><c:out
						value="${events.summary}" /></td>
				<td align="center" class="listtd"><c:out
						value="${events.description}" /></td>
				<td align="center" class="listtd"><c:out
						value="${events.owner.id}" /></td>
				<td align="center" class="listtd"><c:out
						value="${events.numLikes}" /></td>
				<td align="center" class="listtd"><c:out
						value="${events.eventLevel}" /></td>
			</tr>
		</c:forEach>
	</table>
	<h2>eventAttentee</h2>
	<table width="70%" cellpadding="5" cellspacing="0" border="1" align="center" style="border-collapse:collapse; border:1px gray solid; text-align:center" >
		<tr>
			<td>No.</td>
			<td>ID</td>
			<td>EVENT_ID</td>
			<td>ATTENDEE_ID</td>
		</tr>
		<c:forEach var="eventAttentees" items="${eventAttentees}"
			varStatus="status">
			<tr>
				<td align="center" class="eventattentees"><c:out
						value="${status.count}" /></td>
				<td align="center" class="listtd"><c:out
						value="${eventAttentees.id}" /></td>
				<td align="center" class="listtd"><c:out
						value="${eventAttentees.event.id}" /></td>
				<td align="center" class="listtd"><c:out
						value="${eventAttentees.attendee.id}" /></td>
			</tr>

		</c:forEach>
	</table>
</body>

</html>
