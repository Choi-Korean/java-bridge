package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.utils.Validation;
import bridge.view.InputView;

public class Controller {

    public static final String ERROR_MESSAGE = "[ERROR]";
    InputView input = new InputView();
    BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bg;
    Validation validation = new Validation();

    public void start(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        bg = new BridgeGame(bm.makeBridge(getInputBridgeSize(input.readBridgeSize())));
        run();
    }

    public void run(){
        boolean result = true;

        for(int i = 0; i < bg.getBridge().size(); i++){
            if(!bg.move(getInputReadMoving(input.readMoving()))){
                result = false;
                break;
            }
        }

        if(result){
            return;
        }
        bg.retry();
        run();
//        if(input.readGameCommand())

    }

    public Integer getInputBridgeSize(String input){
        return validation.checkInputRange(input);
    }

    public String getInputReadMoving(String input){
        return validation.checkInputMove(input);
    }
}
