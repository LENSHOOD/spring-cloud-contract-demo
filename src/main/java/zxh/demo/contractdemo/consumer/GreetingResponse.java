package zxh.demo.contractdemo.consumer;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Tolerate;

import java.time.Instant;

/**
 * GreetingResponse:
 * @author zhangxuhai
 * @date 2019-10-08
*/
@Data
@ToString
@Builder
public class GreetingResponse {
    private String name;
    private String content;
    private Instant time;

    @Tolerate
    public GreetingResponse() {
        // empty
    }
}
