package com.arkavquarium.tests;

import static org.junit.Assert.assertEquals;

import com.arkavquarium.models.Data;
import com.arkavquarium.models.Position;
import com.arkavquarium.models.Snail;
import org.junit.Before;
import org.junit.Test;

public class SnailTest {

  @Before
  public void prepareMaxWidthHeight() {
    Data.setMaxWidth(10000);
    Data.setMaxHeight(10000);
  }

  @Test
  public void testPositionConstructor() {
    Snail s = new Snail();
    assertEquals(
        "ordinate constructed equals to 9/10 max height",
        9000,
        s.getPosition().getOrdinate(),
        Position.getTolerance()
    );
    Data.setMaxHeight(1000);
    s = new Snail();
    assertEquals(
        "ordinate constructed equals to 9/10 max height",
        900,
        s.getPosition().getOrdinate(),
        Position.getTolerance()
    );
  }

  @Test
  public void testSnailLeftAsset() {
    Snail s = new Snail();
    Position p = 
        new Position(
            s.getPosition().getAbsis() - 100,
            s.getPosition().getOrdinate()
        );
    s.moveToDestination(p, 0.1);
    assertEquals(
        "asset should return left if orientation is left",
        "src/main/resources/img/snail_left.png",
        s.getAssetPath()
    );
  }

  @Test
  public void testSnailRightAsset() {
    Snail s = new Snail();
    Position p = 
        new Position(
            s.getPosition().getAbsis() + 100,
            s.getPosition().getOrdinate()
        );
    s.moveToDestination(p, 0.1);
    assertEquals(
        "asset should return right if orientation is right",
        "src/main/resources/img/snail_right.png",
        s.getAssetPath()
    );
  }
}