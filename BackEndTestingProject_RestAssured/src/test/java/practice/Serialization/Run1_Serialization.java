package practice.Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable {
	//serialization program
	
	String name;
	int level;
	long score;
	int life;
	
	public NFSGame(String name, int level, long score, int life) {
		super();
		
		this.name=name;
		this.level=level;
		this.score=score;
		this.life=life;
	}
}

public class Run1_Serialization {
	
	public static void main(String[] args) throws IOException {
		
		NFSGame user1Obj = new NFSGame("tss", 10, 50000, 2);//day 1 score now i should store this 
		//i wanto convert this java obj to binary data ; 
		
		FileOutputStream fileout=new FileOutputStream("./f.txt");//inside current directory create file in .text formate and store data
		//convert java object to binary ,we need to create object to obj output stream
		
		ObjectOutputStream  objout=new ObjectOutputStream(fileout);
		objout.writeObject(user1Obj);
		
		System.out.println("======END======");
		
		
	}

}
