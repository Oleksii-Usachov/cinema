package com.example.cinema.repository;

import com.example.cinema.repository.entity.Viewer;
import com.example.cinema.utils.ResponseUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ViewerRepository extends CrudRepository<Viewer, Long> {

    @Transactional
    Integer deleteViewerById(Long id);

    default Viewer findViewerById(Long id) {
        return Optional.of(this.findById(id))
                .get().orElseThrow(() -> ResponseUtils.throwBadRequestException("Viewer Id: " + id + " not found"));
    }

    Viewer findViewerByLoginAndPassword(String viewerLogin, String viewerPass);

    Viewer findViewerByLoginOrPassword(String viewerLogin, String viewerPass);
}
