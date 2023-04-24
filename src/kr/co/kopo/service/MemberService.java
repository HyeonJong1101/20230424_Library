package kr.co.kopo.service;

import java.util.List;

import kr.co.kopo.dao.MemberDAO;
import kr.co.kopo.vo.MemberVO;

public class MemberService {

	private MemberDAO memberDao;

	public MemberService() {
		super();
		memberDao = new MemberDAO();
	}
	
	public MemberVO creatAccount(String id, String name, int password) {
		MemberVO member = memberDao.creatAccount(id,name,password); 
		return member;
	}

	public MemberVO logIn(String id, int password) {
		MemberVO member = memberDao.logIn(id,password);
		return member;
	}

	public boolean delete(String id) {
		boolean member = memberDao.delete(id);
		return member;
	}

	public List<MemberVO> search(String id, String name) {
		List<MemberVO> member = memberDao.search(id, name);
		return member;
	}

	public MemberVO myInfo() {
		MemberVO member = memberDao.myInfo();
		return member;
	}
	
}
