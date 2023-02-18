package hellothymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloThymeleafController {
    @GetMapping("/")
    public String palautaHtml() {
        // Palauta index.html
        return "index";
    }
    
    @GetMapping("/video")
    public String palautaVideoHtml() {
        // Palauta video.html
        return "video";
    }

}
