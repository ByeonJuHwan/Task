package byeon.task20240213.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestResult<T> {
    private T data;
}
