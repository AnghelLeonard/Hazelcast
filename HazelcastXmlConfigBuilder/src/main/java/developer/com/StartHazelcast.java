package developer.com;

import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anghel Leonard
 */
public class StartHazelcast {
    
    public static void main(String[] args) {               
                
        try {       
            XmlConfigBuilder cfg = new XmlConfigBuilder("./hazelcast/myconfigs.xml");
            HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg.build());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StartHazelcast.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
}
