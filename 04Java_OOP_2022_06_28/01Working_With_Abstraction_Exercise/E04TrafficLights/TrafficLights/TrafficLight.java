package TrafficLights;

public class TrafficLight {
    private Signal signal;

    public TrafficLight(Signal signal) {
        this.signal = signal;
    }

    public Signal getSignal() {
        return this.signal;
    }

    public void changeSignal() {
        String currentLight = this.signal.name();

        switch (currentLight) {
            case "RED":
                this.signal = Signal.GREEN;
                break;
            case "GREEN":
                this.signal = Signal.YELLOW;
                break;
            case "YELLOW":
                this.signal = Signal.RED;
                break;
        }
    }

}