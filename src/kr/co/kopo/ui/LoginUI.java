package kr.co.kopo.ui;

import kr.co.kopo.LogInfo;
import kr.co.kopo.MemberServiceFactory;
import kr.co.kopo.service.MemberService;
import kr.co.kopo.vo.MemberVO;

public class LoginUI extends BaseUI {

	private MemberService memberService;
	
	public LoginUI() {
		super();
		memberService = MemberServiceFactory.getInstance();
	}

	@Override
	public void execute() {
		System.out.println("===================");
		System.out.println("로그인");
		String id = scanStr("ID : ");
		int password = scanInt("PassWord : ");
		
		MemberVO member = memberService.logIn(id,password);
		if(member == null) {
			System.out.println("잘못입력하셨습니다.");
		}else {
			System.out.println("로그인 성공!");
			
			System.out.println(LogInfo.log());
			
			RentMenuUI ui = new RentMenuUI();
			ui.execute();
		}
	}

}
