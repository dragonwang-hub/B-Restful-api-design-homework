package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    @ResponseStatus(HttpStatus.OK)
    public Map<Group, List<Student>> getGroups() {
        return groupService.getGroups();
    }

    @PatchMapping("/groups/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Group updateGroupInfo(@PathVariable("id") AtomicInteger id) {

    }

    @GetMapping("/groups/shuffle")
    @ResponseStatus(HttpStatus.OK)
    public Map<Group, List<Group>> shuffleGroups() {

    }


}
