package kr.co.kopo.ui.master;

import kr.co.kopo.MemberServiceFactory;
import kr.co.kopo.service.MemberService;
import kr.co.kopo.ui.BaseUI;
import kr.co.kopo.vo.MemberVO;

public class createMemberUI extends BaseUI {

	private MemberService memberService;
	
	public createMemberUI(){
		memberService = MemberServiceFactory.getInstance();
	}

	@Override
	public void execute() {
		
		String name = scanStr("Name입력: ");
		String id = scanStr("ID입력: ");
		int password = scanInt("password입력: ");
		
		MemberVO member = memberService.creatAccount(id, name, password);
		
		if(member == null) {
			System.out.println("생성실패!");
		}else {
			System.out.println("생성성공!");
		}
	}

}
