/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eke.demoWebrtc.controller;

import com.eke.demoWebrtc.model.TeacherEntity;
import com.eke.demoWebrtc.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
/**
 *
 * @author eke
 */
@RestController
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    
    @GetMapping("/teachers")
    public Page<TeacherEntity> getQuestions(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }
}
