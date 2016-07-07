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
public class IQueueProducer {

    public static void main(String[] args) {

        HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        String[] players = {"Rafael Nadal", "Roger Federer", "David Ferer", "Andy Murray", "Fernando Verdasco"};

        IQueue<String> queue = instance.getQueue("queue");
        try {
            for (int i = 0; i < players.length; i++) {
                queue.put(players[i]);
                System.out.println("Putting player " + players[i]);
                Thread.sleep(4000);
            }
            queue.put("done");
            System.out.println("Done!");
        } catch (InterruptedException ex) {
            Logger.getLogger(IQueueProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
