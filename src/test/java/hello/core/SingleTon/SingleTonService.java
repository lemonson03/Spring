package hello.core.SingleTon;

public class SingleTonService {

private static final SingleTonService SINGLE_TON = new SingleTonService();

public static SingleTonService getInstance() {
    return SINGLE_TON;
}
private SingleTonService() {

}
public void logic(){
    System.out.println("logic");
}
}
