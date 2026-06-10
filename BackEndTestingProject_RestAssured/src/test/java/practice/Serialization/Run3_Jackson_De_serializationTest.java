package practice.Serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Run3_Jackson_De_serializationTest {
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		//here we converting back json object into java object De-serialization
		ObjectMapper objM=new ObjectMapper();
		
		Project pObj = objM.readValue(new File("./project.json"), Project.class);//it accepts 2 values 1)location of file import using fileobj 2)name of pojo cls
		
		System.out.println(pObj.getProjectName());
		System.out.println(pObj.getTeamSize());
		System.out.println(pObj.getStatus());
		System.out.println(pObj.getCreatedBy());
	}
	
}