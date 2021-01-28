package com.pat.reflect;


import java.io.File;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/24
 * @Modify
 * @since
 */
public class JavaGenericDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> scanBasePackageClass = JavaGenericDemo.class;
        String scanBasePackage = scanBasePackageClass.getPackage().getName();
        // 获取类所在的 class path 物理路径
        String classPath = getClassPath(scanBasePackageClass);

        File classPathDirectory = new File(classPath);
        File scanBasePackageDirectory = new File(classPathDirectory, scanBasePackage.replace('.', '/'));

        // 获取所有的 Class 文件 -> *.class
        File[] classFiles = scanBasePackageDirectory.listFiles(file -> {
            return file.isFile() && file.getName().endsWith(".class");
        });

        System.out.println("class path:" + classPath);
        System.out.println("scan base package:" + scanBasePackage);
        System.out.println("scan class files:" + Stream.of(classFiles).map(File::getName).collect(Collectors.joining(",")));

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        List<Class<?>> targetClasses = new LinkedList<>();

        for (File classFile : classFiles) {
            String simpleClassName = classFile.getName().substring(0, classFile.getName().lastIndexOf("."));
            String className = scanBasePackage + "." + simpleClassName;
            // 加载所有类
            Class<?> loadClass = classLoader.loadClass(className);
            // 判断是否存在 @Repository 注解
            if (loadClass.isAnnotationPresent(Repository.class)) {
                targetClasses.add(loadClass);
            }
        }

        // 判断 targetClasses 是否是 CrudRepository 类的实现
        targetClasses.stream()
                .filter(JavaGenericDemo::isConcrete) // 筛选具体类
                .filter(JavaGenericDemo::isCrudRepositoryType) // 筛选 CrudRepository 类的实现
                .forEach(type -> {
                    Type[] superInterfaces = type.getGenericInterfaces(); // 获取泛型父接口
                    Stream.of(superInterfaces)
                            .filter(t -> t instanceof ParameterizedType) // 判断接口是否为 ParameterizedType 类型
                            .map(t -> (ParameterizedType) t) // 转换 t 为 ParameterizedType
                            .filter(parameterizedType ->  CrudRepository.class.equals(parameterizedType.getRawType())) // 判断 ParameterizedType 原始类型是否是 CrudRepository
                            .forEach(parameterizedType -> {
                                String argumentTypeName = parameterizedType.getActualTypeArguments()[0].getTypeName();
                                try {
                                    System.out.println(classLoader.loadClass(argumentTypeName));
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                            });
                });




    }

    private static boolean isCrudRepositoryType(Class<?> type) {
        return CrudRepository.class.isAssignableFrom(type);
    }

    private static boolean isConcrete(Class<?> type) {
        return !Modifier.isAbstract(type.getModifiers());
    }

    private static String getClassPath(Class type) {
//        return type.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1);
        return type.getProtectionDomain().getCodeSource().getLocation().getPath(); // mac 系统上不需要使用substring(1)方法
    }

}

interface CrudRepository<E extends Serializable> {

}

@Repository
class UserRepository implements Comparable<UserRepository>, CrudRepository<User>, Serializable {
    @Override
    public int compareTo(UserRepository o) {
        return 0;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Repository {
    String value() default "";
}

class User implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
