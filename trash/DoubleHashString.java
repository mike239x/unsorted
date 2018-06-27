
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.LongStream;

/**
 * Die Klasse {@link DoubleHashString} kann dazu verwendet werden,
 * Strings zu hashen.
 */
public class DoubleHashString implements DoubleHashable<String> {

  int m;
  Random r1 = new Random();
  Random r2 = new Random();

  ArrayList<Integer> x1 = new ArrayList<>();
  ArrayList<Integer> x2 = new ArrayList<>();

  /**
   * Dieser Konstruktor initialisiert ein {@link DoubleHashString}
   * Objekt für einen gegebenen Maximalwert (size - 1) der gehashten
   * Werte.
   * 
   * @param size die Größe der Hashtabelle
   */
  public DoubleHashString (int size) {
    m = size;
  }
  
  /**
   * Diese Methode berechnet h(key) für einen String.
   * 
   * @param key der Schlüssel, der gehasht werden soll
   * @return der Hashwert des Schlüssels
   */
  public long hash (String key) {
    ArrayList<Integer> a = new ArrayList<>();

    for (int i=0; i<key.length(); i++)
      a.add((int) key.charAt(i));

    while (x1.size() < a.size())
      update(x1, r1);

    return Math.floorMod(scalar(a, x1), m);
  }
  
  /**
   * Diese Methode berechnet h'(key) für einen String.
   * 
   * @param key der Schlüssel, der gehasht werden soll
   * @return der Hashwert des Schlüssels
   */
  public long hashTick (String key) {
    ArrayList<Integer> a = new ArrayList<>();

    for (int i=0; i<key.length(); i++)
      a.add((int) key.charAt(i));

    while (x2.size() < a.size())
      update(x2, r2);

    return Math.floorMod(scalar(a, x2 ), m);
  }

  private void update(ArrayList<Integer> x, Random r){
    x.add(r.nextInt());
  }

  private int scalar(ArrayList<Integer> a, ArrayList<Integer> x){
    if (x.size() < a.size()) throw new IllegalArgumentException();
    int sum = 0;
    for (int i=0; i<a.size(); i++){
      sum += a.get(i) * x.get(i);
    }
    return sum;
  }
}
