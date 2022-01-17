package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// implements InitializingBean, DisposableBean
public class NetworkClient{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }
/*
    // 의존관계주입이 끝나면 호출
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }

    // 종료시
    @Override
    public void destroy() throws Exception {
        disconnect();
    }*/

    // 의존관계주입이 끝나면 호출
    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메시지");
    }

    // 종료시
    @PreDestroy
    public void close() {
        disconnect();
    }
}
