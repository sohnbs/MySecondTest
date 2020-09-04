var exp =/^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;
$(function(){
	$("#send").click(function(){
		if($("#name").val()==""){
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		if($("#userid").val()==""){
			alert("아이디를 입력하세요");
			$("#userid").focus();
			return false;
		}
		if($("#pwd").val()==""){
			alert("비밀번호 입력하세요");
			$("#pwd").focus();
			return false;
		}
		//비번확인
		if($("#pwd").val() !=  $("#pwd_check").val()){
			alert("비밀번호가 일치하지 않습니다.");
			$("#pwd_check").focus();
			return false;
		}
		//전화번호확인
		if(!$("#phone").val().match(exp)){
			alert("전화번호 입력 양식이 아닙니다.");
			$("#phone").focus();
			return false;
		}
		$("#frm").submit();
	});
	//아이디 중복 오픈창
	$("#idBtn").click(function(){
		window.open("idCheck.jsp","","width=800  height=500")
	});
	//아이디 중복 확인
	$("#idCheckBtn").click(function(){
		if($("#userid").val()==""){
			alert("아이디를 입력하세요");
			$("#userid").focus();
			return false;
		}
		$.ajax({
			type : "post",
			url    : "idCheckPro.jsp",
			data : {"userid" : $("#userid").val()},
			success : function(data){
				if(data.trim()=="yes"){
					alert("사용가능");
					$(opener.document).find("#userid").val($("#userid").val());
					$(opener.document).find("#uid").val($("#userid").val());
					self.close();
				}else if(data.trim()=="no"){
					alert("사용불가능")
				}
			},
			error : function(e){
				alert("error : " + e);
			}
		});  //$.ajax
		
	})
		
});




function del(userid){
	$.getJSON("memberDeletePro.jsp?userid="+userid, function(data){
		var htmlStr="";
		$.each(data, function(key, val){
			htmlStr +="<tr>";
			htmlStr +="<td>"+val.name+"</td>";
			htmlStr +="<td>"+val.userid+"</td>";
			htmlStr +="<td>"+val.phone+"</td>";
			htmlStr +="<td>"+val.email+"</td>";
			htmlStr +="<td>"+val.mode+"</td>";
			htmlStr +="<td onclick=del('"+val.userid+"'>삭제2</td>";
		});
	})			
		
		$("table tbody").html(htmlStr);
}
	



