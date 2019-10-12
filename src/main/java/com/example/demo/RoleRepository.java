package com.example.demo;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/08 上午 9:55
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
