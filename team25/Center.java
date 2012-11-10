package team25;

public class Center extends BasePlayer {
  // Number of center player
  public int getNumber() { return 0; }

  // Name of center player
  public String getName() { return "Center"; }

  // Center player's intelligence
  public void step() {
    if (hasPuck()) {
      if (getX() < GOAL_POSITION.getX())
        shoot(GOAL_POSITION, MAX_SHOT_SPEED);
      else
        skate(posTowardsGoal(), MAX_SPEED);
    } else {
      skate(0, getPuck().getY(), 1000);
    }
  }
}
