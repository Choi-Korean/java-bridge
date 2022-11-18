package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeMaker;
import bridge.view.InputView;

public class Controller {

    InputView input = new InputView();
    BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run(){
        System.out.println(bm.makeBridge(input.readBridgeSize()));
    }
}
