package kr.co.kopo.ui;

import java.util.Scanner;

public class ManagerMenuUI extends BaseUI {

	public int menu() {

		System.out.println("=============================");
		System.out.println("관리자 메뉴");
		System.out.println("=============================");

		System.out.println("1.회원관리");
		System.out.println("2.도서관리");
		System.out.println("3.뒤로가기");
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
				System.out.println("회원관리 선택");
				ui = new ManageMemberUI();
				break;
			case 2:
				System.out.println("도서관리 선택");
				ui = new MangerBookUI();
				break;
			case 3:
				System.out.println("뒤로가기 선택");
				ui = new LibraryMenuUI();
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
