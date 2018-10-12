/*
 * @author Valentin Lecouple
 * @author Yann Toqué
 */
$(document).ready(function () {
    $('select').on('change', function () {
        var selectedValue = this.value;
        switch (selectedValue) {
            case "ServiceBankBranch":
                $("#create").click(function () {
                    $("#formCreateAccount").hide();
                    $("#formCreateClient").hide();
                    $("#formCreateBankBranch").show();
                });
                break;
            case "ServiceClient":
                $("#create").click(function () {
                    $("#formCreateBankBranch").hide();
                    $("#formCreateAccount").hide();
                    $("#formCreateClient").show();
                });
                break;
            case "ServiceAccount":
                $("#create").click(function () {
                    $("#formCreateBankBranch").hide();
                    $("#formCreateClient").hide();
                    $("#formCreateAccount").show();
                });
                break;
        }
    });
});