public class Bus extends Vehicle {
    private int waitTicks;
    private Crossing origin;
    private Crossing destination;
    private BusDriver owner;

    public void waitToClear(){}
    public void resumeRoute(){}
    public void checkArrival(){}
    public void setWaitTicks(int t){waitTicks = t;}


}
