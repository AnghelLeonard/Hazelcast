package developer.com;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 *
 * @author Anghel Leonard
 */
public class StartHazelcast {
    
    public static void main(String[] args) {               
                
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
    }
    
}
