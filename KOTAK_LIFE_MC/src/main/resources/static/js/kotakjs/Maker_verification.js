$(document).ready(function() {
    // alert("ajax loading");
	
    // $("#datatable").show();
    $("#formDiv").show();
    var trHTML = '';
    $(function() {
        $("#submitfdff").click(function() {
            // $("#formDiv").hide();
            //alert("formsubmitted");
            // alert($('#firstname').val());
            var jsonData = JSON.stringify($('#inputForm').serializeArray());
            // var data=$('#inputForm').serialize();
            // alert(jsonData);
            $("#datatable").show();

            // alert($('#inputForm').serialize());
            // var
            // jsonData=JSON.stringify($('#dedupeInputform').serializeArray());
            $.post({
                // type:"POST",
                // url:"process",
                // data:JSON.stringify($('#inputForm').serializeArray()),
                url: 'saveData',
                data: $('#inputForm').serialize(),
                // contentType: 'application/json',
                success: function(data) {

                }
            });
        });
    });

    $("#makerDropDown").change(function() {
       
//    	$('footer').css("position","relative");
//		$('footer').css("bottom","0px");
//		$('footer').css("margin-top","20px");
        var selectedText = $(this).find("option:selected").text();
        var selectedValue = $(this).val();
        $("#formDiv").show();
       // $("#datatable").hide();
        var data = "";
        $.ajax({
            type: "GET",
            url: "inputfromdropdown",
            data: "seletedvalue=" + $(this).val(),
            async: false,
            success: function(response) {
                
                if (response == "null") {
                    $("#formDiv").hide();
                    $("#datatable").hide();
                    alert("No Data Found On this selection ID!!");
                   
                }

                if(response=="DedupeCompleted")
                	{
                	 	$("#formDiv").hide();
                	  alert("Dedupe Already Performed !!")   
                	  
                	  $("#ManualSubmitChange").show();
                  	  $("#datatable").hide();
                	}
                else{
                // var data = JSON.stringify(response);
                var json = JSON.parse(response);
                $('#firstname').val(json.firstname);
                $('#middilename').val(json.middlename);
                $('#lastname').val(json.lastname);
                $('#fathername').val(json.father_NAME);
                $('#mothername').val(json.mother_NAME);
                $('#gender').val(json.gender_FLAG);
                $('#dob').val(json.dob1);
              
                $('#pan').val(json.pan);
                $('#voterid').val(json.voterid);
                $('#adharnumber').val(json.aadhar);
                $('#passport').val(json.passport);
                $('#dlicence').val(json.driving_LICN_NO);
                $('#rationnumber').val(json.rationcard_NO);

                $('#paddress').val(json.permanent_ADDRESS);
                $('#pcity').val(json.permanent_CITY);
                $('#ppincode').val(json.permanent_PIN);
                $('#PERMANENT_EMAIL').val(json.permanent_EMAIL);
                $('#pcontact').val(json.permanent_PHONE);
                $('#pstate').val(json.permanent_STATE);

                $('#officeaddrres').val(json.office_ADDRESS);
                $('#officecity').val(json.office_CITY);
                $('#officepincode').val(json.office_PIN);
                $('#officeemail').val(json.office_EMAIL);
                $('#officestate').val(json.office_STATE);
                $('#officecontact').val(json.office_PHONE);

                $('#taddress').val(json.temporary_ADDRESS);
                $('#tcity').val(json.temporary_CITY);
                $('#tpincode').val(json.temporary_PIN);
                $('#temail').val(json.temporary_EMAIL);
                $('#tstate').val(json.temporary_STATE);
                $('#tcontact').val(json.temporary_PHONE);

                $('#raddress').val(json.residence_ADDRESS);
                $('#rcity').val(json.residence_CITY);
                $('#rpincode').val(json.residence_PIN);
                $('#remail').val(json.residence_EMAIL);
                $('#rstate').val(json.residence_STATE);
                $('#rcontact').val(json.residence_PHONE);
                //
                $('#CKYC').val(json.ckycno);
                $('#doc').val(json.doc);
                $('#MOBILE').val(json.mobile);
                $('#STATUS').val(json.status);
                $('#CLIENT_TYPE').val(json.client_TYPE);
                $('#CRNNO').val(json.crnno);
                $('#GSTIN').val(json.gstin);
                $('#SOURCE_SYSTEM').val(json.source_SYSTEM);
                
                
                
                return response;
                }
                
                
                
            },
            error: function() {
                // $('#inputForm').reset();
            	
            	 $('.nodata').css('display','block');
                 $('.nodataClose').click(function(){
              	   $('.nodata').css('display','none');
                 })
                 
                $("#formDiv").hide();
                // $('#inputForm input').val('');
                alert('No data found on this selection !!');
            }
        });
    });


    // seleted view

    /*
     * $("#selectedRecord1").change(function() { //alert("onchange"); var
     * selectedText = $(this).find("option:selected").text(); var selectedValue =
     * $(this).val(); //$("#formDiv").show(); //$('#example').remove(trHTML);
     * //$('tbody').html('');
     *
     * $("input").each(function(){ if ($(this).val() == "") {
     * $(this).parent().parent().show(); }
     *
     *
     * });
     *  // $("#datatable").show(); // alert("Selected Text: " + selectedText + "
     * Value: " + selectedValue); //var data = "";
     *
     *
     *
     * $.ajax({ type : "GET", url : "verifiedinputfromdropdown", data :
     * "seletedvalue=" + $(this).val(), async : false, success : function(response) {
     * alert(response) console.log(response) if (response == "null" ) {
     *
     * alert("No Data Found On this selection ID!!") }
     *
     * var data = response; alert(data);
     *
     * //$("#inputId input[@value='']").parents("#inputId").hide();
     *
     * var data = JSON.stringify(response); var json = JSON.parse(response);
     *  // $('#example').remove(trHTML); var trHTML = ''; //alert(item.children);
     * $.each(json, function(j, child) { trHTML += '<tr class="row"><td>' +
     * child.request_ID + '</td><td>'+child.match_COUNT+'</td><td>'
     * +child.match_REASON+'</td><td>'+child.client_ID+'</td><td>'
     * +child.name+'</td><td>'+child.father_NAME+'</td><td>'
     * +child.permanent_PHONE+'</td><td>'+child.permanent_ADDRESS+'</td><td>'
     * +child.permanent_CITY+'</td><td>'+child.permanent_PINCODE+'</td><td>'
     * +child.aadhaar+'</td><td>'+child.psx_BATCH_ID+'</td></tr>' ; });
     *
     *
     * $('#example').append(trHTML);
     *
     * $('#example').DataTable();
     *
     * return response; }, error : function() {
     *
     * alert('No data found on this selection !!'); } }); });
     *
     */




    // this is for preview and select checkbox



    $("#getData").click(function() {
      
    	 
    	
    	
    	   
    	$('footer').css('position','fixed');
    	
    	
    	
        var allVals = [];
        $("#formDiv").hide();
        var jsonData = []
        var ids = $("#example tr:has(input[type=checkbox]:checked)").map(function() {
            var $tr = $(this);
            var $td = $tr.find("td");
            jsonData.push({
                "crmsclientid": $td[1].innerHTML,
                /* "matchreason": $td[2].innerHTML,
                "matchcount": $td[3].innerHTML,
                "scaletype": $td[4].innerHTML,
                "name": $td[5].innerHTML,
                "dob": $td[6].innerHTML,
                "gender": $td[7].innerHTML,
                "p_address": $td[8].innerHTML,
                "o_address": $td[9].innerHTML,
                "r_address": $td[10].innerHTML,
                "r_phone":$[td][11].innerHTML,
                "o_phone": $td[12].innerHTML,
                "taxid": $td[13].innerHTML,
                "aadhaar": $td[14].innerHTML,*/
                "requestid": $td[24].innerHTML,
                "psx_id": $td[25].innerHTML
            });
        }).get();
        var data=JSON.stringify(jsonData);
        
   
        var data=JSON.stringify(jsonData)
        
        
       // var radio= $('tr').find('input[type=radio]:checked');
        
 //var radioButtonData=[];
        var retain =[];
        var ids = $("#example tr:has(input[type=radio]:checked)").map(function() {

            var $tr = $(this);
            var $td = $tr.find("td");
            jsonData.push({
            	"retain_clientid":$td[25].innerHTML,
            	"retain_requestid":$td[24].innerHTML
            });
            retain.push({"retain_clientId":$td[25].innerHTML});
        
           
        }).get();
        
       // alert("Retain data :"+retain);
        var data=JSON.stringify(jsonData);
      //  alert(data);
       
     if( retain.length === 0 && jsonData.length === 0)
    	 {
    	 alert("No selection data available to verify !!");
    	 return false;
    	 }
        
     else  if(retain.length === 0)
     	{
        	alert("Please select retain!!");
        	return false;
     	}
    
      
        
       /* if(jsonData.length === 0)
     	{
        	alert("No target selected, Select  atleast source !!");        	
        	
     	}*/
     else {
        var retVal = confirm("Are you sure want to verify ?"); 
          if( retVal == false ) {
        return false;
        }
      else{
        $.ajax({
            type: "POST",
            dataType: 'json',
            contentType: 'application/json',
            url: "getCheckBoxData",
            data: JSON.stringify(jsonData),
            //	data : "data="+JSON.stringify(data),
            //async : false,
            success: function(response) {
                //    alert(response)
                //var data = JSON.stringify(response); 
                //	var json = JSON.parse(response);
                // alert(json);
               //alert("Seleted columns are verified please click on seletedview tab!!");
              /* $('.maker_verfication_modal').css('display','block');
               $('.close').click(function(){
            	   $('.maker_verfication_modal').css('display','none');
               })*/ 
            	
            	 //alert("Seleted Records Are Verified !!");
            	// alert("Seleted Records Are Verified !!");
             	var id=jsonData[0].crmsclientid;
             	
             	
     
             	  $.ajax({
 		            	 type: "GET",
 		                 dataType: 'json',
 		                 contentType: 'application/json',
 		                 url: "crmsClientIdDedupeVerification/M/"+id,
 		                // data: JSON.stringify(response),
 		                success: function(data) {
 		                	//alert("the data is"+data)
 		                	if(data!='null'&& data !=""&&data !='000'){
 		                    alert("Kindly perform verification for "+data)	;
 		                	}
 		                },
 		                error: function(data) {
 		                    alert('ERROR: ' + data)
 		                }
 		            })
                $("#datatable").hide();
                $('footer').css("position","absolute");
            	$('footer').css("margin-top","20px");
                return response;
            },
            error: function() {
                //$('#inputForm').reset();
                //$("#formDiv").hide();
                //$('#inputForm input').val('');
               // alert('No data found on this selection !!');
                
               
                $('footer').css("position","absolute");
            	$('footer').css("margin-top","20px");
            }
        });
   	}
     }
    });
    // this is for deleting seleted Checkbox rows

    $("#deleteSeleted").click(function() {
        // alert("delete button clicked!!");
        var allVals = [];
        $("#formDiv").hide();
        var jsonData = []

        var ids = $("#example tr:has(input:checked)").map(function() {

            var $tr = $(this);
            var $td = $tr.find("td");

            /*
                              <th><input type="checkbox" id="master"></th>
            					<th>CLIENT ID</th>
            					<th>MATCH REASON</th>
            					<th>MATCH COUNT</th>
            					<th>SCALE TYPE</th>
            					<th>NAME</th>
            					<th>DOB</th>
            					<th>GENDER</th>
            					<th>PERMANENT ADDRESS</th>
            					<th>RESIDENCY ADDRESS</th>
            					<th>OFFICE ADDRESS</th>
            					<th>RESIDENCE PHONE</th>
            					<th>OFFICE PHONE</th>
            					<th>TAX ID</th>						
            					<th>AADHAR</th>
            					<th>REQUESTID</th>*/




            jsonData.push({
                "crmsclientid": $td[1].innerHTML,
                /*					 "matchreason": $td[2].innerHTML,
                                     "matchcount": $td[3].innerHTML,
                                     "scaletype": $td[4].innerHTML,
                                     "name": $td[5].innerHTML,
                                     "dob": $td[6].innerHTML,
                                     "gender": $td[7].innerHTML,
                                     "p_address": $td[8].innerHTML,
                                     "o_address": $td[9].innerHTML,
                                     "r_address": $td[10].innerHTML,
                                     "r_phone":$[td][11].innerHTML,
                                     "o_phone": $td[12].innerHTML,
                                     "taxid": $td[13].innerHTML,
                                     "aadhaar": $td[14].innerHTML,*/
                "requestid": $td[24].innerHTML,
                "psx_id": $td[25].innerHTML
            });
        }).get();
       
        
     
        // alert(JSON.stringify(jsonData));

        var data = JSON.stringify(jsonData);
        if(jsonData.length ===0  )
     	{
        	alert("Nothing to Perform !!")
        	
        	
   	}
        var retVal = confirm("Are you sure want to Delete ?"); 
        if( retVal == false ) {
        return false;
        }
          
        
        else{
        
        // alert("sending"+data);
        $.ajax({
            type: "POST",
            dataType: 'json',
            contentType: 'application/json',
            url: "deleteSeletedCheckBox",
            data: JSON.stringify(jsonData),
            //	data : "data="+JSON.stringify(data),
            //async : false,
            success: function(response) {
                //    alert(response)
                //var data = JSON.stringify(response); 
                //	var json = JSON.parse(response);
                // alert(json);
              //  alert("Seleted Records Are Deleted !!");
                // $("#datatable").hide();
                $("#seletedview").hide();
                return response;
            },
            error: function() {
                //$('#inputForm').reset();
                //$("#formDiv").hide();
                //$('#inputForm input').val('');
                alert('No data found on this selection !!');
            }
        });
   	}
    });
    // This is for reject seleted CheckBox Data!!

    $("#rejectSeleted").click(function() {
        //   alert("reject button clicked!!");
        var allVals = [];
        $("#formDiv").hide();
        var jsonData = []
        var ids = $("#example tr:has(input:checked)").map(function() {
            var $tr = $(this);
            var $td = $tr.find("td");
            jsonData.push({
                "crmsclientid": $td[1].innerHTML,
                "requestid": $td[24].innerHTML,
                "psx_id": $td[25].innerHTML
            });
        }).get();

        var jsonData = JSON.stringify(jsonData);
       
  if(jsonData.length ===2)
    	{
		 alert("No data available !!");
        	
        	
  	}
  else{
  var retVal = confirm("Are you sure want to Reject !!"); 
  if( retVal == false ) {
  return false;
  }
  
  
  else{        
        
        $.ajax({
            type: "POST",
            dataType: 'json',
            contentType: 'application/json',
            url: "rejectSeletedCheckBox",
            data: jsonData, //JSON.stringify(jsonData),
            //	data : "data="+JSON.stringify(data),
            //async : false,
            success: function(response) {
               // alert("Seleted Records Are Rejected !!");
                $("#seletedview").hide();
                return response;
            },
            error: function() {
                alert('No data found on this selection !!');
            }
        });
	}
  }
    });

    // This is for approve seleted CheckBox Data!!
    $("#approveSeleted").click(function() {
        //  alert("approvebutton button clicked!!");
       
    	var allVals = [];
        $("#formDiv").hide();
        
        
        
        
        var jsonData = [];
        var ids = $("#example tr:has(input:checked)").map(function() {
            var $tr = $(this);
            var $td = $tr.find("td");
            jsonData.push({
                "crmsclientid": $td[1].innerHTML,
                "requestid": $td[24].innerHTML,
                "psx_id": $td[25].innerHTML
            });
        }).get();
        var data = JSON.stringify(jsonData);
       // alert(data);
     if(jsonData.length === 0)
     	{
        	alert("No data available !!");
   	}
     else{
    	 var retVal = confirm("Are you sure want to Approve ?");
    	 //$('.loading_image').css('display','block');
     }
     if( retVal == false ) {
     return false;
     }
     
     
     else{
    	$('.loading_image').css('display','block');
    	// $('.loading_image').html('<img src="images/loading.gif"> loading...');
        // alert("sending"+data);
        $.ajax({
            type: "POST",
            dataType: 'json',
            contentType: 'application/json',
            url: "approveSeletedCheckBox",
            data: JSON.stringify(jsonData),
            //	data : "data="+JSON.stringify(data),
            //async : false,
            success: function(response) {
            	
            	 $('.loading_image').css('display','none');
            	    
            	$('#listdto').empty();
            	
         	 for (var i = 0; i < response[1].length; i++) {            		
                     tr = $('<tr/>');
                     tr.append("<td>" + response[1][i].sourceClientNo+ "</td>");
                     tr.append("<td>" + response[1][i].clientMergeId+ "</td>");
                     tr.append("<td>" + response[1][i].transactionDt + "</td>");
                     tr.append("<td>" + response[1][i].flag+ "</td>");
                    // tr.append("<td>" + response[i].policyNo+ "</td>");
                     tr.append("<td>" + response[1][i].mergeStatus + "</td>");
                     tr.append("<td>" + response[1][i].errorcode+" "+response[1][i].errorDescription+ "</td>");
                     tr.append("<td/>");
                     $('#example1234').append(tr);
                 }
            	
            	
            		
            			
            			
            	
            	 if(response[1] !=null)
            	 {	
            		 var display=[];	
            		
            		 if(response!=null){
            			
            		 if(response[0].mergeErrorResponseList.length>0){		 
            			var resp = confirm("Merge client unsuccessful! Send To Maker? \n Please refer summary tab for failure reason")
            			    if(resp) {
            			            $.ajax({
            			            	 type: "POST",
            			                 dataType: 'json',
            			                 contentType: 'application/json',
            			                 url: "sendingErrorecodatoMaker",
            			                 data: JSON.stringify(response[0]),
            			                success: function(data) {
            			                    alert("Records sent to maker successfully!")
            			                },
            			                error: function(data) {
            			                    alert('ERROR: ' + data)
            			                }
            			            })
            			       
            			    }
            			    
            		 }else{
            			 alert("Merge client successsful!");
            			 var id=jsonData[0].crmsclientid;
            			
		            	  $.ajax({
				            	 type: "GET",
				                 dataType: 'json',
				                 contentType: 'application/json',
				                 url: "crmsClientIdDedupeVerification/C/"+id,
				                // data: JSON.stringify(response),
				                success: function(data) {
				                	if(data!='null'&& data !=""){
				                    alert("Kindly Perform action for "+data);
				                	}
				                },
				                error: function(data) {
				                	 $('.loading_image').css('display','none');
				                    alert('ERROR: ' + data)
				                }
				            })
            		 }
            		
            		 }
            		/*for(var i=0; i<response.length; i++)
            			{
            			if(response[i].flag!=null){
            			//alert(response[i].mergeClientNumber);
            			display.push({"Merge_ClientId":response[i].mergeClientNumber,
            						  "Success_Status":response[i].flag
            						 // "Retain_ClientId":response[i].retainedClientNumber,
            						  });
            			}
            			else{
            					display.push({"Merge_ClientId":response[i].mergeClientNumber,
            					//"Retain_ClientId":response[i].retainedClientNumber,
            					"Error_Code":response[i].errorCode,
      						  	"Error_Description":response[i].errorDescription})
            			}
            			}
            			alert("Response "+JSON.stringify(display));*/
            	 }
            		    
            	 $("#seletedview").hide();
            	
                return response;
            },
            error: function() {
            	$('.loading_image').css('display','none');
            	alert('LA Response status updated !!'); 
                
            }
            
        });
      //  $('.loading_image').css('display','none');
}


    });
    //No Action Required
   $("#noAction").click(function() {
	   var allVals = [];
        $("#formDiv").hide();
        
       /* var clientId = [];
        var ids = $("#example tbody tr").map(function() {
            var $tr = $(this);
            var $td = $tr.find("td");
            clientId.push({
                "crmsclientid": $td[2].innerHTML
               
            });
        }).get();
        alert(clientId)*/
       var id= $("#example").find("td:eq(1)").text();
      
       if(id==="")
    	   {
    	   alert("No data is available !!");
    	   return false;
    	   }
        var retVal = confirm("Do you want to continue with no action  ?"); 
       if( retVal == false ) {
       return false;
       }
      
       else {
        $.ajax({
            type: "GET",
            //  dataType: 'json',
           // contentType: 'application/json',
            url: "noAction?sourceClientId="+id,
           //data: "sourceClientId="+id,
            //	data : "data="+JSON.stringify(data),
            //async : false,
            success: function(response) {
            	 if(response != null || response!=""){
            		// alert("Source merge action completed !!");
            		 $("#datatable").hide();
            	 }
            	 else{
            		// alert('Merge status updated !!'); 
            	 }
            
                return response;
            },
            error: function() {
            	 alert('Error occured while LA back update !!'); 
                
            }
        });
    }
       

    });
    
    

});