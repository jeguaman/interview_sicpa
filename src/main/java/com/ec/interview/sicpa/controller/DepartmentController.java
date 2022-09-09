/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.controller;

import com.ec.interview.sicpa.dto.DepartmentDto;
import com.ec.interview.sicpa.model.Department;
import com.ec.interview.sicpa.service.DepartmentService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author J Guaman
 */
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    @ResponseBody
    public List<DepartmentDto> getDepartments() {
        return departmentService.findAll().stream().map(department -> modelMapper.map(department, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping(name = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DepartmentDto registerDepartment(@RequestBody DepartmentDto departmentDto) {
        Department postRequest = modelMapper.map(departmentDto, Department.class);
        Department post = departmentService.createOrEdit(postRequest);
        return modelMapper.map(post, DepartmentDto.class);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DepartmentDto updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto) {
        Department department = departmentService.findDepartmentById(id);
        if (department == null) {

        }
//        department.set result = modelMapper.map(result, Department.class);
        Department post = departmentService.createOrEdit(department);
        return modelMapper.map(post, DepartmentDto.class);
    }

    private Department convertToEntity(DepartmentDto postDto) throws ParseException {
        Department post = modelMapper.map(postDto, Department.class);
//        post.setSubmissionDate(postDto.getSubmissionDateConverted(
//                departmentService.getCurrentUser().getPreference().getTimezone()));

//        if (postDto.getId() != null) {
//            Department oldPost = departmentService.getPostById(postDto.getId());
//            post.setRedditID(oldPost.getRedditID());
//            post.setSent(oldPost.isSent());
//        }
//        Post post = postRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
//
//        post.setTitle(postRequest.getTitle());
//        post.setDescription(postRequest.getDescription());
//        post.setContent(postRequest.getContent());
//        return postRepository.save(post);
        return post;
    }

//    public ResponseEntity<PostDto> updatePost(@PathVariable long id, @RequestBody PostDto postDto) {
//
//        // convert DTO to Entity
//        Post postRequest = modelMapper.map(postDto, Post.class);
//
//        Post post = postService.updatePost(id, postRequest);
//
//        // entity to DTO
//        PostDto postResponse = modelMapper.map(post, PostDto.class);
//
//        return ResponseEntity.ok().body(postResponse);
//    }
//
//    public Post updatePost(long id, Post postRequest) {
//        Post post = postRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
//
//        post.setTitle(postRequest.getTitle());
//        post.setDescription(postRequest.getDescription());
//        post.setContent(postRequest.getContent());
//        return postRepository.save(post);
//    }
    
    //https://www.javaguides.net/2021/02/spring-boot-dto-example-entity-to-dto.html
}
