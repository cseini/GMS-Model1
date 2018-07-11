package service;

import java.util.List;

import dao.MemberDaoImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {session = new MemberBean();}
	MemberBean session;
	@Override
	public void createMember(MemberBean Member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> listMember() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MemberBean> findMemberByWord(String word) {
		System.out.println(word);
		MemberDaoImpl.getInstance().selectMemberByWord(word);
		return null;
	}
	@Override
	public MemberBean findMemberBySeq(String seq) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countMember() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifyMember(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeMember(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean login(MemberBean bean) {
		session = MemberDaoImpl.getInstance().login(bean);
		
		return (session!=null);
	}

}
