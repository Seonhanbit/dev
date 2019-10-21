package ssafy.member.repo;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ssafy.member.domain.MemberDTO;

@Component(value="memberdao")
public class MemberDAOImpl implements MemberDAO{
	
	public MemberDAOImpl() {}
	
	@Override
	public void memberInsert(MemberDTO mem) {
		System.out.println("Member 추가");		
	}

	@Override
	public void memberUpdate(MemberDTO mem) {
		System.out.println("Member 수정");			
	}

	@Override
	public void memberDelete(String name) {
		System.out.println("Member 삭제");			
	}

	@Override
	public MemberDTO memberSelectOne(String name) {
		System.out.println("Member 1명");	
		return null;
	}

	@Override
	public ArrayList<MemberDTO> memberSelectList() {
		System.out.println("Member 리스트");	
		return null;
	}


}
