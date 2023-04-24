package kr.co.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.kopo.LogInfo;
import kr.co.kopo.util.ConnectionFactory;
import kr.co.kopo.vo.MemberVO;

public class MemberDAO {

	public MemberDAO() {
		super();
	}

	public MemberVO creatAccount(String id, String name, int password) {
		
		MemberVO member = null;
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_member(no, member_name, member_id, member_pass)");
		sql.append(" values(seq_t_board_no.nextval,?,?,?)");
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		){
			String member_id = id;
			String member_name = name;
			int member_pass = password;
			pstmt.setString(1, member_name);
			pstmt.setString(2, member_id);
			pstmt.setInt(3, member_pass);
			
			pstmt.executeUpdate();
			
			StringBuilder sql2 = new StringBuilder();
			sql2.append("select no");
 		    sql2.append(" from t_member");
 		    sql2.append(" where member_id = ?");
			try(
				Connection conn2 = new ConnectionFactory().getConnection();
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());	
			){
				pstmt2.setString(1, member_id);
				
				ResultSet rs = pstmt2.executeQuery();
				
				if(rs.next()) {
					member = new MemberVO();
					member.setNo(rs.getInt("no"));
					member.setName(member_name);
					member.setID(member_id);
					member.setPassword(member_pass);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}catch(Exception e) {
			System.out.println("중복 아이디입니다");
		}
		
		return member;
	}

	public MemberVO logIn(String id, int password) {
		
		MemberVO member = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select *");
		sql.append(" from t_member");
		sql.append(" where member_id = ?");
		sql.append(" and member_pass = ?");
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, id);
			pstmt.setInt(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setNo(rs.getInt("no"));
				member.setName(rs.getString("member_name"));
				member.setID(rs.getString("member_id"));
				member.setPassword(rs.getInt("member_pass"));
			}
			LogInfo log_member = new LogInfo();
			log_member.mem = member;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}

	public boolean delete(String id) {
		
		boolean member = false;
		StringBuilder sql = new StringBuilder();
		sql.append("delete");
		sql.append(" from t_member");
		sql.append(" where member_id = ?");
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, id);
			
			int cnt = pstmt.executeUpdate();
			if(cnt==1) {
				member = true;
			}else {
				member = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public List<MemberVO> search(String id, String name) {
		List<MemberVO> member = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select *");
		sql.append(" from t_member");
		sql.append(" where member_id = ?");
		sql.append(" or member_name = ?");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO mem = new MemberVO();
				mem.setNo(rs.getInt("no"));
				mem.setName(rs.getString("member_name"));
				mem.setID(rs.getString("member_id"));
				mem.setPassword(rs.getInt("member_pass"));
				
				member.add(mem);
			}
		}catch(Exception e) {
			
		}
		
		return member;
	}

/*
	public MemberVO myInfo() {

	    MemberVO member = null;
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT A.member_id, A.member_name, LISTAGG(B.book_name, ', ') WITHIN GROUP (ORDER BY B.book_name) AS book_list");
	    sql.append(" FROM t_member A");
	    sql.append(" JOIN t_book B ON B.member_id = A.member_id");
	    sql.append(" WHERE A.member_id = ?");
	    sql.append(" GROUP BY A.member_id, A.member_name");

	    try(
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ) {
	        pstmt.setString(1, LogInfo.log().getID());

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {

	            StringBuilder sql2 = new StringBuilder();
	            sql2.append("INSERT INTO meminfo(member_id, member_name, book)");
	            sql2.append(" VALUES (?, ?, ?)");

	            try (
	                Connection conn2 = new ConnectionFactory().getConnection();
	                PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
	            ) {
	                String id = rs.getString("member_id");
	                String name = rs.getString("member_name");
	                String bookList = rs.getString("book_list");

	                pstmt2.setString(1, id);
	                pstmt2.setString(2, name);
	                pstmt2.setString(3, bookList);

	                int cnt = pstmt2.executeUpdate();

	                if (cnt == 1) {
	                    member = new MemberVO();
	                    member.setID(id);
	                    member.setName(name);
	                    member.setBook(bookList);
	                }
	            } catch (Exception e) {
	            	 String id = LogInfo.log().getID();
	            	 String name = LogInfo.log().getName();
	            	 String book = member.getBook();
	            	 member = new MemberVO();
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return member;
	}*/

	public MemberVO myInfo() {
	    MemberVO member = null;
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT A.member_id, A.member_name, LISTAGG(B.book_name, ', ') WITHIN GROUP (ORDER BY B.book_name) as book_list ");
	    sql.append("FROM t_member A ");
	    sql.append("LEFT JOIN t_book B ON A.member_id = B.member_id ");
	    sql.append("WHERE A.member_id = ? ");
	    sql.append("GROUP BY A.member_id, A.member_name");

	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ) {
	        pstmt.setString(1, LogInfo.log().getID());
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            String id = rs.getString("member_id");
	            String name = rs.getString("member_name");
	            String bookList = rs.getString("book_list");
	            
	            StringBuilder insertSql = new StringBuilder();
	            insertSql.append("INSERT INTO meminfo(member_id, member_name, book) ");
	            insertSql.append("VALUES (?, ?, ?)");
	            
	            try (Connection conn2 = new ConnectionFactory().getConnection();
	                 PreparedStatement pstmt2 = conn2.prepareStatement(insertSql.toString());
	            ) {
	                pstmt2.setString(1, id);
	                pstmt2.setString(2, name);
	                pstmt2.setString(3, bookList);
	                int cnt = pstmt2.executeUpdate();
	                if (cnt == 1) {
	                    member = new MemberVO();
	                    member.setID(id);
	                    member.setName(name);
	                    member.setBook(bookList);
	                }
	            } catch (Exception e) {
	            	System.out.println(id+"\t"
	    							+name+"\t"
	    							+bookList);
	            }
	        }
	    } catch (Exception e) {
	    }

	    return member;
	}

}
