package kr.co.kopo.ui.master;

import java.util.List;

import kr.co.kopo.MemberServiceFactory;
import kr.co.kopo.service.MemberService;
import kr.co.kopo.ui.BaseUI;
import kr.co.kopo.vo.MemberVO;

public class searchMemberUI extends BaseUI {

	private MemberService memberService;
	
	public searchMemberUI() {
		super();
		memberService = new MemberServiceFactory().getInstance();
	}
	
	
	@Override
	public void execute() {
		
		String id = scanStr("검색할 ID입력 : ");
		String name = scanStr("검색할 Name입력 : ");
		
		List<MemberVO> member = memberService.search(id,name);
		
		for(MemberVO mem : member) {
			System.out.println(mem.toString());
		}
	}

}
