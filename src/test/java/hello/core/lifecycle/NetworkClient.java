package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {

    private String url;
    public NetworkClient(String url) {
        this.url = url;
        System.out.println(url+ "생성자 호출");
        connect();
        call("초기화 연결 메세지");
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void connect(){
        System.out.println(url);
    }
    public void call(String message){
        System.out.println(url+"call" + message);

    }
    public void disconnect(){
        System.out.println("close" + url);
    }
    @PostConstruct
 public void init(){
        System.out.println("init" + url);
        connect();
        call(url);
 }
 @PreDestroy
 public void close(){
        System.out.println("close" + url);
        disconnect();
 }

}
