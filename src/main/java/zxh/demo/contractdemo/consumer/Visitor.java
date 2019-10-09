package zxh.demo.contractdemo.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Visitor:
 * @author zhangxuhai
 * @date 2019-10-08
*/
@RestController
@RequestMapping("/consumer")
public class Visitor {

    @Value("${producer.path}")
    private String producerPath;

    @GetMapping("/visit")
    public Mono<String> visit(String name) {
        return WebClient
                .builder()
                .baseUrl(producerPath)
                .build()
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/producer/greeting")
                                .queryParam("name", name)
                                .build())
                .retrieve()
                .bodyToMono(GreetingResponse.class)
                .map(GreetingResponse::toString);
    }
}
