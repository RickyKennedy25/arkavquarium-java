package com.arkavquarium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.arkavquarium.models.Data;
import com.arkavquarium.models.Guppy;
import com.arkavquarium.models.Position;
import org.junit.Before;
import org.junit.Test;

public class GuppyTest {

  @Before
  public void prepareMaxWidthHeight() {
    Data.setMaxWidth(10000);
    Data.setMaxHeight(10000);
  }

  @Test
  public void testGuppyConstructor() {
    Guppy g = new Guppy();
    assertEquals(
        "constructed guppy should has starving timer set to zero",
        0, g.getStarvingTimer(),
        0.001
    );
    assertEquals(
        "constructed guppy should has eat counter set to zero",
        0, g.getEatCounter(),
        0.001
    );
  }

  @Test
  public void testGuppyLeftAsset() {
    Guppy g = new Guppy();
    Position pos = new Position(g.getPosition().getAbsis() - 100, g.getPosition().getOrdinate());
    g.moveToDestination(pos, 0.1);
    assertEquals(
        "asset should return left if orientation is left",
        "src/main/resources/img/guppy_left_small.png", g.getAssetPath()
    );
  }

  @Test
  public void testGuppyRightAsset() {
    Guppy g = new Guppy();
    Position pos = new Position(g.getPosition().getAbsis() + 100, g.getPosition().getOrdinate());
    g.moveToDestination(pos, 0.1);
    assertEquals(
        "asset should return right if orientation is right",
        "src/main/resources/img/guppy_right_small.png", g.getAssetPath()
    );
  }

  @Test
  public void testStarvingAsset() {
    Guppy g = new Guppy();
    g.setStarvingTimer(20);
    Position pos = new Position(g.getPosition().getAbsis() - 100, g.getPosition().getOrdinate());
    g.moveToDestination(pos, 0.1);
    assertEquals(
        "asset should show starving asset when starving",
        "src/main/resources/img/guppy_left_small_hungry.png", g.getAssetPath()
    );
  }

  @Test
  public void testGuppyGrowth() {
    Guppy g = new Guppy();
    for (int i = 1; i < 9; i++) {
      g.eat();
    }
    Position pos = new Position(g.getPosition().getAbsis() - 100, g.getPosition().getOrdinate());
    g.moveToDestination(pos, 0.1);
    assertEquals(
        "asset should show second growth stage",
        "src/main/resources/img/guppy_left_medium.png", g.getAssetPath()
    );
    for (int i = 1; i < 7; i++) {
      g.eat();
    }
    Position pos2 = new Position(g.getPosition().getAbsis() - 100, g.getPosition().getOrdinate());
    g.moveToDestination(pos2, 0.1);
    assertEquals(
        "asset should show third growth stage",
        "src/main/resources/img/guppy_left_medium.png", g.getAssetPath()
    );
  }

  @Test
  public void testDeath() {
    Guppy g = new Guppy();
    g.setStarvingTimer(25);
    assertTrue(
        "Guppy should be dead",
        g.isDie()
    );
  }
}