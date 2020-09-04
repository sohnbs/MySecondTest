package com.member;

import java.util.ArrayList;

public interface MemberDAO {
	//�߰�
	public void memberInsert(MemberVO mvo);
	//��ü����
	public ArrayList<MemberVO> memberList();
	//����
	public void memberUpdate(MemberVO mvo);
	//�󼼺���
	public MemberVO memberView(String userid);
	//����
	public void memberDelete(String userid);
	//���̵� �ߺ�üũ
	public String idCheck(String userid);
}


