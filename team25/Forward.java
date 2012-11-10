package team25;

import hockey.api.*;

public class Forward extends BasePlayer {
  public void init() {
    setAimOnStick(true);
  }

  // Number of forward
  public int getNumber() { return 15; }

  // Name of forward
  public String getName() { return "Forward"; }

  // Intelligence of forward
  public void step() {
    if (hasPuck()) {
      IPlayer center = getPlayer(5);
      if (getX() < center.getX() && getX() < 1000)
        shoot(getPlayer(5), 4444); // pass center player
      else
        shoot(GOAL_POSITION, MAX_SHOT_SPEED);
    }
    else {
      skate(getPuck(), MAX_SPEED); // get the puck
    }
  }
}
