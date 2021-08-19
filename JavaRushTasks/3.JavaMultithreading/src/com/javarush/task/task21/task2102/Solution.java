package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/

public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();

        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();

        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        switch(specificModifier){
            case 0x00000001: return (allModifiers & 0x00000001) != 0;
            case 0x00000002: return (allModifiers & 0x00000002) != 0;
            case 0x00000004: return (allModifiers & 0x00000004) != 0;
            case 0x00000008: return (allModifiers & 0x00000008) != 0;
            case 0x00000010: return (allModifiers & 0x00000010) != 0;
            case 0x00000020: return (allModifiers & 0x00000020) != 0;
            case 0x00000040: return (allModifiers & 0x00000040) != 0;
            case 0x00000080: return (allModifiers & 0x00000080) != 0;
            case 0x00000100: return (allModifiers & 0x00000100) != 0;
            case 0x00000200: return (allModifiers & 0x00000200) != 0;
            case 0x00000400: return (allModifiers & 0x00000400) != 0;
            case 0x00000800: return (allModifiers & 0x00000800) != 0;
            default: return false;
        }


    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
