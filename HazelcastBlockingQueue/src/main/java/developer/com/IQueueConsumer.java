package developer.com;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anghel Leonard
 */
public class IQueueConsumer {

    public static void main(String[] args) {

        HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        IQueue<String> queue = instance.getQueue("queue");
        try {
            while (true) {
                String player;

                player = queue.take();

                System.out.println("Take from queue the player: " + player);
                if (player.equals("done")) {
                    queue.put("done");
                    break;
                }
            }
            System.out.println("Done!");
        } catch (InterruptedException ex) {
            Logger.getLogger(IQueueConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
