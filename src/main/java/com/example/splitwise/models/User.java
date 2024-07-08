package com.example.splitwise.models;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name="users")
public class User extends BaseModel{
    private String name;
    private String phoneNumber;
}