package kr.co.kopo.ui;

import java.util.Scanner;

import kr.co.kopo.vo.MemberVO;

public class LibraryMenuUI extends BaseUI{

	
	public int menu() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n==============================");
		System.out.println("도서관");
		System.out.println("==============================");
		System.out.println("1.도서반납하기");
		System.out.println("2.회원가입");
		System.out.println("3.로그인");
		System.out.println("4.관리자 모드");
		System.out.println("5.종료");
		System.out.print("항목을 선택하세요 : ");
		
		int type = sc.nextInt();
		sc.nextLine();
		
		return type;
	}
	
	@Override
	public void execute() {
		
		while(true) {
			int type = menu();
			
			ILibraryUI ui = null;
			switch(type) {
			case 1:
				System.out.println("\n도서반납 선택");
				ui = new ReturnUI();
				break;
			case 2:
				System.out.println("\n회원가입 선택");
				ui = new SignUpUI();
				break;
			case 3:
				System.out.println("\n로그인 선택");
				ui = new LoginUI();
				break;
			case 4:
				System.out.println("\n관리자 모드 선택");
				ui = new ManagerMenuUI();
				break;
			case 5:
				System.out.println("\n프로그램 종료");
				System.exit(0);
			}
			
			if (ui != null) {
				ui.execute();
			} else {
				System.out.println("\n잘못입력하셨습니다");
			}
		}
	}
}
