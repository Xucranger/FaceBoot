package cn.cy.service;

import cn.cy.domain.Image;
import cn.cy.domain.Result;
import org.springframework.stereotype.Service;

@Service
public interface FaceSearch {
    Result faceLogin(Image image);
}
