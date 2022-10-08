package com.example.cinema.repository;

import com.example.cinema.repository.entity.Viewer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewerRepository extends CrudRepository<Viewer, Long> {

    Viewer findViewerById(Long viewerId);

    Viewer findViewerByLoginAndPassword(String viewerLogin, String viewerPass);

    Viewer findViewerByLoginOrPassword(String viewerLogin, String viewerPass);
}
