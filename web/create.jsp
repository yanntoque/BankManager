<%-- 
    Document   : create
    Created on : 12-Oct-2018, 16:39:53
    Author     : Valentin Lecouple & Yann Toqué
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="resources/script.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div class="form-group">
                <select id="selectService" class="form-control" name="rechercheClass">
                    <option selected disabled>Choisir un élément</option>
                    <option value="ServiceAccount" >Account</option> 
                    <option value="ServiceBankBranch">BankBranch</option>
                    <option value="ServiceClient">Client</option>
                </select>
                <br>
                <input id="create" class="center-block btn btn-info" type="submit" value="Afficher le formulaire de création">
            </div>

            <form hidden id="formCreateAccount" action="createAccountServlet">
                <div class="form-group">
                    <h2>Account Creation</h2><br>
                    <label>Account number :</label> <input class="form-control" maxlength="11" type="text" name="accountNumber" required /><br>
                    <label>Label :</label> <input class="form-control" type="text" name="accountLabel" required /><br>
                    <label>IBAN :</label> <input class="form-control" maxlength="27" type="text" name="accountIBAN" required /><br>
                    <label>Bankbranch code :</label> <input class="form-control" type="text" name="accountBankBranchCode" required /><br>
                    <label>Total Money :</label> <input class="form-control" type="number" step="any" name="accountTotalMoney" required /><br>
                    <input id="update" class="center-block btn btn-lg btn-info center" name="createAccount" type="submit" value="Créer">
                </div>
            </form>

            <form hidden id="formCreateClient" action="createClientServlet">
                <div class="form-group">
                    <h2>Client Creation</h2><br>
                    <label>Client Number :</label> <input class="form-control" maxlength="8"  type="text" name="clientNumber" required /><br>
                    <label>Firstname :</label> <input class="form-control" type="text" name="clientFirstname" required /><br>
                    <label>Lastname :</label> <input class="form-control" type="text" name="clientLastname" required /><br>
                    <label>Date of birth :</label> <input class="form-control" type="text" name="clientDate" required /><br>
                    <input class="center-block btn btn-lg btn-info center" name="createClient" type="submit" value="Créer">
                </div>
            </form>

            <form hidden id="formCreateBankBranch" action="createBankBranchServlet">
                <div class="form-group">
                    <h2>BankBranch Creation</h2><br>
                    <label>Code :</label> <input class="form-control" maxlength="5" type="text" name="bankBranchCode" required /><br>
                    <label>Address :</label> <input class="form-control" type="text"name="bankBranchAdress"  required /><br>
                    <input class="center-block btn btn-lg btn-info center" name="createBankBranch" type="submit" value="Créer">
                </div>
            </form>
        </div>
    </body>
</html>
