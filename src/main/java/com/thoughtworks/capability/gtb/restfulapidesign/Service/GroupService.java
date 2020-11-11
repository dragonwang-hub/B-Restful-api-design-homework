package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
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
        groups.put(srcGroup, students);
        groupRepository.setGroupMap(groups);
        return srcGroup;
    }

    public Map<Group, List<Student>> shuffleGroups() {
        Map<Group, List<Student>> studentGroup = new HashMap<>();
        List<Student> tempAll = new ArrayList<>(studentRepository.getStudentList());
        int groupsSize = 6;
        Random random = new Random();
        while (tempAll.size() != 0) {
            for (int i = 1; i <= groupsSize; i++) {
                AtomicInteger groupsId = new AtomicInteger(i);
                String groupsName = i + " 组";
                Group group = new Group(groupsId, groupsName);
                List<Student> iGroupList;
                if (!studentGroup.containsKey(group)) {
                    iGroupList = new ArrayList<>();
                } else {
                    iGroupList = studentGroup.get(group);
                }
                if (tempAll.size() == 0) {
                    break;
                }
                int n = random.nextInt(tempAll.size());
                iGroupList.add(tempAll.get(n));
                tempAll.remove(tempAll.get(n));
                studentGroup.put(group, iGroupList);
            }
        }
        return studentGroup;
    }
}
