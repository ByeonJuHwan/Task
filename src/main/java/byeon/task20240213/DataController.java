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
    public Data data() {
        return new Data(new Result("ok"));
    }


    @GetMapping("/data2")
    public ResponseEntity<Data> data2() {
        return new ResponseEntity<>(new Data(new Result("ok")), HttpStatus.OK);
    }

    @Getter
    @Setter
    static class Result {

        private String result;

        public Result(String result) {
            this.result = result;
        }
    }

    @Getter
    @Setter
    static class Data {
        private Result data;

        public Data(Result result) {
            this.data = result;
        }

    }
}
