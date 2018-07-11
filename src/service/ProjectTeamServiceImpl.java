package service;

import java.util.List;
import domain.ProjectTeamBean;

public class ProjectTeamServiceImpl implements ProjectTeamService{
	private static ProjectTeamService instance = new ProjectTeamServiceImpl();
	public static ProjectTeamService getInstance() {return instance;}
	private ProjectTeamServiceImpl() {}
	@Override
	public void createProjectTeam(ProjectTeamBean ProjectTeam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ProjectTeamBean> listProjectTeam() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProjectTeamBean> findProjectTeamByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProjectTeamBean findProjectTeamBySeq(String seq) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countProjectTeam() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifyProjectTeam(ProjectTeamBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeProjectTeam(ProjectTeamBean bean) {
		// TODO Auto-generated method stub
		
	}

}
