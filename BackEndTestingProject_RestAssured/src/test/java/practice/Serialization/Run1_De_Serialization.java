package practice.Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Run1_De_Serialization {
	//de-Serialization program
	
	public static void main(String[] args) throws  Exception {
		//Read data from file
		FileInputStream input=new FileInputStream("./f.txt");//i wanto get the binary data avilable in the text  file back to java object;
		
		ObjectInputStream objIn=new ObjectInputStream(input);
		objIn.readObject();//using this we de-serialize
		
		NFSGame user1Obj = (NFSGame)objIn.readObject();//it returns obj of same class to read 
		
		System.out.println(user1Obj.name);
		System.out.println(user1Obj.level);
		System.out.println(user1Obj.score);
		System.out.println(user1Obj.life);
	}

}
