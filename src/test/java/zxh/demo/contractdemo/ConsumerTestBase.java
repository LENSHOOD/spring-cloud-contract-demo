package zxh.demo.contractdemo;

import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

/**
 * ConsumerTestBase:
 * @author zhangxuhai
 * @date 2019-10-09
*/
@AutoConfigureWireMock(port = 7070, stubs = "file:build/stubs/META-INF/**/mappings/**/*.json")
public abstract class ConsumerTestBase extends ContractDemoApplicationTests{
}
