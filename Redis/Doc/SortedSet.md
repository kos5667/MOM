# Redis Sorted Sets([소개](https://redis.io/docs/data-types/sorted-sets/))

Sorted Sets는 key 하나에 여러개의 score와 value로 구성됩니다. Value는 score로 sort되며 중복되지 않습니다.
score가 같으면 value로 sort됩니다. Sorted Sets에서는 집합이라는 의미에서 value를 member라 부릅니다.
Sorted Sets은 주로 sort가 필요한 곳에 사용됩니다.

## outline

### 기본 명령

- [`ZADD`](https://redis.io/commands/zadd)새 멤버 및 관련 점수를 정렬된 세트에 추가합니다. 구성원이 이미 존재하는 경우 점수가 업데이트됩니다.
- [`ZRANGE`](https://redis.io/commands/zrange)주어진 범위 내에서 정렬된 정렬된 집합의 구성원을 반환합니다.
- [`ZRANK`](https://redis.io/commands/zrank)정렬된 항목이 오름차순이라고 가정하고 제공된 멤버의 순위를 반환합니다.
- [ZREVRANK](https://redis.io/commands/zrevrank)정렬된 집합이 내림차순이라고 가정하고 제공된 멤버의 순위를 반환합니다.

### 명령어 요약

- **SET**: ZADD
- **GET**: ZRANGE, ZRANGEBYSCORE, ZRANGEBYLEX, ZREVRANGE, ZREVRANGEBYSCORE, ZREVRANGEBYLEX, ZRANK, ZREVRANK, ZSCORE, ZCARD, ZCOUNT, ZLEXCOUNT, ZSCAN
- **POP**: ZPOPMIN, ZPOPMAX
- **REM**: ZREM, ZREMRANGEBYRANK, ZREMRANGEBYSCORE, ZREMRANGEBYLEX
- **INCR**: ZINCRBY
- **집합연산**: ZUNIONSTORE, ZINTERSTORE
- **Enterprise**: ZISMEMBER, ZLS, ZRM, SLEN, SADDS (subquery)

## outline

### [Sorted Sets 명령어 리스트](https://redis.io/commands/?group=sorted-set)

| Commands                                                     | Version   | Syntax                                                       | Description                                  |
| ------------------------------------------------------------ | --------- | ------------------------------------------------------------ | -------------------------------------------- |
| [ZADD](http://redisgate.kr/redis/command/zadd.php)           | 1.2.0     | key score member [score member ...]                          | 집합에 score와 member를 추가                 |
| [ZCARD](http://redisgate.kr/redis/command/zcard.php)         | 1.2.0     | key                                                          | 집합에 속한 member의 갯수를 조회             |
| [ZINCRBY](http://redisgate.kr/redis/command/zincrby.php)     | 1.2.0     | key increment member                                         | 지정한 만큼 score 증가, 감소                 |
| [ZRANGE](http://redisgate.kr/redis/command/zrange.php)       | 1.2.0     | key start stop [withscores]                                  | index로 범위를 지정해서 조회                 |
| [ZRANGEBYSCORE](http://redisgate.kr/redis/command/zrangebyscore.php) | 1.2.0     | key min max [withscores] [limit offset count]                | score로 범위를 지정해서 조회                 |
| [ZREM](http://redisgate.kr/redis/command/zrem.php)           | 1.2.0     | key member [member ...]                                      | 집합에서 member를 삭제                       |
| [ZREMRANGEBYSCORE](http://redisgate.kr/redis/command/zremrangebyscore.php) | 1.2.0     | key min max                                                  | score로 범위를 지정해서 member를 삭제        |
| [ZREVRANGE](http://redisgate.kr/redis/command/zrevrange.php) | 1.2.0     | key start stop [withscores]                                  | index로 범위를 지정해서 큰 것부터 조회       |
| [ZSCORE](http://redisgate.kr/redis/command/zscore.php)       | 1.2.0     | key member                                                   | member를 지정해서 score를 조회               |
| [ZCOUNT](http://redisgate.kr/redis/command/zcount.php)       | 2.0.0     | key min max                                                  | score로 범위를 지정해서 갯수 조회            |
| [ZRANK](http://redisgate.kr/redis/command/zrank.php)         | 2.0.0     | key member                                                   | member를 지정해서 rank(index)를 조회         |
| [ZREVRANK](http://redisgate.kr/redis/command/zrevrank.php)   | 2.0.0     | key member                                                   | member를 지정해서 reverse rank(index)를 조회 |
| [ZREMRANGEBYRANK](http://redisgate.kr/redis/command/zremrangebyrank.php) | 2.0.0     | key start stop                                               | index로 범위를 지정해서 member를 삭제        |
| [ZUNIONSTORE](http://redisgate.kr/redis/command/zunionstore.php) | 2.0.0     | dest_key numkeys src_key [src_key ...] [WEIGHTS weight [weight ...]] [AGGREGATE SUM\|MIN\|MAX] | 합집합을 구해서 새로운 집합에 저장           |
| [ZINTERSTORE](http://redisgate.kr/redis/command/zinterstore.php) | 2.0.0     | dest_key numkeys src_key [src_key ...] [WEIGHTS weight [weight ...]] [AGGREGATE SUM\|MIN\|MAX] | 교집합을 구해서 새로운 집합에 저장           |
| [ZREVRANGEBYSCORE](http://redisgate.kr/redis/command/zrevrangebyscore.php) | 2.2.0     | key max min [withscores] [limit offset count]                | score로 범위를 지정해서 큰 것부터 조회       |
| [ZSCAN](http://redisgate.kr/redis/command/zscan.php)         | 2.8.0     | key cursor [MATCH pattern] [COUNT count]                     | score, member를 일정 단위 갯수 만큼씩 조회   |
| [ZRANGEBYLEX](http://redisgate.kr/redis/command/zrangebylex.php) | 2.8.9     | key min max [limit offset count]                             | member로 범위를 지정해서 조회                |
| [ZLEXCOUNT](http://redisgate.kr/redis/command/zlexcount.php) | 2.8.9     | key min max                                                  | member로 범위를 지정해서 갯수 조회           |
| [ZREMRANGEBYLEX](http://redisgate.kr/redis/command/zremrangebylex.php) | 2.8.9     | key min max                                                  | member로 범위를 지정해서 member를 삭제       |
| [ZREVRANGEBYLEX](http://redisgate.kr/redis/command/zrevrangebylex.php) | 2.8.9     | key max min [limit offset count]                             | member로 범위를 지정해서 큰 것부터 조회      |
| [ZPOPMIN](http://redisgate.kr/redis/command/zpopmin.php)     | 5.0.0     | key                                                          | 작은 값부터 꺼내온다                         |
| [ZPOPMAX](http://redisgate.kr/redis/command/zpopmax.php)     | 5.0.0     | key                                                          | 큰 값부터 꺼내온다                           |
| [BZPOPMIN](http://redisgate.kr/redis/command/bzpopmin.php)   | 5.0.0     | key                                                          | 데이터가 들어오면 작은 값부터 꺼내온다       |
| [BZPOPMAX](http://redisgate.kr/redis/command/bzpopmax.php)   | 5.0.0     | key                                                          | 데이터가 들어오면 큰 값부터 꺼내온다         |
| [ZMSCORE](http://redisgate.kr/redis/command/zmscore.php)     | 6.2.0     | member [member ...]                                          | member의 score를 리턴 - 여러 개 가능         |
| [ZRANDMEMBER](http://redisgate.kr/redis/command/zrandmember.php) | 6.2.0     | key                                                          | 임의(random)의 멤버를 조회                   |
| [ZRANGESTORE](http://redisgate.kr/redis/command/zrangestore.php) | 6.2.0     | dst src start stop                                           | 조회해서 다른 키에 저장                      |
| [ZUNION](http://redisgate.kr/redis/command/zunion.php)       | 6.2.0     | numkeys key [key ...]                                        | 합집합을 구함                                |
| [ZINTER](http://redisgate.kr/redis/command/zinter.php)       | 6.2.0     | numkeys key [key ...]                                        | 교집합을 구함                                |
| [ZDIFF](http://redisgate.kr/redis/command/zdiff.php)         | 6.2.0     | numkeys key [key ...]                                        | 차집합을 구함                                |
| [ZDIFFSTORE](http://redisgate.kr/redis/command/zdiffstore.php) | 6.2.0     | destination numkeys key [key ...]                            | 차집합을 구해서 새로운 집합에 저장           |
| [ZISMEMBER](http://redisgate.kr/redis/command/zismember.php) | Ent 6.0.0 | key member                                                   | 집합에 member가 존재하는지 확인              |
| [ZLS](http://redisgate.kr/redis/command/zls.php)             | Ent 6.0.0 | key pattern                                                  | 패턴(pattern)으로 값(value) 조회             |
| [ZRM](http://redisgate.kr/redis/command/zrm.php)             | Ent 6.0.0 | key pattern                                                  | 패턴(pattern)으로 값(value) 삭제             |
| [ZLEN](http://redisgate.kr/redis/command/zlen.php)           | Ent 7.0.0 | key                                                          | 키에 속한 멤버 개수를 리턴                   |
| [ZADDS](http://redisgate.kr/redis/command/zadd_subquery.php) | Ent 7.2.5 | key (subquery)                                               | 서브쿼리로 데이터 추가                       |

## outline

