package com.example.splitwise.services;

import com.example.splitwise.exceptions.InvalidGroupException;
import com.example.splitwise.exceptions.InvalidUserException;
import com.example.splitwise.exceptions.UnAuthorizedAccessException;
import com.example.splitwise.models.*;
import com.example.splitwise.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupAdminRepository groupAdminRepository;
    @Autowired
    private GroupMemberRepository groupMemberRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    public Group createGroup(String groupName, String description, long userId) throws InvalidUserException{
        User user = userRepository.findById(userId).orElseThrow(()-> new InvalidUserException("User Not Found!"));
        Group group = new Group();
        group.setName(groupName);
        group.setDescription(description);
        group.setCreatedAt(new Date());
        userRepository.save(group);

        GroupAdmin  groupAdmin = new GroupAdmin();
        groupAdmin.setGroup(group);
        groupAdmin.setAdmin(user);
        group.setAddedBy(user);
        groupAdminRepository.save(groupAdmin);
        
        return group;
    }

    public void deleteGroup(long groupId, long userId) throws InvalidGroupException, UnAuthorizedAccessException, InvalidUserException{
        Group group = groupRepository.findById(groupId).orElseThrow(()-> new InvalidGroupException("Group Not Found"));
        User user = userRepository.findById(userId).orElseThrow(()-> new InvalidUserException("User Not Found"));

        GroupAdmin groupAdmin = groupAdminRepository.findByGroupIdAndAdminId(group.getId(), user.getId()).orElseThrow(()-> new UnAuthorizedAccessException("Access Denied"));

        List<GroupAdmin> groupAdmins = groupAdminRepository.findByGroupId(groupId);
        for(GroupAdmin ga:groupAdmins){
            groupAdminRepository.delete(ga);
        }
        List<GroupMember> groupMembers = groupMemberRepository.findByGroupId(groupId);
        for(GroupMember gm:groupMembers){
            groupMemberRepository.delete(gm);
        }
        groupRepository.delete(group);
    }
}