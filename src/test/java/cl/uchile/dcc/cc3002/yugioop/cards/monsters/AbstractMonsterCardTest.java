/*
 * "yu-gi-oop" (c) by Ignacio Slater M.
 * "yu-gi-oop" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.cc3002.yugioop.cards.monsters;

import cl.uchile.dcc.cc3002.yugioop.AbstractNamedElementTest;
import cl.uchile.dcc.cc3002.yugioop.cards.factories.MonsterCardFactory;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 */
public abstract class AbstractMonsterCardTest
    extends AbstractNamedElementTest<MonsterCard> {
  protected int level;
  protected int attack;
  protected int defense;

  @Override
  protected void initParams() {
    super.initParams();
    level = rng.nextInt(12) + 1;
    attack = rng.nextInt(5000);
    defense = rng.nextInt(5000);
  }

  protected int getDifferentInt(int original, int lo, int hi) {
    int differentInt;
    do {
      differentInt = rng.nextInt(hi - lo) + lo;
    } while (differentInt == original);
    return differentInt;
  }

  void checkConstructor(MonsterCardFactory factory, MonsterCard card) {
    setupMonsterFactory(factory, name, level, attack, defense);
    MonsterCard expectedCard = factory.make();
    checkEquality(expectedCard, card);

    setupMonsterFactory(factory, getDifferentName(), level, attack, defense);
    MonsterCard differentCardName = factory.make();
    checkDifferentName(differentCardName, card);

    setupMonsterFactory(factory, name, getDifferentInt(level, 1, 12), attack, defense);
    MonsterCard differentLevelCard = factory.make();
    assertNotEquals(differentLevelCard, card);

    setupMonsterFactory(factory, name, level, getDifferentInt(attack, 0, 5000), defense);
    MonsterCard differentAttackCard = factory.make();
    assertNotEquals(differentAttackCard, card);

    setupMonsterFactory(factory, name, level, attack, getDifferentInt(defense, 0, 5000));
    MonsterCard differentDefenseCard = factory.make();
    assertNotEquals(differentDefenseCard, card);
  }

  private void setupMonsterFactory(MonsterCardFactory factory, String name, int level, int attack,
                                   int defense) {
    factory.setName(name);
    factory.setLevel(level);
    factory.setAttack(attack);
    factory.setDefense(defense);
  }
}
