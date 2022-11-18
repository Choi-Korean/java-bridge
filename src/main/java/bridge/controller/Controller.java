package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.utils.Validation;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    public static final String ERROR_MESSAGE = "[ERROR]";
    InputView input = new InputView();
    OutputView output = new OutputView();
    BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bg;
    Validation validation = new Validation();
    List<String> top;
    List<String> bottom;

    public void start(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        bg = new BridgeGame(bm.makeBridge(getInputBridgeSize(input.readBridgeSize())));
        run();
    }

    public void run(){
        String result = "O";
        String move;
        top = new ArrayList();
        bottom = new ArrayList();

        for(int i = 0; i < bg.getBridge().size(); i++){
            move = getInputReadMoving(input.readMoving());
            result = bg.move(move);
            if(move.equals("U")){
                top.add(result);
                bottom.add(" ");
            }

            if(move.equals("D")){
                top.add(" ");
                bottom.add(result);
            }

            output.printMap(top, bottom);
            if(result.equals("X")){
                break;
            }

        }

        if(result.equals("O")){
            return;
        }

        String command = getInputReadGameCommand(input.readGameCommand());
        if(command.equals("Q")){
            return;
        }

        if(command.equals("R")){
            bg.retry();
            run();
        }

    }

    public Integer getInputBridgeSize(String input){
        return validation.checkInputRange(input);
    }

    public String getInputReadMoving(String input){
        return validation.checkInputMove(input);
    }

    public String getInputReadGameCommand(String input){
        return validation.checkInputCommand(input);
    }
}
