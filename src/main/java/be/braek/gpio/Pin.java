package be.braek.gpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Pin {

    private int id;
    private GpioPinDigitalOutput output;

    public Pin(GpioController gpio, int id, int address) {
        this.id = id;
        output = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(address));
        setState(output.getState().getValue());
    }

    public int getAddress() {
        return 0;
    }

    public int getState() {
        return output.getState().getValue();
    }

    public void setState(int state) {
        PinState pinState = state == 1 ? PinState.HIGH : PinState.LOW;
        output.setState(pinState);
    }

    public int getId() {
        return id;
    }
}
