package se.lexicon.todoapi.service;

import se.lexicon.todoapi.model.dto.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto create(RoleDto dto);

    void update(RoleDto dto);

    List<RoleDto> getAll();

    RoleDto findById(Integer id);

    RoleDto findByName(String name);

    void delete(Integer id);
}
