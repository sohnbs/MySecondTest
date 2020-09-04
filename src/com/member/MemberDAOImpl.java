package com.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MemberDAOImpl implements MemberDAO{
	
	//DB연결
	String driver ="org.mariadb.jdbc.Driver";
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
	public MemberDAOImpl() {
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
	

	
		
	//멤버가입하기

	@Override
	public void memberInsert(MemberVO mvo) {
		
		try {
			 
			 String sql = "insert into member values(?,?,?,?,?,?)";
			 ps = con.prepareStatement(sql);
			 ps.setString(1, mvo.getName());
			 ps.setString(2, mvo.getUserid());
			 ps.setString(3, mvo.getPwd());
			 ps.setString(4, mvo.getPhone());
			 ps.setString(5, mvo.getEmail());
			 ps.setInt(6, mvo.getAdmin());

			 ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
					closeConnection(ps,con);
		}
		
	}	
	
	//멤버리스트
	@Override
	public ArrayList<MemberVO> memberList() {
		
		ArrayList<MemberVO> arr = new ArrayList<MemberVO>();
		try {
				
				String sql = "select * from member";
				st = con.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
									MemberVO mvo = new MemberVO();
									
									mvo.setName(rs.getString("name"));
									mvo.setUserid(rs.getString("userid"));
									mvo.setPwd(rs.getString("pwd"));
									mvo.setPhone(rs.getString("phone"));
									mvo.setEmail(rs.getString("email"));
									mvo.setAdmin(rs.getInt("admin"));									
									arr.add(mvo);
				}
		} 		catch (Exception e) {
						e.printStackTrace();
		} 		finally {
					 	closeConnection(con, st, rs);
		}		return arr;
		
	}
	
	

	@Override
	public void memberUpdate(MemberVO mvo) {
		try {
			
			 String sql = "update member set name=?, pwd=? ,phone=? , email=?, admin=? where userid=?";
			ps= con.prepareStatement(sql);
			ps.setString(1, mvo.getName());
			ps.setString(2, mvo.getUserid());
			ps.setString(3, mvo.getPwd());
			ps.setString(4, mvo.getPhone());
			ps.setString(5, mvo.getEmail());
			ps.setInt(6, mvo.getAdmin());
		
			ps.executeUpdate();
		}
			
		catch (Exception e) {
					e.printStackTrace();
		}finally {
				closeConnection(ps, con);
	 	
	}
	 
	}	 
	
	
	//멤버전체보기
	@Override
	public MemberVO memberView(String userid) {
		MemberVO mvo = null;
		
		try {
			
			String sql="select * from member where userid='"+userid+"'";
			st = con.createStatement();
			rs= st.executeQuery(sql);
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setName(rs.getString("name"));
				mvo.setUserid(rs.getString("userid"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setEmail(rs.getString("email"));
				mvo.setAdmin(rs.getInt("admin"));
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnection(con, st, rs);
			
	}
		return mvo;
	}

	
	
	//회원탈퇴
	
	@Override
	public void memberDelete(String userid) {
  		 	 		
 	 try {
		 
		 String sql = "delete from member where userid = ?";
		 
		 ps = con.prepareStatement(sql);
		 ps.setString(1, userid);
		 ps.executeUpdate(sql);
		
					
 	 } catch (Exception e) {
		 e.printStackTrace();
  }
 	 finally {
	  closeConnection(ps, con);
 	
}
 
}	
 
	

	//아이디 확인하기
	@Override
	public String idCheck(String userid) {
		 
		 String flag="yes"; //사용가능
		 try {
			 	
			 	String sql = "select * from member where userid='"+userid+"'";
			 	st = con.createStatement();
			 	rs= st.executeQuery(sql);
			 	if(rs.next()) {
			 					flag="no"; //사용불가능
			 					
			 	} 
		 } catch (Exception e) {
			 	 e.printStackTrace();
		 } finally {
			 		closeConnection(con, st, rs);
			 		
		 }	return flag;
	}
	
	
	
	
	//로그인체크
		public int loginCheck(String userid, String pwd) {
			int flag =-1; //-1:회원아님
			
			
			try {
				
				String sql="select  * from member where userid='"+userid+"'";	
				st = con.createStatement();
				rs =st.executeQuery(sql);
				if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)){
						flag=rs.getInt("admin");
					}else {		//비번오류
						flag=2;
							}	
				}			
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
				closeConnection(con, st, rs);
			}
			return flag;
				
				
			}
		
		

//		/********************** 관리자 **********************/
//		//관리자 로그인
//	
//		public boolean admin_login(String admin_id, String admin_pwd){
//			boolean b = false;
//			try {
//				String sql = "select * from admin where admin_id = ? and admin_pwd = ?";
//				//con = ds.getConnection();
//				ps = con.prepareStatement(sql);
//				ps.setString(1, admin_id);
//				ps.setString(2, admin_pwd);
//				rs = ps.executeQuery();
//				b = rs.next();
//			} catch (Exception e) {
//				System.out.println("admin_login err : " + e);
//			} finally {
//				try {
//					if(rs!=null)rs.close();
//					if(ps!=null)ps.close();
//					if(con!=null)con.close();
//				} catch (Exception e2) {
//					
//				}
//			}
//			
//			return b;
//		}
	
		 
	  private void closeConnection(PreparedStatement ps, Connection con) {
			 	try {
			 	 if(ps!=null) ps.close();
			 	 if(con!=null)con.close();
			  	}catch(SQLException e){
			  	e.printStackTrace(); 
			  	}
			  }
		
		
	
	 
	  private void closeConnection(PreparedStatement ps, ResultSet rs, Connection con) {
		 	try {
		 	 if(ps!=null) ps.close();
		 	 if(rs!=null) rs.close();
		 	 if(con!=null)con.close();
		  	}catch(SQLException e){
		  	e.printStackTrace(); 
		  	}
		  }
		 private void closeConnection(Connection con, Statement st, ResultSet rs) {
			try {
				 if(rs!=null) rs.close();
				 if(st!=null) st.close();
				 if(con!=null)con.close();
		 	}catch(SQLException e){
		 	e.printStackTrace(); 
		 	}
		 }

	}

	