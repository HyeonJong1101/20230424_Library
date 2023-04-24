package kr.co.kopo.ui;

import kr.co.kopo.LibraryServiceFactory;
import kr.co.kopo.service.LibraryService;
import kr.co.kopo.vo.BookVO;

public class SearchOneUI extends BaseUI{

	private LibraryService libraryService;
	
	public SearchOneUI() {
		super();
		libraryService = LibraryServiceFactory.getInstance();
	}
	
	@Override
	public void execute() {
		
		String name = scanStr("검색할 책이름을 입력하세요 : ");
		BookVO book = libraryService.selectBook(name);
		
		System.out.println("--------------------------------------------");
		System.out.println("번호\t책이름\t저자\t대출여부");
		System.out.println("--------------------------------------------");
		
		if(book == null) {
			System.out.println("책이 없습니다");
		}else {
			System.out.println(book.getNo()+"\t"
			          +book.getBook_name()+"\t"
			          +book.getWriter()+"\t"
			          +book.getBook_rent());
		}
	}
}
