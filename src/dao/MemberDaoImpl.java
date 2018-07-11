package dao;

import java.util.*;
import domain.*;
import java.sql.*;

public class MemberDaoImpl implements MemberDao {
	private static MemberDao instance = new MemberDaoImpl();

	public static MemberDao getInstance() {
		return instance;
	}

	private MemberDaoImpl() {
	}

	@Override
	public void insertMember(MemberBean Member) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MemberBean> selectAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberBean> selectMemberByWord(String word) {
		System.out.println(word);
		return null;
	}

	@Override
	public MemberBean selectMemberBySeq(String seq) {
		// TODO Auto-generated method stub
		return null;
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
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "seini144", "password");
			Statement stmt = conn.createStatement();
			String sql = String.format(
					"SELECT MEM_ID MEMID,  " + 
					" TEAM_ID TEAMID,  " +
					"	NAME,  " +
					"	AGE,  "	+
					"	 ROLL,  " +
					"	 PASSWORD  " +
					"   FROM MEMBER  "	+
					"   WHERE MEM_ID LIKE '%s' " +
					"   AND PASSWORD LIKE '%s' ",
					bean.getUserId(), bean.getPassword());
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				result = new MemberBean();
				result.setUserId(rs.getString("MEMID"));
				result.setTeamId(rs.getString("TEAMID"));
				result.setName(rs.getString("NAME"));
				result.setAge(rs.getString("AGE"));
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
