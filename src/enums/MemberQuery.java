package enums;

public enum MemberQuery {
	LOGIN, INSERT_MEMBER, SELECT_MEMBER_BY_SEQ;
	@Override
	public String toString() {
		String query ="";
		switch (this) {
		case LOGIN:
			query = "SELECT MEM_ID MEMID,  " + 
					" TEAM_ID TEAMID,  " +
					"	NAME,  " +
					"	SSN,  "	+
					"	 ROLL,  " +
					"	 PASSWORD  " +
					"   FROM MEMBER  "	+
					"   WHERE MEM_ID LIKE '%s' " +
					"   AND PASSWORD LIKE '%s' ";
		break;
		case INSERT_MEMBER:
			query = "INSERT INTO MEMBER    " + 
					"   (MEM_ID, NAME, PASSWORD, SSN)    " +
					"   VALUES    "+
					"   ('%s', '%s', '%s', '%s')";
			break;
		case SELECT_MEMBER_BY_SEQ:
			query = "SELECT MEM_ID MEMID,NAME,SSN,PASSWORD,ROLL FROM MEMBER WHERE MEM_ID LIKE '%s'";
			break;
		default:
			break;
		}
		return query;
	}

}
