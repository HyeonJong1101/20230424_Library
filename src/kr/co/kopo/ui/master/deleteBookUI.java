package kr.co.kopo.ui.master;

import kr.co.kopo.LibraryServiceFactory;
import kr.co.kopo.service.LibraryService;
import kr.co.kopo.ui.BaseUI;

public class deleteBookUI extends BaseUI {

	private LibraryService libraryService;

	public deleteBookUI() {
		super();
		libraryService = new LibraryServiceFactory().getInstance();
	}

	@Override
	public void execute() {
		int no = scanInt("삭제할 책의번호 입력 : ");

		boolean book = libraryService.delete(no);

		if (book == true) {
			System.out.println("삭제성공!");
		} else {
			System.out.println("삭제실패!");
		}
	}

}
