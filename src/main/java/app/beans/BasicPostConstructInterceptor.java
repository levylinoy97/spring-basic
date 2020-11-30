package app.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BasicPostConstructInterceptor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(getClass().getSimpleName() + " in pre @PostConstruct of " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(getClass().getSimpleName() + " in post @PostConstruct of " + beanName);
        return bean;
    }
}
