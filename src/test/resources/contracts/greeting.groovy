package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()
        urlPath("/producer/greeting") {
            queryParameters {
                parameter 'name' : value('test-user')
            }
        }

    }

    response {
        status OK()
        body([
                name : 'test-user',
                content : 'Greetings!',
                time : $(anyIso8601WithOffset()),
        ])
    }
}