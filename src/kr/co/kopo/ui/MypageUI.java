package kr.co.kopo.ui;

import kr.co.kopo.MemberServiceFactory;
import kr.co.kopo.service.MemberService;
import kr.co.kopo.vo.MemberVO;

public class MypageUI extends BaseUI {

	private MemberService memberService;
	
	public MypageUI() {
		super();
		memberService = MemberServiceFactory.getInstance();
	}
	
	@Override
	public void execute() {
		
		MemberVO member = memberService.myInfo();
		
		try {
			System.out.println(member.getID()+"\t"
					+member.getName()+"\t"
					+member.getBook());
			
		}catch(Exception e) {
		}
	}

}
