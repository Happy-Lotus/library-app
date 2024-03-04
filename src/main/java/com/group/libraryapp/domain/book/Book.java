package com.group.libraryapp.domain.book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Book(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 이름이 들어왔습니다."));
        }
        this.name = name;
    }

}
