package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeMaker;
import bridge.utils.Validation;
import bridge.view.InputView;

public class Controller {

    public static final String ERROR_MESSAGE = "[ERROR]";
    InputView input = new InputView();
    BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
    Validation validation = new Validation();

    public void run(){
        System.out.println(bm.makeBridge(validation.checkInputRange(input.readBridgeSize())));
    }
}
