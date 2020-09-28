package com.droolsdemo;

import com.droolsdemo.dto.User;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DroolsdemoApplicationTests {

    private static KieContainer container = null;
    private KieSession statefulKieSession = null;

    @Test
    public void test(){
        KieServices kieServices = KieServices.Factory.get();
        container = kieServices.getKieClasspathContainer();
        //<ksession name="myAgeSession"/>
        statefulKieSession = container.newKieSession("myAgeSession");
        User user = new User("duval yang",12);
        // 插入一个新的对象
        statefulKieSession.insert(user);
        // 触发所有规则
        statefulKieSession.fireAllRules();
        //释放所有当前会话资源，为垃圾回收设置会话
        statefulKieSession.dispose();
    }

}
