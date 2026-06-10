package practice.Serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

//IN THIS CLASS I USED JSON ANNOTATIONS AND CREATED POJO CLASS 

//i wanto execute in this order so i am using jsonPropertyOrder

@JsonPropertyOrder({
	                   "createdBy",
	                   "projectName",
	                    "teamSize",
	                     "status"
})
//i wanto ignore team size (in output i dont want team size )
@JsonIgnoreProperties(
		    value = {
		    		"teamSize"
		    },allowSetters = true
		)

class Project {  //POJO Class [Plain old java Object ]
	
	private String projectName;
	
	@JsonProperty(value = "Created By")//in json file it leave space and shows like this
	private String createdBy;//this is java obj so it not allow to keep spaces but in "created By"i want like this so in json i use @jsonProperty;
	private int teamSize;
	private String status;
	
	//create one empty Constructor for de-serialization 
	private Project() {}
	
	public Project (String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}

	//Getters and setters method
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

public class Run1_JacksonSerializationTest {
	
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		//java obj
		Project pObj = new Project("Orange", "tss", 0, "Created");
		
		//this object mapper must be imported from jackson 
		ObjectMapper objM=new ObjectMapper();//converting java obj to json
		
		objM.writeValue(new File("./project.json"),objM);//entire java object converted into json object serialization/marrsh
		
		System.out.println("====END===");
		
		}

	}
