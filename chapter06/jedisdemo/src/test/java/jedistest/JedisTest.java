package jedistest;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/8/25
 */
public class JedisTest {

    @Test  //单节点
    public void test1() {
        Jedis jedis = new Jedis("192.168.146.135", 6379);
        //增加
        String result = jedis.set("address", "海淀");
        System.out.println(result);
        //查询
        String val = jedis.get("address");
        System.out.println(val);
        //删除
        Long index = jedis.del("k1");
        System.out.println(index);
    }

    @Test //集群
    public void test2() {
        Set<HostAndPort> clusterNodes = new HashSet<HostAndPort>();
        clusterNodes.add(new HostAndPort("192.168.146.135", 7001));
        clusterNodes.add(new HostAndPort("192.168.146.135", 7002));
        clusterNodes.add(new HostAndPort("192.168.146.135", 7003));
        clusterNodes.add(new HostAndPort("192.168.146.135", 7004));
        clusterNodes.add(new HostAndPort("192.168.146.135", 7005));
        clusterNodes.add(new HostAndPort("192.168.146.135", 7006));
        JedisCluster jc = new JedisCluster(clusterNodes);
//        jc.set("address", "深圳");
        String address = jc.get("name");
        System.out.println(address);
    }
}
