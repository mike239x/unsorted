
import java.util.Random;

/**
 * Die Klasse {@link DoubleHashInt} kann dazu verwendet werden,
 * Integer zu hashen.
 */
public class DoubleHashInt implements DoubleHashable<Integer> {
  private int m;
  int r1, r2;

  /**
   * Dieser Konstruktor initialisiert ein {@link DoubleHashInt}
   * Objekt für einen gegebenen Maximalwert (size - 1) der gehashten
   * Werte.
   * 
   * @param size die Größe der Hashtabelle
   */
  public DoubleHashInt (int size) {
    m = size;
    r1 = new Random().nextInt(m)+1;
    r2 = new Random().nextInt(m)+1;
  }

  /**
   * Diese Methode berechnet h(key) für einen Integer.
   * 
   * @param key der Schlüssel, der gehasht werden soll
   * @return der Hashwert des Schlüssels
   */
  @Override public long hash (Integer key) {
    return Math.floorMod(key * r1, m);
  }

  /**
   * Diese Methode berechnet h'(key) für einen Integer.
   * 
   * @param key der Schlüssel, der gehasht werden soll
   * @return der Hashwert des Schlüssels
   */
  @Override public long hashTick (Integer key) {
    return Math.floorMod(key * r2, m);
  }

}
