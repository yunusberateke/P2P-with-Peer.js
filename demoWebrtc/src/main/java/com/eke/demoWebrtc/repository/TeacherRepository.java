/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eke.demoWebrtc.repository;

import com.eke.demoWebrtc.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eke
 */
@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    
}
