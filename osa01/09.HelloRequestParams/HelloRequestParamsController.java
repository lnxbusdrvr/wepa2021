package hellorequestparams;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloRequestParamsController {
    @GetMapping("/hello")
    @ResponseBody
    public String foo(@RequestParam String param) {
        return "Hello "+param;
    }
    
    @GetMapping("/params")
    @ResponseBody
    public String foo(@RequestParam Map<String, String> params) {
        return params.keySet().toString();
    }

}

