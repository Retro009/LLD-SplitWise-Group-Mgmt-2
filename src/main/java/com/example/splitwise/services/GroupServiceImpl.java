package com.example.splitwise.services;

import com.example.splitwise.exceptions.InvalidGroupException;
import com.example.splitwise.exceptions.InvalidUserException;
import com.example.splitwise.exceptions.UnAuthorizedAccessException;
import com.example.splitwise.models.Group;
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
        User user = userRepository.findById(userId).orElseThrow(()-> new InvalidUserException(""))
    }
}