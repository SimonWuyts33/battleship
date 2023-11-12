package be.swsb.coderetreat.battleship;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.battleship.Orientation.HORIZONTAL;
import static be.swsb.coderetreat.battleship.Orientation.VERTICAL;
import static be.swsb.coderetreat.battleship.Position.pos;
import static be.swsb.coderetreat.battleship.ShipType.*;
import static org.assertj.core.api.Assertions.assertThat;


class ShipTest {

    @Nested
    class CreateShips {

        @Test
        void createCarrierHorizontally() {

            var ship = Ship.create(CARRIER, pos(1, 1), HORIZONTAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(5)
                    .containsExactlyInAnyOrder(pos(1, 1), pos(2, 1), pos(3, 1), pos(4, 1), pos(5, 1));
        }

        @Test
        void createCarrierVertically() {
            var ship = Ship.create(CARRIER, pos(2, 1), VERTICAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(5)
                    .containsExactlyInAnyOrder(pos(2, 1), pos(2, 2), pos(2, 3), pos(2, 4), pos(2, 5));
        }

        @Test
        void createBattleshipHorizontally() {
            var ship = Ship.create(BATTLESHIP, pos(1, 1), HORIZONTAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(4)
                    .containsExactlyInAnyOrder(pos(1, 1), pos(2, 1), pos(3, 1), pos(4, 1));
        }

        @Test
        void createBattleshipVertically() {
            var ship = Ship.create(BATTLESHIP, pos(2, 1), VERTICAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(4)
                    .containsExactlyInAnyOrder(pos(2, 1), pos(2, 2), pos(2, 3), pos(2, 4));
        }

        @Test
        void createDestroyerHorizontally() {
            var ship = Ship.create(DESTROYER, pos(1, 1), HORIZONTAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(3)
                    .containsExactlyInAnyOrder(pos(1, 1), pos(2, 1), pos(3, 1));
        }

        @Test
        void createDestroyerVertically() {
            var ship = Ship.create(DESTROYER, pos(2, 1), VERTICAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(3)
                    .containsExactlyInAnyOrder(pos(2, 1), pos(2, 2), pos(2, 3));
        }

        @Test
        void createSubmarineHorizontally() {
            var ship = Ship.create(SUBMARINE, pos(1, 1), HORIZONTAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(3)
                    .containsExactlyInAnyOrder(pos(1, 1), pos(2, 1), pos(3, 1));
        }

        @Test
        void createSubmarineVertically() {
            var ship = Ship.create(SUBMARINE, pos(2, 1), VERTICAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(3)
                    .containsExactlyInAnyOrder(pos(2, 1), pos(2, 2), pos(2, 3));
        }

        @Test
        void createPatrolBoatHorizontally() {
            var ship = Ship.create(PATROL_BOAT, pos(1, 1), HORIZONTAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(2)
                    .containsExactlyInAnyOrder(pos(1, 1), pos(2, 1));
        }

        @Test
        void createPatrolBoatVertically() {
            var ship = Ship.create(PATROL_BOAT, pos(2, 1), VERTICAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(2)
                    .containsExactlyInAnyOrder(pos(2, 1), pos(2, 2));
        }
    }
}
