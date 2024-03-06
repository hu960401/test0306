import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @ClassName JedisUtil
 * @Description:
 * @Author: 12072    huyl
 * @CreateDate: 2024/3/5 13:52
 * @Version: 1.0
 */
public class JedisUtil {
    private Jedis jedis;



    @BeforeEach
    void setUp(){

        jedis = new Jedis("127.0.0.1",6379);
        jedis.select(0);


//        jedis = new Jedis("118.31.251.47",6379);
//        jedis.auth("120923");
//        jedis.select(0);
    }

    @Test
    public void test(){
        System.out.println(jedis.set("huyl","胡银玲"));
        System.out.println(jedis.get("huyl"));
    }

    @AfterEach
    void setDown(){
        if (null!=jedis){
            jedis.close();
        }
    }
}
