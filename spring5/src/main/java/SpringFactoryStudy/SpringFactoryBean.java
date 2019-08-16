package SpringFactoryStudy;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * @author wangqianlong
 * @create 2019-08-16 15:25
 */
@Service
public class SpringFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new BusinessService();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
