package r9k;

import javax.print.attribute.SetOfIntegerSyntax;

public class Room {
	/*
	 * Rooms are connected like this
	 * 1 - 2 - 3 - 4 - 5
	 */
	public static enum roomState {
		 DIRTY,CLEAN;
	}
	
	
	public roomState currentState;
	public int roomNumber;
	
	public Room (roomState state, int no) {
		this.currentState = state;
		this.roomNumber = no;
	}
	
	

	
	public roomState getState() {
		return currentState;
	}
	
	public void setState(Room.roomState theState) {
		currentState = theState;
	}

}
