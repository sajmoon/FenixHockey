package team25;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;

public class Team implements ITeam {
  // Team Short Name.  Max 4 characters.
  public String getShortName() { return "FNX"; }

  // Team Name
  public String getTeamName() { return "Fenixorden"; }

  // Team color; body color
  public Color getTeamColor() { return Color.RED; }

  // Team color; helmet color.
  public Color getSecondaryTeamColor() { return Color.BLACK; }

  // The team's LUCKY NUMBER!!
  public int getLuckyNumber() { return 43; }

  // Get the goal keeper of the team.
  public GoalKeeper getGoalKeeper() { return new Goalie(); }

  // Get the other five players of the team.
  public Player getPlayer(int index) {
    switch (index) {
      case 1: return new Defender(); // Left defender
      case 2: return new Defender(); // Right defender
      case 3: return new Forward(); // Left forward
      case 4: return new Forward(); // Right forward
      case 5: return new Center(); // Center
    }
    return null;
  }
}
