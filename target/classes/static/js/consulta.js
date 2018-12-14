
$(document).ready(function() {

    $("#consulta").on("keyup", function() {

        var text = $(this).val();
          $.ajax({
            type : 'POST',
            url : 'consulta',
            dataType: 'json',
            data: {texto: text},
            success: function(data){
                var res = $.parseJSON(data);
                console.log(data);
            },
            error:function(x,y,z){
                console.log("Error!!");
            }
            });
     });
});