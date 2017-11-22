package be.braek.gpio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PinController {

    private static final String CONTENT_TYPE = "application/vnd.api+json; charset=UTF-8";
    private static final String RESOURCE_NAME = "pins";
    private static final String PATH_LIST = "/" + PinController.RESOURCE_NAME;
    private static final String PATH_DETAIL = PinController.PATH_LIST + "/{id}";

    @ResponseBody
    @RequestMapping(
        path = PinController.PATH_LIST,
        method = RequestMethod.GET,
        produces = PinController.CONTENT_TYPE
    )
    public ResponseEntity list() {
        return ResponseEntity.ok(new Object());
    }

    @ResponseBody
    @RequestMapping(
        path = PinController.PATH_DETAIL,
        method = RequestMethod.GET,
        produces = PinController.CONTENT_TYPE
    )
    public ResponseEntity detail(@PathVariable int id) {
        return ResponseEntity.ok(new Object());
    }

    @ResponseBody
    @RequestMapping(
        path = PinController.PATH_DETAIL,
        method = RequestMethod.PATCH,
        produces = PinController.CONTENT_TYPE,
        consumes = PinController.CONTENT_TYPE
    )
    public ResponseEntity patch(@PathVariable int id) {
        return ResponseEntity.ok(new Object());
    }
}
