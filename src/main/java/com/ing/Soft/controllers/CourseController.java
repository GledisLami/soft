import com.ing.Soft.entities.Course;
import com.ing.Soft.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")

public class CourseController {

        @Autowired
        CourseService courseService;

        @PostMapping
        public void saveCourse(@RequestBody Course course){
                courseService.saveCourse(course);
        }
  
        @GetMapping
        public List<Course> getCourseList(){
           return courseService.getCourseList();
        }
}
