package onlineTraning;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Parameter;

public class WarmUp {

    public static void main(String[] args) {
        NotNullService notNullService = checkNotNull(NotNullService.class);
        notNullService.test1(1, "555");
        notNullService.test1(null, "555");
        notNullService.test2(22, "555");
    }

    public static <T> T checkNotNull(Class<T> targetClass){
        var enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        MethodInterceptor methodInterceptor = ((o, method, objects, methodProxy) -> {
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                if (parameters[i].isAnnotationPresent(NotNull.class) && objects[i] == null){
                    throw new NullPointerException(parameters[i].toString());
                }
            }
            return methodProxy.invokeSuper(o, objects);
        });
        enhancer.setCallback(methodInterceptor);
        return (T) enhancer.create();
    }

}