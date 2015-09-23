package r9k;

import java.util.ArrayList;
import java.util.Iterator;

import r9k.Room.roomState;

public class VacuWorld {
	public ArrayList<Room> rooms = new ArrayList<Room>();
	public ArrayList<Agent> agents = new ArrayList<Agent>();
	
	public VacuWorld() {
		
		addAgent(1);
		

		
		rooms.add( new Room(Room.roomState.DIRTY, 1));
		rooms.add( new Room(Room.roomState.DIRTY, 2));

		//rooms.get(1).currentState = roomState.CLEAN;
		
		
		agents.get(0).uncheckedRooms.add(1);
		agents.get(0).uncheckedRooms.add(2);
		
	}
	
	public void addAgent(int agentPos) {
		agents.add(new Agent());
		agents.get(0).pos = agentPos;
	}
	
	public void run(int steps) {
		for (int i =steps;i>0; i--) {
			System.out.println("------------- BEFORE STEP ----------");
			displayWorldState();
			System.out.println("------------------------------------");
			
			Agent.actions currentPlannedAction = agents.get(0).getAction(rooms.get(agents.get(0).pos-1).getState());


			System.out.println("Robot in room: " + agents.get(0).pos);
			System.out.println("State of the room the robot is in: " + rooms.get(agents.get(0).pos-1).getState());
			System.out.println("Currently planned action: " + currentPlannedAction);
			
			if (currentPlannedAction == Agent.actions.SUCK) {
				if (agents.get(0).performAction(currentPlannedAction)) {
					System.out.println("SUCCESS!!!!!1!1");
					rooms.get(agents.get(0).pos-1).setState(Room.roomState.CLEAN);
					//agents.get(0).uncheckedRooms.remove(agents.get(0).pos-1);
					
					
					for (int i1 = 0; i1 < agents.get(0).uncheckedRooms.size(); i1++) {
						//System.out.println(uncheckedRooms.get(i));
						if (agents.get(0).uncheckedRooms.get(i1) == agents.get(0).pos) {
							agents.get(0).uncheckedRooms.remove(i1);
						}
 						
					}
				}
			} else if (currentPlannedAction == Agent.actions.SEARCH_ROOMS) {
				if (agents.get(0).performAction(currentPlannedAction)) {
					System.out.println("SUCCESS!!!!!1!1");

				}
			}
			
			
			agents.get(0).score += rooms.size() - agents.get(0).uncheckedRooms.size();
			
			
			System.out.println("------- AFTER STEP ----------");
			
			displayWorldState();
			
			System.out.println("///////////////////////////////////////////");
		} 
		
		
		
	}
	
	public void displayWorldState() {
        Iterator<Room> it = rooms.iterator();
        while (it.hasNext()) {
        	Room currentRoom = it.next();
        	if (agents.get(0).pos == currentRoom.roomNumber) {
        		System.out.print("ROBOT_0 " + agents.get(0).score + " - ");
        	}
        	
        	System.out.println("Room " + currentRoom.roomNumber + " " + currentRoom.currentState );

	
        }
        
        
        
        
        
        
        
	}
	
	
}
