package byeon.task20240213;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DataController {

    private final Environment environment;

    @Value("${mode}")
    private String mode;

    @GetMapping("/data")
    public Form data() {
        log.debug("/data mode: {}", mode);
        log.info("/data mode: {}", mode);
        return new Form(new Data("ok", getActiveProfile()));
    }


    @GetMapping("/data2")
    public ResponseEntity<Form> data2() {
        return new ResponseEntity<>(new Form(new Data("ok", getActiveProfile())), HttpStatus.OK);
    }

    @Getter
    @Setter
    static class Data {

        private String result;
        private String profile;

        public Data(String result, String profile) {
            this.result = result;
            this.profile = profile;
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

    private String getActiveProfile() {

        // 첫번째 것만 리턴하자.
        String profile = "";
        for (String activeProfile : environment.getActiveProfiles()) {
            profile = activeProfile;
            break;
        }
        return profile;
    }
}
