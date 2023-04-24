package kr.co.kopo.ui.master;

import kr.co.kopo.MemberServiceFactory;
import kr.co.kopo.service.MemberService;
import kr.co.kopo.ui.BaseUI;

public class deleteMemberUI extends BaseUI {

	private MemberService memberService;
	
	public deleteMemberUI() {
		super();
		memberService = new MemberServiceFactory().getInstance();
	}

	@Override
	public void execute() {
		String id = scanStr("삭제할 ID입력 : ");
		
		boolean member = memberService.delete(id);
		
		if(member == true) {
			System.out.println("삭제성공!");
		}else {
			System.out.println("삭제실패!");
		}
	}

}
