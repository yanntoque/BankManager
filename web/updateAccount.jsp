<%-- 
    Document   : updateClient
    Created on : 14-Oct-2018, 14:49:16
    Author     : Valentin Lecouple & Yann Toqué
--%>

<%@page import="java.util.List"%>
<%@page import="beans.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Account Page</title>
    </head>
    <body>
        <%List<Account> accountList = (List<Account>) request.getAttribute("accountList");%>
        <h1>Mise à jour des données d'un compte</h1>
        <form id="updateForm" action="updateAccountServlet?action=updateAccount">
            <label>Compte à modifier :</label><select name="accountNumber">
                <%  for (Account account : accountList) {%>
                <option value="<%=account.getAccountNumber()%>">Account Number : <%=account.getAccountNumber()%> | Label : <%=client.getLabel()%> | IBAN : <%=client.getIBAN()%> | Total Money : <%=client.getTotalMoney()%></option>
                <%}
                %>
            </select>
            <br>
            <label>Nouveau Label :</label><input type="text" name="accountLabel" /> 
            <label>Nouvel IBAN :</label><input type="text" name="accountIBAN" /> 
            <label>Nouvelle somme d'argent :</label><input type="text" name="accountTotalMoney" /> 
            <input type="submit" value="Valider">
        </form>
    </body>
</html>