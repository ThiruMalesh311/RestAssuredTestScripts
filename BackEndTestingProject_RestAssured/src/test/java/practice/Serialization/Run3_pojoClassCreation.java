package practice.Serialization;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


class Project1 {

	String projectName;
	String projectStatus;
	int teamSize;
	List<String> teamMember;
	ProjectManager projectManager;

	public Project1(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {

		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public List<String> getTeamMember() {
		return teamMember;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}
}

class ProjectManager {

	String name;
	String empId;

	public ProjectManager(String name, String empId) {
		this.name = name;
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public String getEmpId() {
		return empId;
	}
}

public class Run3_pojoClassCreation {

	public static void main(String[] args) throws Exception {

		List<String> lst = new ArrayList<>();
		lst.add("Jhon");
		lst.add("devid");
		lst.add("Stev");

		ProjectManager pm = new ProjectManager("sagar", "tp01");

		Project1 projectObj = new Project1("Deepak", "Created", 3, lst, pm);

		ObjectMapper objM = new ObjectMapper();

		objM.writeValue(new File("./Project1.json"), projectObj);

		System.out.println("JSON created successfully");
	}
}
//here we get to know how to create POJO class for an object and by taking help of pojo class how to covert back to json file
