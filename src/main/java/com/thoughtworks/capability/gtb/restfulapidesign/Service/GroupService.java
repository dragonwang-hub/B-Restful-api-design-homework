package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Map<Group, List<Student>> getGroups() {
        return groupRepository.getGroupMap();
    }
}
