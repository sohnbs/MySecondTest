function check_ok(){
	
	
	if(document.form.b_name.value.length == 0){
		alert("이름을 써주세요");
		form.b_name.focus();
		return;
	}
	
	
	if(document.form.b_title.value.length == 0){
		alert("글 제목을 써주세요");
		form.b_title.focus();
		return;
	}
		
	if(document.form.b_content.value.length == 0){
		alert("글 내용을 써주세요");
		form.b_content.focus();
		return;
	}
	
	document.form.submit();
}

