package ssafy.member.repo;

import java.util.ArrayList;

import ssafy.member.domain.MemberDTO;

public interface MemberDAO {
	void memberInsert(MemberDTO mem);
	void memberUpdate(MemberDTO mem);
	void memberDelete(String name);
	MemberDTO memberSelectOne(String name);
	ArrayList<MemberDTO> memberSelectList();
}
