package be.swsb.coderetreat.battleship;

import be.swsb.coderetreat.battleship.domain.Ship;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.battleship.domain.Orientation.HORIZONTAL;
import static be.swsb.coderetreat.battleship.domain.Orientation.VERTICAL;
import static be.swsb.coderetreat.battleship.domain.Position.pos;
import static be.swsb.coderetreat.battleship.domain.ShipPositionHealth.*;
import static be.swsb.coderetreat.battleship.domain.ShipType.*;
import static org.assertj.core.api.Assertions.assertThat;


class ShipTest {

    @Nested
    class ShipHealth {
        Ship ship = Ship.create(SUBMARINE, pos(1, 1), HORIZONTAL);

        @Test
        void shipIsCreatedHealth() {
            assertThat(ship.healthAt(pos(1, 1))).isSameAs(OK);
            assertThat(ship.healthAt(pos(1, 2))).isSameAs(OK);
            assertThat(ship.healthAt(pos(1, 3))).isSameAs(OK);

            assertThat(ship.healthAt(pos(1, 4))).isNull();
        }

        @Test
        void ship_damagedAfterHit() {
            ship.damageAt(pos(1, 2));

            assertThat(ship.healthAt(pos(1, 1))).isSameAs(OK);
            assertThat(ship.healthAt(pos(1, 2))).isSameAs(DAMAGED);
            assertThat(ship.healthAt(pos(1, 3))).isSameAs(OK);
        }

        @Test
        void ship_sunkAfterHit() {
            ship.damageAt(pos(1, 1));
            ship.damageAt(pos(1, 2));

            assertThat(ship.healthAt(pos(1, 1))).isSameAs(DAMAGED);
            assertThat(ship.healthAt(pos(1, 2))).isSameAs(DAMAGED);
            assertThat(ship.healthAt(pos(1, 3))).isSameAs(OK);

            ship.damageAt(pos(1, 3));

            assertThat(ship.healthAt(pos(1, 1))).isSameAs(SUNK);
            assertThat(ship.healthAt(pos(1, 2))).isSameAs(SUNK);
            assertThat(ship.healthAt(pos(1, 3))).isSameAs(SUNK);

            assertThat(ship.healthAt(pos(1, 4))).isNull();
        }
    }

    @Nested
    class CreateShips {

        @Test
        void createCarrierHorizontally() {

            var ship = Ship.create(CARRIER, pos(1, 1), HORIZONTAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(5)
                    .containsExactlyInAnyOrder(pos(1, 1), pos(1, 2), pos(1, 3), pos(1, 4), pos(1, 5));
        }

        @Test
        void createCarrierVertically() {
            var ship = Ship.create(CARRIER, pos(1, 2), VERTICAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(5)
                    .containsExactlyInAnyOrder(pos(1, 2), pos(2, 2), pos(3, 2), pos(4, 2), pos(5, 2));
        }

        @Test
        void createBattleshipHorizontally() {
            var ship = Ship.create(BATTLESHIP, pos(1, 1), HORIZONTAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(4)
                    .containsExactlyInAnyOrder(pos(1, 1), pos(1, 2), pos(1, 3), pos(1, 4));
        }

        @Test
        void createBattleshipVertically() {
            var ship = Ship.create(BATTLESHIP, pos(1, 2), VERTICAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(4)
                    .containsExactlyInAnyOrder(pos(1, 2), pos(2, 2), pos(3, 2), pos(4, 2));
        }

        @Test
        void createDestroyerHorizontally() {
            var ship = Ship.create(DESTROYER, pos(1, 1), HORIZONTAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(3)
                    .containsExactlyInAnyOrder(pos(1, 1), pos(1, 2), pos(1, 3));
        }

        @Test
        void createDestroyerVertically() {
            var ship = Ship.create(DESTROYER, pos(1, 2), VERTICAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(3)
                    .containsExactlyInAnyOrder(pos(1, 2), pos(2, 2), pos(3, 2));
        }

        @Test
        void createSubmarineHorizontally() {
            var ship = Ship.create(SUBMARINE, pos(1, 1), HORIZONTAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(3)
                    .containsExactlyInAnyOrder(pos(1, 1), pos(1, 2), pos(1, 3));
        }

        @Test
        void createSubmarineVertically() {
            var ship = Ship.create(SUBMARINE, pos(1, 2), VERTICAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(3)
                    .containsExactlyInAnyOrder(pos(1, 2), pos(2, 2), pos(3, 2));
        }

        @Test
        void createPatrolBoatHorizontally() {
            var ship = Ship.create(PATROL_BOAT, pos(1, 1), HORIZONTAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(2)
                    .containsExactlyInAnyOrder(pos(1, 1), pos(1, 2));
        }

        @Test
        void createPatrolBoatVertically() {
            var ship = Ship.create(PATROL_BOAT, pos(1, 2), VERTICAL);

            assertThat(ship).isExactlyInstanceOf(Ship.class);
            assertThat(ship.positions())
                    .hasSize(2)
                    .containsExactlyInAnyOrder(pos(1, 2), pos(2, 2));
        }
    }
}
