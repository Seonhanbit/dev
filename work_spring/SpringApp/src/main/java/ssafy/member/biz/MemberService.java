package ssafy.member.biz;

import java.util.ArrayList;

import ssafy.member.domain.MemberDTO;

public interface MemberService {
	void memberInsert(String name, String age);
	void memberUpdate(String name, String age);
	void memberDelete(String name);
	MemberDTO memberSelectOne(String name);
	ArrayList<MemberDTO> memberSelectList();
}
