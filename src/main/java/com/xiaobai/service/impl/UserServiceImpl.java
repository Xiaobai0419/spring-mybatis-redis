package com.xiaobai.service.impl;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.xiaobai.dao.UserMapper;
import com.xiaobai.domain.User;
import com.xiaobai.service.IUserService;

/**
 * userService
 *
 * 缓存机制说明：所有的查询结果都放进了缓存，也就是把MySQL查询的结果放到了redis中去，
 * 然后第二次发起该条查询时就可以从redis中去读取查询的结果，从而不与MySQL交互，从而达到优化的效果，
 * redis的查询速度之于MySQL的查询速度相当于 内存读写速度 /硬盘读写速度
 * @Cacheable("a")注解的意义就是把该方法的查询结果放到redis中去，下一次再发起查询就去redis中去取，存在redis中的数据的key就是a；
 * @CacheEvict(value={"a","b"},allEntries=true) 的意思就是执行该方法后要清除redis中key名称为a,b的数据；
 *
 *  ①使用了@Cacheable（value="myUser"），即表示缓存中有，直接从缓存取出，没有的话先从数据库中查出，然后再插入
　　②如果未在类上使用@CacheConfig注解规定数据要缓存到哪个库中，就必须给value一个值，规定数据最后缓存到哪个redis库中
　　③因为redis缓存数据实际就是键值对的形式存储，因此必须给定key-value的key,这里没有给key参数赋值，所以key的生成规则按照上面工具类中规定的key生成的
　　④key-value的value就是本方法的返回值，如果要缓存登录用户信息，本方法需要进行修改，返回user对象就可以缓存到key-value的value中
 */
@Service("userService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper iUserDao;

    @Cacheable("getUserById") //标注该方法查询的结果进入缓存，再次访问时直接读取缓存中的数据
    public User getUserById(int userId) {
        return this.iUserDao.selectByPrimaryKey(userId);
    }

    @Cacheable("getAllUser")
    public List<User> getAllUser() {
        return this.iUserDao.selectAllUser();
    }

    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)//清空缓存，allEntries变量表示所有对象的缓存都清除
    public void insertUser(User user) {
        this.iUserDao.insertUser(user);
    }

    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)
    public void deleteUser(int id) {
        this.iUserDao.deleteUser(id);
    }

    @Cacheable("findUsers")
    public List<User> findUsers(String keyWords) {
        return iUserDao.findUsers(keyWords);
    }

    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)
    public void editUser(User user) {
        this.iUserDao.editUser(user);
    }
}
