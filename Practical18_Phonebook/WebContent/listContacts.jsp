<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Contacts1</title>
    </head>
    <body>
<%--        <s:if test="contacts.size() > 0">--%>
<%--        <s:if test="contacts != null && contacts.size() > 0">--%>


        <s:if test="contacts.empty">
            <h1>No contacts found</h1>
        </s:if>
        <s:if test="!contacts.empty">
            <table>
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Contact Number</th>
                    <th>Email ID</th>
                    <th>Actions</th>
                </tr>
                <!-- Assuming contacts is a list of Contact objects -->
                <s:iterator value="contacts">
                    <tr>
                        <td><s:property value="name"/></td>
                        <td><s:property value="address"/></td>
                        <td><s:property value="contactNumber"/></td>
                        <td><s:property value="emailId"/></td>
                        <td>
                            <a href="<s:url action='editContact'><s:param name='id' value='%{id}'/></s:url>">Edit</a> |
                            <a href="<s:url action='deleteContact'><s:param name='id' value='%{id}'/></s:url>">Delete</a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
        <a href="index.jsp"/>Add Contact</a>
    </body>
</html>