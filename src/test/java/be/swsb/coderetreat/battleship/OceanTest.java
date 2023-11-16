package be.swsb.coderetreat.battleship;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OceanTest {

    @Test
    void renderToEmoji_defaultSize_10x10() {
        var ocean = new Ocean();

        assertThat(ocean.renderToEmoji()).isEqualTo(
                """
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );
    }
}