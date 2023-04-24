package kr.co.kopo;

import kr.co.kopo.ui.LibraryMenuUI;

public class LibraryMain {
	
	public static void main(String[] args) {
		
		try {
			new LibraryMenuUI().execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
