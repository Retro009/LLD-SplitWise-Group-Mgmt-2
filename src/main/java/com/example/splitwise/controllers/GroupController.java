package com.example.splitwise.controllers;

import com.example.splitwise.dtos.CreateGroupRequestDto;
import com.example.splitwise.dtos.CreateGroupResponseDto;
import com.example.splitwise.dtos.DeleteGroupRequestDto;
import com.example.splitwise.dtos.DeleteGroupResponseDto;
import com.example.splitwise.dtos.ResponseStatus;
import com.example.splitwise.services.GroupService;
import com.example.splitwise.exceptions.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class GroupController {
    @Autowired
    private GroupService service;
    public CreateGroupResponseDto createGroup(CreateGroupRequestDto requestDto){
        CreateGroupResponseDto responseDto = new CreateGroupResponseDto();
        try{
            responseDto.setGroup(service.createGroup(requestDto.getName(), requestDto.getDescription(), requestDto.getCreatorUserId()));
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(InvalidUserException e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }     
        return responseDto;
    }
    public DeleteGroupResponseDto deleteGroup(DeleteGroupRequestDto requestDto){
        DeleteGroupResponseDto responseDto = new DeleteGroupResponseDto();
        try{
            service.deleteGroup(requestDto.getGroupId(), requestDto.getUserId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(InvalidGroupException | UnAuthorizedAccessException | InvalidUserException e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}