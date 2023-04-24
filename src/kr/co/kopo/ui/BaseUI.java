package kr.co.kopo.ui;

import java.util.Scanner;

abstract public class BaseUI implements ILibraryUI{

	private Scanner sc;

	public BaseUI() {
		super();
		sc = new Scanner(System.in);
	}
	
	protected int scanInt(String msg) {
		System.out.println(msg);
		int num = Integer.parseInt(sc.nextLine());
		
		return num;
	}
	
	protected String scanStr(String msg) {
		System.out.println(msg);
		
		return sc.nextLine();
	}
	
}
