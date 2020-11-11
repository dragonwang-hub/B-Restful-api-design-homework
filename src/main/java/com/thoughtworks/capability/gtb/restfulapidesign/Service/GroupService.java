package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Map<Group, List<Student>> getGroups() {
        return groupRepository.getGroupMap();
    }

    public Group updateGroupName(AtomicInteger id, Group group) {
        Map<Group, List<Student>> groups = groupRepository.getGroupMap();
        Group srcGroup = groups.keySet().stream()
                .filter(key -> key.getId().equals(id)).collect(Collectors.toList()).get(0);
        List<Student> students = groups.get(srcGroup);
        groups.remove(srcGroup);
        srcGroup.setName(group.getName());
        groups.put(srcGroup,students);
        groupRepository.setGroupMap(groups);
        return srcGroup;
    }
}
