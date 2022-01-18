package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
//    private final ObjectProvider<MyLogger> myLoggersProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        // HttpServletRequest로 고객요청정보 확인가능
        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger= myLoggersProvider.getObject();
        System.out.println("myLogger = " + myLogger.getClass());
        // 실제 호출하는 시점에 진짜를 찾아서 동작
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
//        Thread.sleep(1000);
        logDemoService.logic("testId");
        return "OK";
    }
}
