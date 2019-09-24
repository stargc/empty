package com.example.empty.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class RedisConfig {
    @Value("${redis.cluster.nodes}")
    private String clusterNodes;

    // Redis服务器地址
    @Value("${redis.host}")
    private String host;
    // Redis服务器连接端口
    @Value("${redis.port}")
    private int port;
    // Redis服务器连接密码（默认为空）
    @Value("${redis.password}")
    private String password;
    // 连接超时时间（毫秒）
    @Value("${redis.timeout}")
    private int timeout;
    // Redis数据库索引（默认为0）
    @Value("${redis.database}")
    private int database;
    // 连接池最大连接数（使用负值表示没有限制）
    @Value("${redis.pool.max-active}")
    private int maxTotal;
    // 连接池最大阻塞等待时间（使用负值表示没有限制）
    @Value("${redis.pool.max-wait}")
    private int maxWaitMillis;
    // 连接池中的最大空闲连接
    @Value("${redis.pool.max-idle}")
    private int maxIdle;
    // 连接池中的最小空闲连接
    @Value("${redis.pool.min-idle}")
    private int minIdle;

    @Bean(name = "jedisClusterConfig")
    public RedisClusterConfiguration getClusterConfiguration()
    {
        Map<String, Object> source = new HashMap<String, Object>();
        source.put("spring.redis.cluster.nodes", clusterNodes);
        source.put("spring.redis.cluster.timeout", timeout);
        source.put("spring.redis.cluster.max-redirects", 5);

        return new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
    }

    /**
     * 配置JedisPoolConfig
     * @return JedisPoolConfig实体
     */
    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig() {
        log.info("=== XXX RedisConf jedisPoolConfig 初始化JedisPoolConfi ===");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 连接池最大连接数（使用负值表示没有限制）
        jedisPoolConfig.setMaxTotal(this.maxTotal);
        // 连接池最大阻塞等待时间（使用负值表示没有限制）
        jedisPoolConfig.setMaxWaitMillis(this.maxWaitMillis);
        // 连接池中的最大空闲连接
        jedisPoolConfig.setMaxIdle(this.maxIdle);
        // 连接池中的最小空闲连接
        jedisPoolConfig.setMinIdle(this.minIdle);
        return jedisPoolConfig;
    }

    /**
     * 实例化 RedisConnectionFactory 对象
     * @param poolConfig
     * @return
     */
    @Bean(name = "jedisConnectionFactory")
    public RedisConnectionFactory jedisConnectionFactory(RedisClusterConfiguration poolConfig) {
        log.info("=== XXX RedisConf jedisConnectionFactory 初始化JedisPoolConfi ===");
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
        jedisConnectionFactory.setHostName(this.host);
        jedisConnectionFactory.setPort(this.port);
        jedisConnectionFactory.setDatabase(this.database);
        jedisConnectionFactory.setTimeout(this.timeout);
        return jedisConnectionFactory;
    }

    /**
     * 配置工厂
     * @param jedisPoolConfig
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig, RedisSentinelConfiguration sentinelConfig) {
        return new JedisConnectionFactory(sentinelConfig,jedisPoolConfig);
    }
    /**
     * 实例化 RedisTemplate 对象
     * @return
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, String> functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        StringRedisSerializer keySerializer = new StringRedisSerializer();

        redisTemplate.setEnableDefaultSerializer(false);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
