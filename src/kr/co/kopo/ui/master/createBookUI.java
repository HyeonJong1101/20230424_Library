package kr.co.kopo.ui.master;

import kr.co.kopo.LibraryServiceFactory;
import kr.co.kopo.service.LibraryService;
import kr.co.kopo.ui.BaseUI;
import kr.co.kopo.vo.BookVO;

public class createBookUI extends BaseUI {

	private LibraryService libraryService;
	
	public createBookUI() {
		super();
		libraryService = new LibraryServiceFactory().getInstance();
	}
	
	@Override
	public void execute() {
		int no = scanInt("도서번호 입력 : ");
		String book_name = scanStr("책이름 입력 : ");
		String writer = scanStr("저자 입력 : ");
		
		BookVO book = libraryService.creatBook(no,book_name,writer);
		
		if(book == null) {
			System.out.println("등록실패!");
		}else {
			System.out.println("동록성공!");
		}
	}

}
