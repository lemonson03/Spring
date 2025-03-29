package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

public class SingletonBeanFind {

    @Test
    void SignleTonbeanfind(){

    }
    @Scope
    static class Singleton(){
        @PostConstruct
        void init(){
            System.out.println("Singleton init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("Singleton destroy");
        }
    }
}
