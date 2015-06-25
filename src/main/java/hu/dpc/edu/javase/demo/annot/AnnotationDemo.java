package hu.dpc.edu.javase.demo.annot;

import hu.dpc.edu.javase.demo.EmployeeDAO;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author IQJB
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        getAnnotationInfo(EmployeeDAO.class);
    }
    
    private static void getAnnotationInfo(Class clazz) {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("method: " + method);
            RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
            if (rolesAllowed != null) {
                System.out.println("rolesAllowed: " + rolesAllowed);
                System.out.println("rolesAllowed.getClasss(): " + rolesAllowed.getClass());
                System.out.println("Roles Allowed: " + Arrays.toString(rolesAllowed.value()));
            }
        }
    }
}
