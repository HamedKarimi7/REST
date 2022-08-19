package se.lexicon.todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.todoapi.model.entity.Role;
import se.lexicon.todoapi.repository.RoleRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {

    RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Role>> getAllRoles(){
      List<Role> roleList = roleRepository.findAll();
       // return ResponseEntity.status(HttpStatus.OK).body(roleList);
        return ResponseEntity.ok(roleList);

    }
}

