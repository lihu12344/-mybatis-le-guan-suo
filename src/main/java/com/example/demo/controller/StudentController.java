package com.example.demo.controller;

import com.example.demo.dao.StudentMapper;
import com.example.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/save")
    public String save(){
        Student student=new Student();
        student.setId(1);
        student.setName("瓜田李下");
        student.setAge(23);

        studentMapper.insert(student);

        return "success";
    }

    @RequestMapping("/update")
    public Student update(){
        Student student=studentMapper.selectByPrimaryKey(1);
        student.setAge(18);
        System.out.println(studentMapper.updateByPrimaryKey(student));

        return studentMapper.selectByPrimaryKey(1);
    }
}
