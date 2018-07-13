package dao;

import java.util.*;
import domain.*;
import enums.MemberQuery;
import enums.Vendor;
import factory.*;
import pool.DBConstant;
import java.sql.*;

public class MemberDaoImpl implements MemberDao {
	private static MemberDao instance = new MemberDaoImpl();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl() {}

	@Override
	public void insertMember(MemberBean Member) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.INSERT_MEMBER.toString(),
							Member.getUserId(), Member.getName(), Member.getPassword(), Member.getSsn()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectAllMember() {
		List<MemberBean> lst = new ArrayList<>();
		
		return lst;
	}

	@Override
	public List<MemberBean> selectMemberByWord(String word) {

		return null;
	}

	@Override
	public MemberBean selectMemberBySeq(String seq) {
		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeQuery(String.format(MemberQuery.SELECT_MEMBER_BY_SEQ.toString(),seq));
			while(rs.next()) {
				m = new MemberBean();
				m.setUserId(rs.getString("MEMID"));
				m.setTeamId(rs.getString("TEAM_ID"));
				m.setName(rs.getString("NAME"));
				m.setSsn(rs.getString("SSN"));
				m.setRoll(rs.getString("ROLL"));
				m.setPassword(rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public int countMember() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateMember(MemberBean bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(MemberBean bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberBean login(MemberBean bean) {
		MemberBean result = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE,DBConstant.USERNAME,DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.LOGIN.toString(),
							bean.getUserId(), bean.getPassword()));
			while (rs.next()){
				result = new MemberBean();
				result.setUserId(rs.getString("MEMID"));
				result.setTeamId(rs.getString("TEAMID"));
				result.setName(rs.getString("NAME"));
				result.setSsn(rs.getString("SSN"));
				result.setRoll(rs.getString("ROLL"));
				result.setPassword(rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
