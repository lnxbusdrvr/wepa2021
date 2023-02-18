package hellorequestparam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloRequestParamController {
    @GetMapping("/hello")
    @ResponseBody
    // metodin nimellÃ ei ole vÃliÃ¤
    // vaan parametrin(param) nimellÃ¤.
    public String tervehdi(@RequestParam String param) {
        return "Hello " + param;
    }

}
