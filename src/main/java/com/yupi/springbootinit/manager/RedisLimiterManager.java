package com.yupi.springbootinit.manager;

import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 季 雷
 * @version 1.0
 * @Date 2023/07/25/0:01
 *
 * 专门提供RedisLimiter 限流基础服务
 */
@Service
public class RedisLimiterManager {

    @Resource
    private RedissonClient redissonClient;

    /**
     *限流操作
     * @param key 区分不同的限流器，比如不同的用户id应该分别统计
     */
    public void doRateLimit(String key) {
        //创建一个名称为user_limiter的限流器，每秒最多访问2次
        RRateLimiter rateLimiter = redissonClient.getRateLimiter(key);
        //限流器的统计规则(每秒2个请求；连续的请求最多智能有一个请求被允许通过)
        rateLimiter.trySetRate(RateType.OVERALL, 2,1, RateIntervalUnit.SECONDS);
        //每当一个操作来了后请求一个令牌
        boolean canOp = rateLimiter.tryAcquire(1);
        //如果没有令牌，还想执行操作，就抛出异常
        if (!canOp) {
            throw new BusinessException(ErrorCode.TOO_MANY_REQUEST);
        }
    }
}
