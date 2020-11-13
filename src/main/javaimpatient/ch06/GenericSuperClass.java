package ch06.sec07;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericSuperClass {
    public static void main(String[] args) throws Exception {

        Bar bar = new Foo<Bar>() {
        }.instantiateWithHack();
        new Foo<Bar>(){}.instantiateWithMetaclass(Bar.class);
    }
    public static class Foo<T>{
        T instantiateWithHack() throws Exception {
            Type genericSuperClass  = getClass().getGenericSuperclass();
            ParameterizedType superType = (ParameterizedType) genericSuperClass;
            Class<T> clazz = (Class<T>) superType.getActualTypeArguments()[0];
            return  clazz.newInstance();
        }

        T instantiateWithMetaclass(Class<T> clazz) throws Exception{
            return clazz.newInstance();
        }
    }
    public static class Bar{
        private static  String value;
        {
            value = "Bar";
        }
    }
}
