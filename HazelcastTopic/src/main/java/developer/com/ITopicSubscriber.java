package developer.com;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

/**
 *
 * @author Anghel Leonard
 */
public class ITopicSubscriber {

    public static void main(String[] args) {

        HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        ITopic<String> topic = instance.getTopic("topic");
        topic.addMessageListener(new MessageListenerImpl());
        
        System.out.println("Subscribed");
    }

    private static class MessageListenerImpl implements MessageListener<String> {
        @Override
        public void onMessage(Message<String> m) {
            System.out.println("Received player: " + m.getMessageObject());
        }
    }
}
