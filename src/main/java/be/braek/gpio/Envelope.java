package be.braek.gpio;

public class Envelope {

    public Envelope(Object data) {
        setData(data);
    }

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
