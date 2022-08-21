package se.lexicon.todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.todoapi.exception.ObjectDuplicateException;
import se.lexicon.todoapi.exception.ObjectNotFoundException;
import se.lexicon.todoapi.model.dto.RoleDto;
import se.lexicon.todoapi.service.RoleService;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {

    RoleService rolesService;

    @Autowired
    public RoleController(RoleService rolesService) {
        this.rolesService = rolesService;
    }


    @GetMapping("/")
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        System.out.println("### getAllRoles has been executed!");
        List<RoleDto> roleDtoList = rolesService.getAll();
       // return ResponseEntity.status(HttpStatus.OK).body(roleDtoList);
        return ResponseEntity.ok(roleDtoList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> findRoleById (@PathVariable("id") Integer id) throws ObjectNotFoundException {
        System.out.println("id =" + id);
        RoleDto roleDto = rolesService.findById(id);
        return ResponseEntity.ok(roleDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleById(@PathVariable("id") Integer id) throws ObjectNotFoundException {
        System.out.println("id=" + id);
        rolesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) throws ObjectNotFoundException, ObjectDuplicateException {
        System.out.println("roleDto=" + roleDto);
        RoleDto createdRole = rolesService.create(roleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);

    }

    @PutMapping("/")
    public ResponseEntity<Void> updateRoleById(@RequestBody RoleDto roleDto) throws ObjectNotFoundException {
        System.out.println("roleDto=" + roleDto);
        rolesService.update(new RoleDto());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}

