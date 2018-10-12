<%-- 
    Document   : accueil
    Created on : 10-Oct-2018, 16:30:36
    Author     : Valentin Lecouple & Yann Toqué
--%>

<%@page import="beans.BankBranch"%>
<%@page import="beans.Client"%>
<%@page import="beans.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div id="recherche">
            <form id="rechercheForm" action="findServlet">
                <select id="rechercheClass" name="rechercheClass">
                    <option value="ServiceAccount" selected>Account</option> 
                    <option value="ServiceBankBranch">BankBranch</option>
                    <option value="ServiceClient">Client</option>
                </select>
                <input type="text" id="recherchePk" name="recherchePk" /> 
                <button type="submit"> Rechercher </button>
            </form>
        </div>
      
      
        <%
            
        
        if(request.getAttribute("lastSearchResult") != null)
        {
          Object lastSearchResult = (Object) request.getAttribute("lastSearchResult");
          if(lastSearchResult instanceof Account){%>
            <div>
                Account number: ${lastSearchResult.accountNumber} <br>
                Label: ${lastSearchResult.label} <br>
                IBAN: ${lastSearchResult.IBAN} <br>
                Bankbranch code: ${lastSearchResult.bankBranch.code} <br>
                Total money: ${lastSearchResult.totalMoney} <br>
                <a href="deleteServlet?deleteClass=ServiceAccount&deletePk=${lastSearchResult.accountNumber}">Delete</a>
            </div>
          <%
          }
          else if(lastSearchResult instanceof Client){%>
          <div>
                Client number : ${lastSearchResult.clientNumber}
                Lastname : ${lastSearchResult.lastName}
                Firstname : ${lastSearchResult.firstName}
                Date of birth : ${lastSearchResult.birthDate}
                <a href="deleteServlet?deleteClass=ServiceClient&deletePk=${lastSearchResult.clientNumber}">Delete</a>
            </div>
          <%
          }
          else if(lastSearchResult instanceof BankBranch){%>
            <div>
                Code: ${lastSearchResult.code} <br>
                Address: ${lastSearchResult.address} <br>
                <a href="deleteServlet?deleteClass=ServiceBankBranch&deletePk=${lastSearchResult.code}">Delete</a>
            </div>
          <%
          }
          else{%>
            <div>
                ${lastSearchResult}
            </div>
          <%
          }
        }
        %>
        
        
        
    </body>
</html>
