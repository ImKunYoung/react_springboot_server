package com.example.react_springboot_server.controller;

import com.example.react_springboot_server.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {

    @GetMapping("/testTodo")
    public ResponseEntity<?> testTodo() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm Response Entity. And you got 200!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // http status를 200으로 설정
        return ResponseEntity.ok().body(response);
    }

}
