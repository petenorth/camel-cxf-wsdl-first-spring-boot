package cc.notsoclever.examples.cxf.wsdlfirst.server;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A spring-boot application that includes a Camel route builder to setup the Camel routes
 */
@SpringBootApplication
public class Application extends RouteBuilder {

    // must have a main method spring-boot can run
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    private static final transient Logger LOG = LoggerFactory.getLogger(Application.class);

    @Override
    public void configure() throws Exception {

        from("cxf:bean:customerServiceEndpoint")
    	//from("cxf:/CustomerServicePort?serviceClass=" + CustomerService.class.getName())
                .to("CustomerServiceProcessor");
    }
}
