<%-- 
    Document   : updateBankBranch
    Created on : 14 oct. 2018, 02:45:30
    Author     : Valentin Lecouple & Yann Toqué
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.BankBranch"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update BankBranch Page</title>
    </head>
    <body>
        <%List<BankBranch> bankBranchList = (List<BankBranch>) request.getAttribute("bankBranchList");%>
        <h1>Mise à jour de l'adresse d'une BankBranch</h1>
        <form id="updateForm" action="updateBankBranchServlet?action=updateBankBranch">
            <label>BankBranch à modifier :</label><select name="bankBranchCode">
                <%  for (BankBranch bankBranch : bankBranchList) {%>
                <option value="<%=bankBranch.getCode()%>">Code: <%=bankBranch.getCode()%> | Adresse: <%=bankBranch.getAddress()%></option>
                <%}
                %>
            </select>
            <label>Nouvelle adresse :</label><input type="text" name="bankBranchNewAddress" /> 
            <input type="submit" value="Valide">
        </form>
    </body>
</html>
