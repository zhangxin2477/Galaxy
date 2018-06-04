$(document).ready(function() {
    $('#login').click(function () {
        login();
    });
});

function login() {
    $.ajax({
        url:'http://localhost:8080/login',
        type:'POST',
        contentType:'application/json;charset=utf-8',
        dataType:'test',
        data:JSON.stringify({'name':$('#name').val(),'password':$('#password').val()}),
        success:function(data){
            alert(data.toString());
        },
        error:function(msg){
            console.log("Error:"+msg);
        }
    });
}