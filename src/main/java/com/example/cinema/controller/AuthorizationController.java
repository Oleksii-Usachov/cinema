package com.example.cinema.controller;

import com.example.cinema.controller.dto.Credentials;
import com.example.cinema.controller.dto.ViewerDto;
import com.example.cinema.service.AuthorizationService;
import com.example.cinema.validator.ViewerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/Authorization")
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private ViewerValidator viewerValidator;

    @PostMapping(value = "/signIn")
    public ResponseEntity<ViewerDto> signInWithCredentials(@RequestBody Credentials credentials) {
        return ResponseEntity.ok(authorizationService.getViewerData(credentials));
    }

    @PostMapping(value = "/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ViewerDto> registerNewViewer(@Valid @RequestBody ViewerDto viewerDto) {
        viewerValidator.validateViewerDoesNotExist(viewerDto);
        return ResponseEntity.ok(authorizationService.registerNewViewer(viewerDto));
    }

    @DeleteMapping(value = "/delete-viewer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteViewer(@PathVariable("id") Long id) {
        authorizationService.deleteViewer(id);
        return ResponseEntity.ok("Viewer with id: " + id + " was deleted");
    }
}
