package azure.lab.springwebapp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class helloDebug {


    Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("info")
    public String getDebug(){
        logger.info("Info Level Logging");
		return "Use /warn/string to return an debug level error in your console logs & use /debug/exec to raise an exception";
		
    }
	
    @GetMapping("warn/{name}")
    public String greeting(@PathVariable String name) {
		logger.debug("Request {}", name);
		if (name.equalsIgnoreCase("exec")) {
			throw new RuntimeException("Debug Level Logging");
		}
		String response = "Hi " + name + " Welcome to the Azure Logging Lab";
		logger.warn("Warning Response {}", response);
		return response;
	}


}