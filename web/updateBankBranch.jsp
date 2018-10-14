<%-- 
    Document   : updateBankBranch
    Created on : 14 oct. 2018, 02:45:30
    Author     : Valentin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update BankBranch Page</title>
    </head>
    <body>
        
        <%ArrayList<BankBranch> bankBranchList = (ArrayList<BankBranch>)request.getAttribute("bankBranchList")%>
        
        <h1>Mise à jour de l'adresse d'une BankBranch</h1>
        <form id="updateForm" action="updateBankBranchServlet?action=updateBankBranch">
            <label>BankBranch à modifier :</label><select name="bankBranchCode">
                <%
                    for(BankBranch bankBranch: bankBranchList){%>
                        <option value="<%=bankBranch.code%>">Code: <%=bankBranch.code%> | Adresse: <%=bankBranch.address%></option>
                    <%}
                %>
            </select>
            <label>Nouvelle addresse :</label><input type="text" name="bankBranchNewAddress" /> 
            <button type="submit">Valider</button>
        </form>
    </body>
</html>
