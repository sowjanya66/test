function deleteUser(id){
	//alert(id)
		$.ajax({
	             url:'/user/'+ id,
	                type:'delete',  
	                accept: "application/json",
	                success:function(response){	
	                	
	                myfunc();
	                }    		
	  		}); 
}

function editUser(id,firstname,lastname, email){
	
	console.log(firstname);
	 $('#pid').val(id);
	 $('#pfirstname').val(firstname);
	 $('#plastname').val(lastname);
	 $('#pemail').val(email);
    $('#screen, #modal').show();
    
	

}
function myfunc()
{
	var itemid ;
	$('#records_table').empty();
	$("#success").show();
	 $("#failure").hide();
	 $("#form").hide();
	 $('#records_table').show();
	 
	 $.ajax({
        url:'http://localhost:8080/users',
        type:'get',
       
       contentType: "application/json",
          headers: {          
            Accept: "application/json"       

          } , 
        success:function(response){
       	 var trHTML = '';
       	trHTML +='<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email</th> <th>DeleteAction</th><th>EditAction</th></tr>'
            $.each(response, function (i, item) {
            	 itemid = item.id;
                trHTML += '<tr ><td id="userid">' + item.id + '</td><td>' + item.firstname + '</td><td>' + item.lastname + 
                '</td><td>' + item.email + '</td>' +
                '<td><input type="button"  value="Edit" id= "btnedit" onclick =" javascript:editUser(' + item.id +',\'' + item.firstname +'\',\'' + item.lastname +'\',\'' + item.email + '\');" ></td>' +
                '<td><input type="button"  value="Delete" onclick ="javascript:deleteUser(' + item.id +');" ></td></tr> ';
            });
            $('#records_table').append(trHTML);
        }  
          
          
    });
} 

$(document).ready(function(){
	
	
	$('#screen, #modal button').click(function(){
	    $('#screen, #modal').hide();
	});
	
	 $("#logout").click(function(){
		   $("#success").hide();
		   $("#failure").hide();
		   $('#records_table').hide();
		   $('#email').val('');
		   $('#password').val('');	
		   $("#form").show();
	});
	
	 $("#success").hide();
	 $("#failure").hide();
	 $("#form").show();
	 $('#records_table').hide();
	 
	   	
    $("#login").click(function(){
        var email = $("#email").val().trim();
        var password = $("#password").val().trim();
      
        if( email != "" && password != "" ){
        	var dict = {'email':email,'password':password};
        	$.ajax({
                url:'/login',
                type:'post',
                dataType: "json",                            
                contentType: "application/json",
                accept: "application/json",
                data:JSON.stringify(dict) ,
                success:function(response){
                	if(response.status == true){
                    	myfunc();
                    	
                    	               	 
	                }else{
	                   	 $("#success").hide();
	                	 $("#failure").show();
	                	 $("#form").show();
	                 }
                    
                }
            });
        }
        
    });
    

});
   