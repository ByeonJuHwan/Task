package byeon.task20240213;

import byeon.task20240213.common.Form;
import byeon.task20240213.common.RestError;
import byeon.task20240213.common.RestResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class SampleController {


    @GetMapping("/api/1") // 단건인 경우
    public ResponseEntity<RestResult<Form>> data1() {
        Form form = new Form("byeon", 10);
        return new ResponseEntity<>(new RestResult<>(form), OK);
    }

    @GetMapping("/api/2") // 다중
    public ResponseEntity<RestResult<List<Form>>> data2() {
        List<Form> collct = new ArrayList<>();
        Form form  = new Form("byeon", 10);
        Form form2 = new Form("test", 20);

        collct.add(form);
        collct.add(form2);

        return new ResponseEntity<>(new RestResult<>(collct), OK);
    }

    @GetMapping("/api/error")
    public ResponseEntity<RestError> error() {
        try {
            throw new RuntimeException("test");
        } catch (RuntimeException e) {
            RestError restError = new RestError(INTERNAL_SERVER_ERROR, e.getMessage());
            return new ResponseEntity<>(restError, INTERNAL_SERVER_ERROR);
        }
    }
}
