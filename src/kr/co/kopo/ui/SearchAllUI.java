package kr.co.kopo.ui;

import java.util.List;

import kr.co.kopo.LibraryServiceFactory;
import kr.co.kopo.service.LibraryService;
import kr.co.kopo.vo.BookVO;

public class SearchAllUI extends BaseUI{
	
	private LibraryService libraryService;

	public SearchAllUI() {
		super();
		libraryService = LibraryServiceFactory.getInstance();
	}

	@Override
	public void execute(){
		List<BookVO> bookList = libraryService.selectAll();
		
		System.out.println("--------------------------------------------");
		System.out.println("바코드\t책이름\t저자\t대출여부\t현재대출중인ID");
		System.out.println("--------------------------------------------");
		
		if(bookList==null || bookList.size()==0) {
			System.out.println("책이 존재하지않습니다");
		}else {
			for(BookVO book : bookList) {
				System.out.println(book.getNo()+"\t"
						          +book.getBook_name()+"\t"
						          +book.getWriter()+"\t"
						          +(book.getBook_rent() == 1 ? "가능":"불가능")+"\t"
						          +book.getMember_id());
			}
		}
		
	}
}
