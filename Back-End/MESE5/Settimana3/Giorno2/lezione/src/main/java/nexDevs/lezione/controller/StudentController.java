package nexDevs.lezione.controller;

import nexDevs.lezione.dto.StudentDto;
import nexDevs.lezione.entity.Student;
import nexDevs.lezione.excepion.BadRequestException;
import nexDevs.lezione.excepion.NotFoundException;
import nexDevs.lezione.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/api/students")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveStudent(@RequestBody @Validated StudentDto studentDto, BindingResult bindingResult) throws BadRequestException{
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).
                    reduce("", (s, s2) -> s+s2));
        }
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/api/students")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/api/students/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Student getStudentById(@PathVariable int id){
        Optional<Student> studentOptional=studentService.getStudentById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }else {
            throw new NotFoundException("Student whit id=" + id + "NOT FOUND");
        }
    }

    @PutMapping("/api/students/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Student UpdateStudent(@PathVariable int id,@RequestBody @Validated StudentDto studentDto,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).
                    reduce("", (s, s2) -> s+s2));
        }
        return studentService.updateStudent(id,studentDto);
    }

    @DeleteMapping("/api/students/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteStudent(@PathVariable int id){

     return studentService.deletStudent(id);
    }
}
