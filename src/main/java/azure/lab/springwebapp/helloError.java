package azure.lab.springwebapp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// This annotation allows Any method in class served as a rest contoller
// anything in the class can be consumed all endpoints in this class

@RequestMapping("/")
@RestController
public class helloError {

    Logger logger = LoggerFactory.getLogger(helloError.class);


    @GetMapping("err")
    public List<String> getError() {
        logger.error("Error Level Logging");
        return List.of("Hello","Error");
    }

    @GetMapping("trace")
    public String getTrace(){
        logger.trace("Trace Level Logging");
        return "Hello Trace Level Log";
    }
}