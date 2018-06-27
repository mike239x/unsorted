

import java.lang.reflect.Array;
import java.util.*;

/**
 * Die Klasse DoubleHashTable implementiert eine Hashtabelle, die doppeltes
 * Hashing verwendet.
 *
 * @param <K> der Typ der Schlüssel, die in der Hashtabelle gespeichert werden
 * @param <V> der Typ der Werte, die in der Hashtabelle gespeichert werden
 */
public class DoubleHashTable<K, V> {
   private int size, collisions, maxRehashes = 0;
   private Pair<K, V>[] hashtable;

   DoubleHashable<K> doubleHashable;

  /**
   * Diese Methode implementiert h(x, i).
   * 
   * @param key der Schlüssel, der gehasht werden soll
   * @param i der Index, der angibt, der wievielte Hash für den gegebenen Schlüssel
   * berechnet werden soll
   * @return der generierte Hash
   */
  private int hash(K key, int i) {
    long h1 = doubleHashable.hash(key);
    long h2 = doubleHashable.hashTick(key);

    return (int) Math.floorMod( (h1 + i * h2), size );

  }

  /**
   * Dieser Konstruktor initialisiert die Hashtabelle.
   * 
   * @param primeSize die Größe 'm' der Hashtabelle; es kann davon ausgegangen
   * werden, dass es sich um eine Primzahl handelt.
   * @param hashableFactory Fabrik, die aus einer Größe ein DoubleHashable<K>-Objekt erzeugt.
   */
  public DoubleHashTable(int primeSize, HashableFactory<K> hashableFactory) {
    size = primeSize;
    hashtable = (Pair<K, V>[]) Array.newInstance(Pair.class, primeSize);
    doubleHashable = hashableFactory.create(size);
  }

  /**
   * Diese Methode fügt entsprechend des doppelten Hashens ein Element
   * in die Hashtabelle ein.
   * 
   * @param k der Schlüssel des Elements, das eingefügt wird
   * @param v der Wert des Elements, das eingefügt wird
   * @return 'true' falls das einfügen erfolgreich war, 'false' falls die
   * Hashtabelle voll ist.
   */
  public boolean insert(K k, V v) {
      for (int i=0; i<size; i++){
          int index = hash(k, i);
          if (hashtable[index] == null || hashtable[index]._1.equals(k)){
              hashtable[index] = new Pair<>(k, v);
              if (i!=0) collisions++;
              if (i > maxRehashes) maxRehashes = i;
              return true;
          }
      }
      return false;
  }

  /**
   * Diese Methode sucht ein Element anhand seines Schlüssels in der Hashtabelle
   * und gibt den zugehörigen Wert zurück, falls der Schlüssel gefunden wurde.
   * 
   * @param k der Schlüssel des Elements, nach dem gesucht wird
   * @return der Wert des zugehörigen Elements, sonfern es gefunden wurde
   */
  public Optional<V> find(K k) {
      for (int i=0; i<size; i++){
          int index = hash(k, i);
          if (hashtable[index]._1.equals(k)){
              return Optional.ofNullable(hashtable[index]._2);
          }
      }
      return Optional.empty();
  }

  /**
   * Diese Methode ermittelt die Anzahl der Kollisionen, also die Anzahl
   * der Elemente, nicht an der 'optimalen' Position in die Hashtabelle eingefügt
   * werden konnten. Die optimale Position ist diejenige Position, die der
   * erste Aufruf der Hashfunktion (i = 0) bestimmt.
   * 
   * @return die Anzahl der Kollisionen
   */
  public int collisions() {
    return collisions;
  }
 
  /**
   * Diese Methode berechnet die maximale Anzahl von Aufrufen der Hashfunktion,
   * die nötig waren, um ein einziges Element in die Hashtabelle einzufügen.
   * 
   * @return die berechnete Maximalzahl von Aufrufen
   */
  public int maxRehashes() {
    return maxRehashes;
  }

  public String toString(){
      return Arrays.toString(hashtable);
  }
}
