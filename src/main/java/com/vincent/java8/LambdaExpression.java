package com.vincent.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @BelongsProject: JavaWork
 * @BelongsPackage: com.vincent.java8
 * @Author: alisha
 * @CreateTime: 2019-01-15 15:30
 * @Description: LambdaExpression.
 */
public class LambdaExpression {

    public static void main(String[] args) {

        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();

        list.sort(byColor);

        Comparator<Apple> byColor2 = ((o1, o2) -> o1.getColor().compareTo(o2.getColor()));
    }

}
