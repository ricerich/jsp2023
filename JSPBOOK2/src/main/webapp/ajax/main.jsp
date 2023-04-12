<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트 JSON</title>
<link rel="stylesheet" href="./css/bootstrap.min.css" />


<script type="text/javascript">

	var ajax1; // XMLhttpRequest객체를 저장할 변수, 전역변수선언
	
	function createAJAX()
	{
		ajax1 = new XMLHttpRequest();
	}
	
	function getData()//json 요청
	{		
		var form_name = "form_main";
		var user_id = document.forms[form_name].elements["txt_user_id"].value;
		
		createAJAX(); // createXHR() 메소드 호출
		
		var url = "./testFile.jsp"; //요청 url 설정
		var reqparam = "user_id="+user_id;
		
		ajax1.onreadystatechange = resGetData; // 다되면 실행할 함수 등록(호출 아님. 역호출)
		ajax1.open("Post", url, "true"); //서버의 요청설정 -url변수에 설정된 리소스를 요청할 준비
		ajax1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		ajax1.send(reqparam);
	}

	function resGetData()
	{
		if(ajax1.readyState == 4)
		{
			if(ajax1.status == 200)
			{
				//alert("2");
				
				var result = ajax1.responseText;
 				alert(result);
				
 				var objRes = eval("("+result+")");
 				alert(objRes);
				
				var num = objRes.datas.length;
				var res = "<table class='table table-hover'>";
				var resDiv = document.getElementById("div_res");
				
				if(num<1)
				{
					res += "<tr><td width='980' height='100' align = 'center' style='font-size:50;'>검색 결과가 없습니다.</td></tr>";
				}
				else
				{
					for(var i=0; i<num; i++)
					{
						var user_id = objRes.datas[i].ID;
						var user_name = objRes.datas[i].NAME;
						var user_phone = objRes.datas[i].PHONE;
						var user_grade = objRes.datas[i].GRADE;
						var user_time = objRes.datas[i].WRITE_TIME;
						
						res +="<tr class='table-active'>";
						res +="<td >"+user_id+"</td>";
						res +="<td><br>"+user_name+"<br></td>";
						res +="<td><br>"+user_phone+"<br></td>";
						res +="<td><br>"+user_grade+"<br></td>";
						res +="<td><br>"+user_time+"<br></td>";
						res +="</tr>";
					}
				}
				res += "</table>";
				
				alert(res);
				resDiv.innerHTML = res;
			}
		}
	}
	function searchData()
	{
	
		//alert("111")
		var form_name = "form_main";
		var user_id = document.forms[form_name].elements["txt_user_id"].value;
		//alert("123");
// 		if(user_id == "")
// 		{			
			
// 			document.forms[form_name].elements["txt_user_id"].focus();
// 			return;
// 		}
// 		else
// 		{
			//alert("user_id ");
			getData();
// 		}		
	}
	
</script>


</head>
<body>
<form name="form_main" onSubmit="javascript:return false;">
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12"> -</div>
	    </div>
	    <div class="row">
	        <div class="col-sm-6 col-md-3"></div>
	        <div class="col-sm-6">   
	        	<div class="input-group mb-3">
		      		<input type="text" name='txt_user_id' class="form-control" placeholder="ID 입력바람!" aria-label="Recipient's username" aria-describedby="button-addon2" onkeyup='javascript:searchData();'>
		      		<button class="btn btn-primary" type="button" id="button-addon2" onClick='javascript:searchData();' >Button</button>
		    	</div>
		    	<div id='div_res' class="input-group mb-3" >
		    	
		    	</div>
    		</div>
	        <div class="col-md-3"></div>
	    </div>
	    <div class="row">
	        <div class="col-xs-12"></div>
	    </div>
	</div>
 </form>
   
</body>
</html>