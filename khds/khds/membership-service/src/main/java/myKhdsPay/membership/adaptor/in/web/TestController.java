package myKhdsPay.membership.adaptor.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test")
    public String test(){
        return "이것은 테스트 입니다.";
    }
}
