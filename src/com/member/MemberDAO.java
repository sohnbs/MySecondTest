package com.member;

import java.util.ArrayList;

public interface MemberDAO {
	//추가
	public void memberInsert(MemberVO mvo);
	//전체보기
	public ArrayList<MemberVO> memberList();
	//수정
	public void memberUpdate(MemberVO mvo);
	//상세보기
	public MemberVO memberView(String userid);
	//삭제
	public void memberDelete(String userid);
	//아이디 중복체크
	public String idCheck(String userid);
}


