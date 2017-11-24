package be.braek.gpio;

public class Pin {

    private String id;

    private int address;

    private int state;

    public Pin(int id, int address, int state) {
        setId(String.valueOf(id));
        setAddress(address);
        setState(state);
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
