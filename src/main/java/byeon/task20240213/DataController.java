package byeon.task20240213;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @GetMapping("/data")
    public Form data() {
        return new Form(new Data("ok"));
    }


    @GetMapping("/data2")
    public ResponseEntity<Form> data2() {
        return new ResponseEntity<>(new Form(new Data("ok")), HttpStatus.OK);
    }

    @Getter
    @Setter
    static class Data {

        private String result;

        public Data(String result) {
            this.result = result;
        }
    }

    @Getter
    @Setter
    static class Form {
        private Data data;

        public Form(Data data) {
            this.data = data;
        }

    }
}
