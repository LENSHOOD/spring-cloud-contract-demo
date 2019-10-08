package zxh.demo.contractdemo.producer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import zxh.demo.contractdemo.consumer.GreetingResponse;

import java.time.Instant;

/**
 * Greeting:
 * @author zhangxuhai
 * @date 2019-10-08
*/
@RestController
@RequestMapping("/producer")
public class Greeting {

    @GetMapping("/greeting")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GreetingResponse> sayGreeting(String name) {
        return Mono.just(GreetingResponse
                .builder()
                .name(name)
                .content("Greetings!")
                .time(Instant.now())
                .build());
    }
}
