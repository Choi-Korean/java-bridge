package bridge;

import bridge.controller.Controller;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            System.out.println("다리 건너기 게임을 시작합니다.");
            controller.run();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
