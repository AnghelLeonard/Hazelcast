package developer.com;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anghel Leonard
 */
public class ITopicPublisher {

    public static void main(String[] args) {

        HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        String[] players = {"Rafael Nadal", "Roger Federer", "David Ferer", "Andy Murray", "Fernando Verdasco"};

        ITopic<String> topic = instance.getTopic("topic");
        try {
            for (int i = 0; i < players.length; i++) {
                topic.publish(players[i]);
                System.out.println("Putting player " + players[i]);
                Thread.sleep(4000);
            }
            topic.publish("done");
            System.out.println("Done!");
        } catch (InterruptedException ex) {
            Logger.getLogger(ITopicPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
