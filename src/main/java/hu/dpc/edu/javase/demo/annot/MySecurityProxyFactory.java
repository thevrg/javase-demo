package hu.dpc.edu.javase.demo.annot;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author IQJB
 */
public class MySecurityProxyFactory {

    public <T> T createSecurityProxy(final Class<T> proxyInterface, final T original) {

        Class<? extends Object> targetClass = original.getClass();

        Object proxy = Proxy.newProxyInstance(MySecurityProxyFactory.class.getClassLoader(),
                new Class[]{proxyInterface}, new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Intercepting method: " + method);

                        Method targetMethod = targetClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
                        RolesAlloweds rolesAlloweds = targetMethod.getAnnotation(RolesAlloweds.class);

                        if (rolesAlloweds != null) {
                            System.out.println("Found rolesAllowedS!!!");
                        }

                        RolesAllowed rolesAllowed = targetMethod.getAnnotation(RolesAllowed.class);
                        if (rolesAllowed != null) {
                            System.out.println("RolesAllowed: " + rolesAllowed);
                            List<Role> roles = Arrays.asList(rolesAllowed.value());
                            if (roles.contains(Role.ADMIN)) {
                                throw new SecurityException("Cannot access now");
                            }
                        }

                        Object retured = method.invoke(original, args);

                        System.out.println("method returned with: " + retured);

                        return retured;
                    }
                });
        return (T) proxy;
    }
}
