package com.wbo.beandemo;

import java.beans.*;
import java.util.stream.Stream;

public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class,Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor->{

            System.out.println(propertyDescriptor);

            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String name = propertyDescriptor.getName();
            if("age".equals(name)){
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                propertyDescriptor.createPropertyEditor(null);//TODO
            }

        });
    }
    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
