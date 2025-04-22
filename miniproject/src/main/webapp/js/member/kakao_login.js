Kakao.init('c834ce50f389b8f8b20e938ddfc7ea37');  //키 발급 

function kakao_login() {
	Kakao.Auth.login({  
		success: function(response) {  //성공시 출력 => 결과화면을 출력. 
			Kakao.API.request({  
				url: '/v2/user/me',  
				success: function(response) {  
					console.log(response);
					
					let id = response["id"]; 
					let name = response["kakao_account"]["profile"]["nickname"]; 
					 console.log("name : "+name);
					frm.m_type.value = "KAKAO";
					frm.kakao_id.value = id;
					frm.kakao_nm.value = name;
					frm.method="post";
					frm.action="./login_ok.do";
					frm.submit();

				},
				fail: function(error) {
					console.log("카카오 api 접속오류");
					console.log(error);
				}
			});
		},
		fail: function(error) {  //API키가 안맞는 경우 출력 
			console.log("카카오 키 접속 오류 및 환경설정 오류");
			console.log(error);
		}
	});
}
