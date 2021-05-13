/*
 * "yu-gi-oop" (c) by Ignacio Slater M.
 * "yu-gi-oop" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.cc3002.yugioop;

import cl.uchile.dcc.cc3002.yugioop.cards.BackrowCard;
import cl.uchile.dcc.cc3002.yugioop.cards.monsters.MonsterCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 */
public class GameMat {
  private final Player player;
  private final List<MonsterCard> monsters = new ArrayList<>();
  private final List<BackrowCard> backrow = new ArrayList<>();

  public GameMat(Player player) {
    this.player = player;
  }

  @Override
  public int hashCode() {
    return Objects.hash(GameMat.class, player);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof GameMat) {
      var other = (GameMat) obj;
      return player.equals(other.player);
    }
    return false;
  }

  @Override
  public String toString() {
    return "PlayerMat{\n\t" + player.toString() + ",\n\t" + monsters.toString() + ",\n\t"
           + backrow.toString() + "\n}";
  }

  public List<MonsterCard> getMonsters() {
    return List.copyOf(monsters);
  }

  public List<BackrowCard> getBackrow() {
    return List.copyOf(backrow);
  }
}