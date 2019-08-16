package SpringFactoryStudy;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author wangqianlong
 * @create 2019-08-15 19:59
 */
@Service
public class BeanTest implements InitializingBean, BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
        hello();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void hello() {
        Object o = beanFactory.getBean("springFactoryBean");
        BusinessService businessService = (BusinessService) o;
        System.out.println(o);
        ((BusinessService) o).test();
        System.out.println("hello spring");
    }

    public List<String> test() {
        //获取容器中的bean
        // UserDao userDao = (UserDao) beanFactory.getBean("userDao");
        //return userDao.getAllUser();
        return null;
    }

}
