<%-- 
    Document   : updateClient
    Created on : 14-Oct-2018, 14:49:16
    Author     : Valentin Lecouple & Yann Toqué
--%>

<%@page import="java.util.List"%>
<%@page import="beans.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Client Page</title>
    </head>
    <body>
        <%List<Client> clientList = (List<Client>) request.getAttribute("clientList");%>
        <h1>Mise à jour des données d'un Client</h1>
        <form id="updateForm" action="updateClientServlet?action=updateClient">
            <label>Client à modifier :</label><select name="clientNumber">
                <%  for (Client client : clientList) {%>
                <option value="<%=client.getClientNumber()%>">Client Number : <%=client.getClientNumber()%> | Lastname : <%=client.getLastName()%> | Firstname: <%=client.getFirstName()%> | Birthdate: <%=client.getBirthDate()%></option>
                <%}
                %>
            </select>
            <br>
            <label>Nouveau Prénom :</label><input type="text" name="clientNewFirstname" /> 
            <label>Nouveau Nom :</label><input type="text" name="clientNewLastname" /> 
            <label>Nouvelle Date de naissance :</label><input placeholder="28-06-1971" type="text" name="clientNewBirthdate" /> 
            <input type="submit" value="Valider">
        </form>
    </body>
</html>

