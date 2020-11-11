package com.thoughtworks.capability.gtb.restfulapidesign.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private AtomicInteger id;
    private String name;
    private String note;

    public Group(AtomicInteger id, String name) {
        this.id = id;
        this.name = name;
    }
}
