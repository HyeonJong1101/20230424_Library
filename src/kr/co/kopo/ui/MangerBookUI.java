package kr.co.kopo.ui;

import java.util.Scanner;

import kr.co.kopo.ui.master.createBookUI;
import kr.co.kopo.ui.master.deleteBookUI;
import kr.co.kopo.ui.master.searchMemberUI;

public class MangerBookUI extends BaseUI {

	public int menu() {

		System.out.println("=============================");
		System.out.println("도서 관리");
		System.out.println("=============================");

		System.out.println("1.도서 등록");
		System.out.println("2.도서 삭제");
		//System.out.println("3.대출 현황 출력");
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
				System.out.println("도서 등록 선택");
				ui = new createBookUI();
				break;
			case 2:
				System.out.println("도서 삭제 선택");
				ui = new deleteBookUI();
				break;
			/*case 3:
				System.out.println("대출 현황 선택");
				ui = new searchMemberUI();
				break;*/
			case 3:
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
