package com.example.JWTSecure.DTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class QuizDTO implements Serializable {
    private Long id;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correct;
    private String createdAt;
    private String updatedAt;
    private int page;
    private int pageSize;
    private String key_search;
    private int resultData;
}