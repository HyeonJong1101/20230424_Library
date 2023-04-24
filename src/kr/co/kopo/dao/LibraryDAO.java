package kr.co.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.kopo.LogInfo;
import kr.co.kopo.util.ConnectionFactory;
import kr.co.kopo.vo.BookVO;

public class LibraryDAO {

	public LibraryDAO() {
		super();
	}

	public List<BookVO> selectAllBook() {

		List<BookVO> bookList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select *");
		sql.append(" from t_book");

		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String book_name = rs.getString("book_name");
				String writer = rs.getString("writer");
				int book_rent = rs.getInt("book_rent");
				String member_id = rs.getString("member_id");
				
				BookVO book = new BookVO();
				book.setNo(no);
				book.setBook_name(book_name);
				book.setWriter(writer);
				book.setBook_rent(book_rent);
				book.setMember_id(member_id);
				
				bookList.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	public BookVO selectBook(String book_name) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, book_name, writer, book_rent");
		sql.append(" from t_book");
		sql.append(" where book_name = ?");
		
		BookVO book = null;
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1,book_name);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("no");
				String book_n = rs.getString("book_name");
				String writer = rs.getString("writer");
				int rent = rs.getInt("book_rent");
				
				book = new BookVO();
				book.setNo(no);
				book.setBook_name(book_n);
				book.setWriter(writer);
				book.setBook_rent(rent);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	public BookVO rentBook(String book_name) {

		StringBuilder sql = new StringBuilder();
		sql.append("select no, book_name, writer, book_rent");
		sql.append(" from t_book");
		sql.append(" where book_name = ?");
		
		BookVO book = null;
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		){
			pstmt.setString(1,book_name);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("no");
				String book_n = rs.getString("book_name");
				String writer = rs.getString("writer");
				int rent = rs.getInt("book_rent");
				
				book = new BookVO();
				book.setNo(no);
				book.setBook_name(book_n);
				book.setWriter(writer);
				book.setBook_rent(rent);
				
				if(rent == 1) {
					StringBuilder sql2 = new StringBuilder();
					sql2.append("update t_book");
					sql2.append(" set book_rent=0, member_id=?");
					sql2.append(" where book_name = ?");
					try(
						Connection conn2 = new ConnectionFactory().getConnection();
						PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
					) {
						pstmt2.setString(1, LogInfo.log().getID());
						pstmt2.setString(2, book_n);
						pstmt2.executeQuery();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return book;
	}
	
	public BookVO returnBook(String book_name) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, book_name, writer, book_rent");
		sql.append(" from t_book");
		sql.append(" where book_name = ?");
		
		BookVO book = null;
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		){
			pstmt.setString(1,book_name);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("no");
				String book_n = rs.getString("book_name");
				String writer = rs.getString("writer");
				int rent = rs.getInt("book_rent");
				
				book = new BookVO();
				book.setNo(no);
				book.setBook_name(book_n);
				book.setWriter(writer);
				book.setBook_rent(rent);

				if(rent == 0) {
					StringBuilder sql2 = new StringBuilder();
					sql2.append("update t_book");
					sql2.append(" set book_rent=1,member_id=null");
					sql2.append(" where book_name = ?");
					try(
						Connection conn2 = new ConnectionFactory().getConnection();
						PreparedStatement pstmt2 = conn.prepareStatement(sql2.toString());
					) {
						pstmt2.setString(1, book_n);
						pstmt2.executeQuery();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public BookVO createBook(int no, String book_name, String writer) {
		
		BookVO book=null;
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_book(no,book_name,writer,book_rent)");
		sql.append(" values(?,?,?,1)");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, no);
			pstmt.setString(2, book_name);
			pstmt.setString(3, writer);
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 1) {
				StringBuilder sql2 = new StringBuilder();
				sql2.append("select *");
				sql2.append(" from t_book");
				sql2.append(" where no = ?");
				try(
					Connection conn2 = new ConnectionFactory().getConnection();
					PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
				) {
					pstmt2.setInt(1, no);
					ResultSet rs = pstmt2.executeQuery();
					
					if(rs.next()) {
						
						book = new BookVO();
						book.setNo(rs.getInt("no"));
						book.setBook_name(rs.getString("book_name"));
						book.setWriter(rs.getString("writer"));
						book.setBook_rent(rs.getInt("book_rent"));
					}
				}catch(Exception e) {
					e.printStackTrace();;
				}
			}
		}catch(Exception e) {
			System.out.println("같은 번호의 책이있음");
		}
		
		return book;
	}

	public boolean delete(int no) {
		boolean book = false;
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete");
		sql.append(" from t_book");
		sql.append(" where no = ?");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, no);
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 1) {
				book = true;
			}else {
				book = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
}
