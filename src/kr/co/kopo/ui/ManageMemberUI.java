package kr.co.kopo.ui;

import java.util.Scanner;

import kr.co.kopo.ui.master.createMemberUI;
import kr.co.kopo.ui.master.deleteMemberUI;
import kr.co.kopo.ui.master.searchMemberUI;

public class ManageMemberUI extends BaseUI {

	public int menu() {

		System.out.println("=============================");
		System.out.println("회원 관리");
		System.out.println("=============================");

		System.out.println("1.회원등록");
		System.out.println("2.회원삭제");
		System.out.println("3.회원검색");
		System.out.println("4.뒤로가기");
		Scanner sc = new Scanner(System.in);
		System.out.println("선택하세요");
		int type = sc.nextInt();
		sc.nextLine();

		return type;
	}
	
	@Override
	public void execute() {
		ILibraryUI ui = null;
		while(true) {
			switch (menu()) {
			case 1:
				System.out.println("회원등록 선택");
				ui = new createMemberUI();
				break;
			case 2:
				System.out.println("회원삭제 선택");
				ui = new deleteMemberUI();
				break;
			case 3:
				System.out.println("회원검색 선택");
				ui = new searchMemberUI();
				break;
			case 4:
				System.out.println("뒤로가기 선택");
				ui = new ManagerMenuUI();
				break;
			}
			
			if(ui != null) {
				ui.execute();
			}else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}

}
