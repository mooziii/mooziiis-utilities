package me.obsilabor.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayUtils {

    public static <I> List<I> cloneList(List<I> list) {
        return new ArrayList<>(list);
    }

    @SafeVarargs
    public static <T> Collection<T> listOf(T... t) {
        return new ArrayList<>(Arrays.asList(t));
    }

}
