package developer.com;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MulticastConfig;
import com.hazelcast.config.NetworkConfig;
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
            Config cfg = new XmlConfigBuilder("./hazelcast/myconfigs.xml").build();

            NetworkConfig networkConfig = cfg.getNetworkConfig();
           
            MulticastConfig multicastConfig = new MulticastConfig();
            multicastConfig.setEnabled(true);

            JoinConfig joinConfig = new JoinConfig();
            joinConfig.setMulticastConfig(multicastConfig);

            networkConfig.setJoin(joinConfig);
            cfg.setNetworkConfig(networkConfig);

            HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StartHazelcast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
