package ch6;

@AnnoTest
public class LoginBean {
	private UserLogin userLogin;

	public UserLogin getUserLogin() {
		return userLogin;
	}
	
	@AnnoTest(msg="ChineseLogin")
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	
	public void loginTest(){
		userLogin.login();
	}
}