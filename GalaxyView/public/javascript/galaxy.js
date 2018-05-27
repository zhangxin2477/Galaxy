var $=require('jquery')

$('#login').click(function(){
    login();
});

function login() {
    var url='http://localhost:8080/login';
    var userData='{"name":"'+$('#name').val()+'","password":"'+$('#password').val()+'"}';
    $.ajax({
        type:'POST',
        contentType:'application/json',
        url:url,
        dataType:'json',
        data:userData,
        success:function(data){
            alert(data.toString());
        },
        error:function(){
            alert("Error");
        }
    });
}