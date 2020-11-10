package com.thoughtworks.capability.gtb.restfulapidesign.Repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GroupRepository {
    Map<Group, List<Student>> GroupMap = new HashMap<>();

    public Map<Group, List<Student>> getGroupMap() {
        return GroupMap;
    }

    public void setGroupMap(Map<Group, List<Student>> groupMap) {
        GroupMap = groupMap;
    }
}
