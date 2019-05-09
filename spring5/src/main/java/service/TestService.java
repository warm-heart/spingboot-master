package service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author wangqianlong
 * @create 2019-05-08 14:56
 */
@Service
@Component
public class TestService {
    public String service(){
        return "service";
    }
}
