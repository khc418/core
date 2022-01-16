package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// member부터 componentScan의 시작위치를 설정한다 / 해당 패키지 포함 하위패치지 모두 탐색
// basePackagesClasses는 해당 클래스의 패키지를 탐색
// 만약 지정하지 않으면 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다
// Configuration이 붙은 건 추가안한다
public class AutoAppCongig {

}
