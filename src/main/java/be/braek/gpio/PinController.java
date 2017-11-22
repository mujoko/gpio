package be.braek.gpio;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PinController {

    private static final String CONTENT_TYPE = "application/vnd.api+json; charset=UTF-8";
    private static final String RESOURCE_NAME = "pins";
    private static final String PATH_LIST = "/" + PinController.RESOURCE_NAME;
    private static final String PATH_DETAIL = PinController.PATH_LIST + "/{id}";
    private Gson gson = new Gson();

    @Autowired
    private List<Pin> pins;

    @ResponseBody
    @RequestMapping(
        path = PinController.PATH_LIST,
        method = RequestMethod.GET,
        produces = PinController.CONTENT_TYPE
    )
    public ResponseEntity list() {
        return ResponseEntity.ok(gson.toJson(new Envelope(pins)));
    }

    private Pin getPinById(int id) {
        for(Pin pin : pins) {
            if(pin.getId() == id)
                return pin;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(
        path = PinController.PATH_DETAIL,
        method = RequestMethod.GET,
        produces = PinController.CONTENT_TYPE
    )
    public ResponseEntity detail(@PathVariable int id) {
        Pin pin = getPinById(id);
        if(pin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gson.toJson(new Envelope(pin)));
    }

    @ResponseBody
    @RequestMapping(
        path = PinController.PATH_DETAIL,
        method = RequestMethod.PATCH,
        produces = PinController.CONTENT_TYPE,
        consumes = PinController.CONTENT_TYPE
    )
    public ResponseEntity patch(
        @PathVariable int id,
        @RequestBody String body
    ) {
        Pin pin = getPinById(id);
        if(pin == null) {
            return ResponseEntity.noContent().build();
        }
        try {
            Envelope envelope = gson.fromJson(body, Envelope.class);
            return ResponseEntity.ok(gson.toJson(new Envelope(pin)));
        } catch(JsonSyntaxException jse) {
            return ResponseEntity.badRequest().build();
        }
    }
}
