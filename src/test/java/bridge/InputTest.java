package bridge;

import bridge.controller.Controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @DisplayName("다리 길이가 3 미만이면 예외 발생1")
    @Test
    void getBridgeSize1() {
        assertThatThrownBy(() -> new Controller().getInputBridgeSize("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 21 초과면 예외 발생2")
    @Test
    void getBridgeSize2() {
        assertThatThrownBy(() -> new Controller().getInputBridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 이동 Input이 U/D가 아니면 예외 발생1")
    @Test
    void createBridge1() {
        assertThatThrownBy(() -> new Controller().getInputReadMoving("Ua"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 이동 Input이 U/D가 아니면 예외 발생2")
    @Test
    void createBridge2() {
        assertThat(new Controller().getInputReadMoving("D")).isEqualTo("D");
    }
}
