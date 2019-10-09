package zxh.demo.contractdemo.consumer;

import org.hamcrest.Matchers;
import org.junit.Test;
import zxh.demo.contractdemo.ConsumerTestBase;

import static io.restassured.RestAssured.given;

/**
 * VisitorTest:
 * @author zhangxuhai
 * @date 2019-10-09
*/
public class VisitorTest extends ConsumerTestBase {

    @Test
    public void validate_visit() {
        given()
                .param("name", "consumer")
        .when()
                .get("consumer/visit")
        .then()
                .statusCode(200)
                .body("name", Matchers.is("consumer"));
    }

}
