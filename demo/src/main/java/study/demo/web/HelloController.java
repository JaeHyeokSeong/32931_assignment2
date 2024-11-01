package study.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) throws InterruptedException {

        Thread.sleep(1000);

        if (name.equals("ex")) {
            throw new RuntimeException();
        }
        return "hello " + name;
    }
}
