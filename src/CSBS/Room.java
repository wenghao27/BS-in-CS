package CSBS;
import java.awt.Point;

/*
 * This is the room class. Which save the room.
 */
public class Room {
    private int ID;
    private Point Location;
    private String Name;
    public Room(int id){
        ID = id;
    }
    
    public void SetData(Point loc,String name){
    	Location = loc;
    	Name = name;
    }
    
    public String getName(){
    	return Name;
    }
    
    public Point getLocation(){
    	return Location;
    }
    
    public int getID(){
    	return ID;
    }
    
    public String toString(){
    	if(ID!=-1)
    		return Name;
    	return "";
    }
}
