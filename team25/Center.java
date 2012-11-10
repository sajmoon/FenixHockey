package team25;

import hockey.api.*;

public class Center extends BasePlayer {
  public void init() {
    setAimOnStick(true);
  }

  // Number of center player
  public int getNumber() { return 0; }

  // Name of center player
  public String getName() { return "Center"; }

  // Center player's intelligence
  public void step() {
    IPuck puck = getPuck();
    if (hasPuck()) {
      if (getX() < GOAL_POSITION.getX())
        shoot(GOAL_POSITION, MAX_SHOT_SPEED);
      else
        skate(posTowardsGoal(), MAX_SPEED);
    } else {
      skate(getPuck().getX() / 2, getPuck().getY(), 1000);
    }
  }
}
