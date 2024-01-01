package com.ing.Soft.util;

import com.ing.Soft.interfaces.CourseInterface;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CourseDtoMapper {
    public static <T> List<T> mapToCourseDto(Supplier<List<CourseInterface>> listSupplier, Class<T> entityClass){
        /*
        Runs query and maps it from the projected interface to the
        class who has a constructor with that interface as a parameter
        Course Interface -> Course Dto
         */

        return listSupplier.get().
                stream().
                map(interfaceImpl -> {
                            try {
                                return entityClass.getConstructor(CourseInterface.class).newInstance(interfaceImpl);
                            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                                     InvocationTargetException e) {
                                throw new RuntimeException("Error creating an instance of " + entityClass.getSimpleName(), e);
                            }
                        }
                ).collect(Collectors.toList());
    }
}
