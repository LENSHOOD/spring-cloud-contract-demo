package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()
        urlPath("/producer/greeting") {
            queryParameters {
                parameter 'name' : $(producer('test-user'), consumer("consumer"))
            }
        }
    }

    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body([
                name : $(producer('test-user'), consumer('consumer')),
                content : 'Greetings!',
                time : $(anyIso8601WithOffset()),
        ])
    }
}