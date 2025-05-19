public class ElevatorSystem {
    private Building building;
    public void monitoring(){};
    public void dispatcher(){};

    private ElevatorSystem(){

    }

    private static ElevatorSystem system = null; //initialize only once

    public static ElevatorSystem getInstance(){
        if(system == null) system = new ElevatorSystem();

        return system;
    }
}
