package hello.core;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@RequiredArgsConstructor
public class HelloLombok {
    private String name;
    private int age;
public void main(String[] arvs) {
HelloLombok helloLombok = new HelloLombok();
helloLombok.setName("hyunbin");
String name = helloLombok.getName();
System.out.println("Hello Lombok " + name);
    }
}
