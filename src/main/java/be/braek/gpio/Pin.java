package be.braek.gpio;

public class Pin {

    private int id;

    private int address;

    private int state;

    public Pin(int id, int address, int state) {
        setId(id);
        setAddress(address);
        setState(state);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
