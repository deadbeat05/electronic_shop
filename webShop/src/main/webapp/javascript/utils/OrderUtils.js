$(document).ready(function () {
  var payment = $("input[name='paymentMethod']");
 
  payment.change(function () {
    var method = $(this).val();
	
    if (method == 'card') {
      $("#cardMethod").css("display", "block");
    } else {
      $("#cardMethod").css("display", "none");
    }
 });
});