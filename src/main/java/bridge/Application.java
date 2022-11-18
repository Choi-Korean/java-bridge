package bridge;

import bridge.controller.Controller;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.start();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
