package HelloApp;

public class HelloImpl extends HelloPOA {
    @Override
    public String sayHello() {
        return "Hello, CORBA!";
    }
}
