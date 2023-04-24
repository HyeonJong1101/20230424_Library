package kr.co.kopo;

import kr.co.kopo.service.LibraryService;

public class LibraryServiceFactory {

	private static LibraryService service = null;
	
	public static LibraryService getInstance() {
		if(service == null) {
			service = new LibraryService();
		}
		
		return service;
	}
}
