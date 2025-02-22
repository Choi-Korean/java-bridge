package bridge.view;

import java.util.HashMap;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    
    HashMap<String, String> result = new HashMap<>(){{
        put("O", "성공");
        put("X", "실패");
    }};

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> top, List<String> bottom) {
        System.out.println("[ " + String.join(" | ", top) + " ]");
        System.out.println("[ " + String.join(" | ", bottom) + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, String result, List<String> top, List<String> bottom) {
        System.out.println("최종 게임 결과");
        printMap(top, bottom);
        System.out.printf("게임 성공 여부: %s%n", this.result.get(result));
        System.out.printf("총 시도한 횟수: %d", count);
    }
}
