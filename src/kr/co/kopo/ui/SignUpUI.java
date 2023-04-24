package kr.co.kopo.ui;

import kr.co.kopo.MemberServiceFactory;
import kr.co.kopo.service.MemberService;
import kr.co.kopo.vo.MemberVO;

public class SignUpUI extends BaseUI {
	
	private MemberService memberService;
	

	public SignUpUI() {
		super();
		memberService = MemberServiceFactory.getInstance();
	}

	@Override
	public void execute() {
		String id = scanStr("ID : ");
		String name = scanStr("이름 : ");
		int password = scanInt("PassWord : ");
		
		MemberVO member = memberService.creatAccount(id,name,password);
		
		if(member == null) {
			System.out.println("회원가입 실패..");
		}else {
			System.out.println("회원가입 성공!");
		}
	}

}
