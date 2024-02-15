package byeon.task20240213.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class RestError {

    private HttpStatus code;
    private String message;
}
