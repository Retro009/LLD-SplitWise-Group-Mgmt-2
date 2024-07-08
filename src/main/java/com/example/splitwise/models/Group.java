package com.example.splitwise.models;

import java.util.Date;
import lombok.Data;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)

@Data
@Table(name="/'Group/'")
@Entity
public class Group extends BaseModel{
    private String name;
    private String description;
    private Date createdAt;
}
