package com.example.splitwise.models;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User extends BaseModel{
    private String name;
    private String phoneNumber;
}