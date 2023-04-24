package kr.co.kopo.vo;

public class BookVO {

	private int no;
	private String book_name; //책이름
	private String writer; //저자 이름
	private int book_rent; //대출가능여부
	private String member_id;
	
	public BookVO() {
		super();
	}
	
	public BookVO(int no, String book_name, String writer, int book_rent) {
		super();
		this.no = no;
		this.book_name = book_name;
		this.writer = writer;
		this.book_rent = book_rent;
	}

	public BookVO(int no, String book_name, String writer, int book_rent, String member_id) {
		super();
		this.no = no;
		this.book_name = book_name;
		this.writer = writer;
		this.book_rent = book_rent;
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "BookVO [no=" + no + ", book_name=" + book_name + ", writer=" + writer + ", book_rent=" + book_rent
				+ ", member_id=" + member_id + "]";
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getBook_rent() {
		return book_rent;
	}
	public void setBook_rent(int book_rent) {
		this.book_rent = book_rent;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
}
