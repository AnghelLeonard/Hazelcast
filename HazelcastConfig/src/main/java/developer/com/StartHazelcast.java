package developer.com;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MulticastConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 *
 * @author Anghel Leonard
 */
public class StartHazelcast {

    public static void main(String[] args) {

        Config cfg = new Config();

        // set some network configurations
        NetworkConfig networkConfig = new NetworkConfig();
        networkConfig.setPort(6005);
        networkConfig.setPortAutoIncrement(true);
        networkConfig.setPortCount(100);

        MulticastConfig multicastConfig = new MulticastConfig();
        multicastConfig.setEnabled(true);

        JoinConfig joinConfig = new JoinConfig();
        joinConfig.setMulticastConfig(multicastConfig);

        networkConfig.setJoin(joinConfig);
        cfg.setNetworkConfig(networkConfig);

        HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
    }

}
