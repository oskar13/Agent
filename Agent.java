package r9k;

import java.util.ArrayList;
import java.util.List;

import r9k.Room.roomState;

public class Agent {
	public static enum sensorData {
		 DIRT,CLEAR,ERROR;
	}
	
	public static enum actions {
		 SUCK, NO_OP, SEARCH_ROOMS;
	}
	
	public List<Integer> uncheckedRooms = new ArrayList();;
	

	
	public int pos;
	public int score;
	
	public actions getAction(Room.roomState state){
		if (state == roomState.DIRTY) {
			return actions.SUCK;
		} else if (uncheckedRooms.size() > 0) {
			return actions.SEARCH_ROOMS;
		} else {
			return actions.NO_OP;
		}
	}
	
	public Boolean performAction (actions plannedAction){
		if (plannedAction == actions.SUCK) {
			score -= 1;
			System.out.println("SUCKING...");
			return true;
		} else if (plannedAction == actions.SEARCH_ROOMS){
			System.out.println("Searching...");
			for (int i = 0; i < uncheckedRooms.size(); i++) {
				//System.out.println(uncheckedRooms.get(i));
				if (uncheckedRooms.get(i)<pos) {
					System.out.println("DIRIVING LEFT");
				} else {
					System.out.println("DRIVING RIGHT");
				}
				score -= 1;
				pos = uncheckedRooms.get(i);
			}
			return true;
			
		} else {
			return false;
		}
		
	}
	
	
	

}
