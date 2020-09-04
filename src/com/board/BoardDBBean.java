package com.board;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import myUtil.HanConv;

public class BoardDBBean {

	//DB연결
	String driver ="org.mariadb.jdbc.Driver";
	Connection con;
	Statement st;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	//DB연결
	public BoardDBBean() {
			try {
					Class.forName(driver);
					con = DriverManager.getConnection(
							"jdbc:mariadb://127.0.0.1:3306/test", "root", "jjhaidy3124$");
							
					if(con != null) {
						System.out.println("DB 연결성공");
					}
				} catch (ClassNotFoundException e) {
					System.out.println("드라이버 로드 실패");
				} catch(SQLException e) {
					System.out.println("DB 접속 실패");
					e.printStackTrace();
				}
		}
		
			
				
	//게시판에 추가하기

	public int insertBoard(BoardBean board) {
//		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="";
		int number;
		
		try {
			//con = getConnection();
			// �Խ������κ��� ���̵� ��������
			sql="select max(b_id) from mboard";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				number=rs.getInt(1)+1;
			}else {
				number=1;
			}
			
			// �Խ��� �� ����
			sql="insert into mboard(b_id, b_name, b_email, b_title, b_content) ";
			sql+="values(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, HanConv.toKor(board.getB_name()));
			pstmt.setString(3, board.getB_email());
			pstmt.setString(4, HanConv.toKor(board.getB_title()));
			pstmt.setString(5, HanConv.toKor(board.getB_content()));
			
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
	
	//리스트 보여주기
		public ArrayList<BoardBean> listBoard(){
//		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		//보드리스트 객체생성
		ArrayList<BoardBean> boardList = new ArrayList<BoardBean>();
		
		try {
			//con=getConnection();
			stmt = con.createStatement();
			String str="select * from mboard order by b_id";
			rs = stmt.executeQuery(str);
			
			while(rs.next()) {
				BoardBean board=new BoardBean();
				board.setB_id(rs.getInt(1));
				board.setB_name(rs.getString(2));
				board.setB_email(rs.getString(3));
				board.setB_title(rs.getString(4));
				board.setB_content(rs.getString(5));
				
				
				
				boardList.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return boardList;
	}
	
	
	//게시판 글 가져오기(list.jsp의 글을  show.jsp로 보여주기)
	public BoardBean getBoard(int bid) {
//		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		BoardBean board=null; 
		
		try {
			//con=getConnection();
			sql="select * from mboard where b_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardBean();
				board.setB_id(rs.getInt(1));
				board.setB_name(rs.getString(2));
				board.setB_email(rs.getString(3));
				board.setB_title(rs.getString(4));
				board.setB_content(rs.getString(5));
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return board;
	}
	
}
	