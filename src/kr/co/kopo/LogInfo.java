package kr.co.kopo;

import kr.co.kopo.vo.MemberVO;

public class LogInfo {

	public static MemberVO mem;
	
	public static MemberVO log() {
		
		if(mem == null) {
			mem = new MemberVO();
		}
		
		return mem;
	}
}
