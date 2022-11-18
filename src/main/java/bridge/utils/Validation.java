package bridge.utils;

import static bridge.controller.Controller.ERROR_MESSAGE;

public class Validation {

    String error = ERROR_MESSAGE;

    public Integer checkInputRange(String input){
        try {
            if(Integer.parseInt(input) >= 3 && Integer.parseInt(input) <= 20){
                return Integer.parseInt(input);
            }
            throw new IllegalArgumentException(error + "3~20 사이의 숫자를 입력해주세요");
        }catch (Exception e){
            throw new IllegalArgumentException(error + "3~20 사이의 숫자를 입력해주세요");
        }
    }

    public String checkInputMove(String move){
        if(!(move.equals("U") || move.equals("D"))){
            throw new IllegalArgumentException(error + "U(위) 혹은 D(아래)를 입력해주세요");
        }
        return move;
    }
}
