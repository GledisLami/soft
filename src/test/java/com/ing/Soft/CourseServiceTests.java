package com.ing.Soft;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.ing.Soft.dtos.CourseDto;
import com.ing.Soft.dtos.CourseDtoDetailed;
import com.ing.Soft.entities.Course;
import com.ing.Soft.interfaces.CourseDetailedInterface;
import com.ing.Soft.repositories.CourseRepository;
import com.ing.Soft.services.CourseService;
import com.ing.Soft.services.FeedbackService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseServiceTests {
    private CourseService courseService;
    private CourseRepository courseRepository;
    private FeedbackService feedbackService;

    @BeforeEach
    public void setUp() {
        courseRepository = mock(CourseRepository.class);
        feedbackService = mock(FeedbackService.class);
        courseService = new CourseService(courseRepository, feedbackService);
    }

    @Test
    public void testGetCourseList() {
        Course course1 = new Course();
        Course course2 = new Course();
        when(courseRepository.findAll()).thenReturn(Arrays.asList(course1, course2));

        List<Course> result = courseService.getCourseList();

        assertEquals(2, result.size());
        assertTrue(result.contains(course1));
        assertTrue(result.contains(course2));
    }

    @Test
    public void testFindById() {
        Course course = new Course();
        when(courseRepository.findById(1)).thenReturn(Optional.of(course));

        Optional<Course> result = courseService.findById(1);

        assertTrue(result.isPresent());
        assertEquals(course, result.get());
    }

    @Test
    public void testSaveCourse() {
        Course course = new Course();

        courseService.saveCourse(course);

        verify(courseRepository, times(1)).save(course);
    }

    @Test
    public void testGetAllCourseDtos() {
        when(courseRepository.findCourseDtos()).thenReturn(Arrays.asList(new CourseDto(), new CourseDto()));

        List<CourseDto> result = courseService.getAllCourseDtos();

        assertEquals(2, result.size());
    }

    @Test
    public void testFindTop8ByOrderByAverageDesc() {
        when(courseRepository.findTop8ByOrderByAverageDesc()).thenReturn(Arrays.asList(new CourseDto(), new CourseDto()));

        List<CourseDto> result = courseService.findTop8ByOrderByAverageDesc();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetEnrolledCoursesForStudent() {
        int userId = 1;
        when(courseRepository.findCourseDtosByUserId(userId)).thenReturn(Arrays.asList(new CourseDto(), new CourseDto()));

        List<CourseDto> result = courseService.getEnrolledCoursesForStudent(userId);

        assertEquals(2, result.size());
    }

    @Test
    public void testGetCourseDto() {
        when(courseRepository.findCourseDto(1)).thenReturn(new CourseDto());

        CourseDto result = courseService.getCourseDto(1);

        assertNotNull(result);
    }
}
