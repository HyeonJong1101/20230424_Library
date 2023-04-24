package kr.co.kopo.ui;

import kr.co.kopo.LibraryServiceFactory;
import kr.co.kopo.service.LibraryService;
import kr.co.kopo.vo.BookVO;

public class ReturnUI extends BaseUI{

	private LibraryService libraryService;
	
	public ReturnUI() {
		super();
		libraryService = LibraryServiceFactory.getInstance();
	}

	@Override
	public void execute() {
		
		String name = scanStr("반납할 책 이름을 입력하세요 : ");
		BookVO book = libraryService.returnBook(name);
		
		if(book.getBook_rent() == 0) {
			System.out.println("반납완료...");
		}else {
			System.out.println("이미 반납된 책입니다...");
		}
	}
}
