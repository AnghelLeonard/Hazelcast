package developer.com;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IdGenerator;
import java.util.Random;

/**
 *
 * @author Anghel Leonard
 */
public class IMapHazelcast {

    public static void main(String[] args) {

        HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        // create and populate an IMap
        IMap products = instance.getMap("products");
        IdGenerator gen = instance.getIdGenerator("gen");

        products.put(gen.newId(), new Random().nextInt(100));
        products.put(gen.newId(), new Random().nextInt(100));

        products.entrySet().stream().forEach((entry) -> {
            System.out.printf("entry: " + entry + "\n");
        });

    }

}
