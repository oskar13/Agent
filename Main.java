package r9k;

public class Main {
	
	public static VacuWorld world;
	
	public static void main(String[] args) {
		
		world = new VacuWorld();
		world.run(10); //Number of steps for simulation
		
	}

}
