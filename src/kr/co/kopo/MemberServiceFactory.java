package kr.co.kopo;

import kr.co.kopo.service.MemberService;

public class MemberServiceFactory {

	private static MemberService service = null;
	
	public static MemberService getInstance() {
		if(service == null) {
			service = new MemberService();
		}
		return service;
	}
}
