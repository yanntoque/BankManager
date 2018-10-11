<%-- 
    Document   : accueil
    Created on : 10-Oct-2018, 16:30:36
    Author     : Valentin Lecouple & Yann Toqué
--%>

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
                %{lastSearchResult.accountNumber}
            </div>
          <%
          }
          else if(lastSearchResult instanceof Client){%>
          
          <%
          }
          else if(lastSearchResult instanceof BankBranch){%>
          
          <%
          }
          else{%>
          
          <%
          }
        }
        %>
        
        
        
    </body>
</html>
