var checking = function() {

	var id = document.getElementById("name").value;
	var pw = document.getElementById("pwword").value;

	var cf = confirm("로그인 하시겠습니까?");
	if (cf) {
		if (id == "ssafy" && pw == "1111")
			alert("로그인 성공");
		else
			alert("아이디 또는 비밀번호가 틀렸습니다.");
	}
}