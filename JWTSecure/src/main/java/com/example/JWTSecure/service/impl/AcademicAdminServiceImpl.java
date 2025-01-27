package com.example.JWTSecure.service.impl;

import com.example.JWTSecure.DTO.*;
import com.example.JWTSecure.domain.*;
import com.example.JWTSecure.repo.*;
import com.example.JWTSecure.repo.impl.*;
import com.example.JWTSecure.service.AcademicAdminService;
import com.nimbusds.oauth2.sdk.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AcademicAdminServiceImpl implements AcademicAdminService {

    private final PasswordEncoder passwordEncoder;
    private final StudentRepo studentRepo;
    private final AcademicAdminRepo academicAdminRepo;
    private final QuizRepo quizRepo;
    private final CourseRepo courseRepo;
    private final AcademicAdminCustomRepo academicAdminCustomRepo;
    private final UserRepo userRepo;
    private final CourseCustomRepo courseCustomRepo;
    private final QuizCustomRepo quizCustomRepo;
    private final RoomCustomRepo roomCustomRepo;
    private final ClassCustomRepo classCustomRepo;
    private final ClassRepo classRepo;
    private final RoomRepo roomRepo;

    @Override
    public List<Quiz> getQuiz(Long levelId) {
        return quizCustomRepo.multipleChoice(levelId);
    }

    @Override
    public ResponseStatus deleteQuiz(Long id) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            if (id != null) {
                quizRepo.deleteById(id);
                responseStatus.setState(true);
                responseStatus.setMessage("Success");
            } else {
                responseStatus.setState(false);
                responseStatus.setMessage("Failure");
            }
            return responseStatus;
        } catch (Exception e) {
            responseStatus.setState(false);
            responseStatus.setMessage("Failure");
            return responseStatus;
        }
    }

    @Override
    public ResponseStatus editQuiz(Quiz quiz) {
        ResponseStatus rs = new ResponseStatus();
        if (quiz != null) {
            try {
                quiz.setAcaId(quizRepo.findById(quiz.getId()).get().getAcaId());
                quiz.setLevelId(quizRepo.findById(quiz.getId()).get().getLevelId());
                quiz.setCreatedAt(quizRepo.findById(quiz.getId()).get().getUpdatedAt());
                String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(timeStamp, formatter);
                quiz.setUpdatedAt(localDateTime);
                quizRepo.save(quiz);
                rs.setMessage("Ok");
                rs.setState(true);
            } catch (Exception ex) {
                rs.setMessage("Failure");
                rs.setState(false);
            }
        }
        return rs;
    }

    @Override
    public ResponseStatus addQuiz(Quiz quiz) {
        ResponseStatus rs = new ResponseStatus();
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(timeStamp, formatter);
        if (quiz != null) {
            try {
                quiz.setCreatedAt(localDateTime);
                quiz.setUpdatedAt(localDateTime);
                quizRepo.save(quiz);
                rs.setMessage("Ok");
                rs.setState(true);
            } catch (Exception ex) {
                rs.setMessage("Failure");
                rs.setState(false);
            }
        }
        return rs;
    }

    @Override
    public SearchResultDTO<RoomDTO> getRoom(RoomDTO roomDTO) {
        List<RoomDTO> dataResult;
        SearchResultDTO<RoomDTO> searchResult = new SearchResultDTO<>();
        try {
            Integer totalRecord = roomCustomRepo.getTotal(roomDTO).size();
            dataResult = roomCustomRepo.doSearch(roomDTO);
            if (dataResult != null && !dataResult.isEmpty()) {
                searchResult.setCode("0");
                searchResult.setSuccess(true);
                searchResult.setTitle("Success");
                searchResult.setMessage("Success");
                searchResult.setResultData(dataResult);
                searchResult.setTotalRecordNoLimit(totalRecord);
            } else {
                searchResult.setCode("0");
                searchResult.setSuccess(false);
                searchResult.setTitle("Failure");
                searchResult.setMessage("Failure");
                searchResult.setResultData(Collections.emptyList());
                searchResult.setTotalRecordNoLimit(0);
            }
            return searchResult;
        } catch (Exception e) {
            searchResult.setCode("0");
            searchResult.setSuccess(false);
            searchResult.setTitle("Failure");
            searchResult.setMessage("Failure");
            searchResult.setResultData(Collections.emptyList());
            searchResult.setTotalRecordNoLimit(0);
            return searchResult;
        }
    }

    @Override
    public List<Room> getRooms() {
        List<Room> list = new ArrayList<>();
        try {
            list = roomRepo.findAll();
        } catch (Exception ex) {
            return null;
        }
        return list;
    }

    @Override
    public SearchResultDTO<AcademicAdminDTO> getAllAcad(AcademicAdminDTO academicAdminDTO) {
        List<AcademicAdminDTO> dataResult;
        SearchResultDTO<AcademicAdminDTO> searchResult = new SearchResultDTO<>();
        try {
            Integer totalRecord = academicAdminCustomRepo.getTotal(academicAdminDTO).size();
            dataResult = academicAdminCustomRepo.doSearch(academicAdminDTO);
            if (dataResult != null && !dataResult.isEmpty()) {
                searchResult.setCode("0");
                searchResult.setSuccess(true);
                searchResult.setTitle("Success");
                searchResult.setMessage("Success");
                searchResult.setResultData(dataResult);
                searchResult.setTotalRecordNoLimit(totalRecord);
            } else {
                searchResult.setCode("0");
                searchResult.setSuccess(false);
                searchResult.setTitle("Failure");
                searchResult.setMessage("Failure");
                searchResult.setResultData(Collections.emptyList());
                searchResult.setTotalRecordNoLimit(0);
            }
            return searchResult;
        } catch (Exception e) {
            searchResult.setCode("0");
            searchResult.setSuccess(false);
            searchResult.setTitle("Failure");
            searchResult.setMessage("Failure");
            searchResult.setResultData(Collections.emptyList());
            searchResult.setTotalRecordNoLimit(0);
            return searchResult;
        }
    }

    @Override
    public ResponseStatus addAcad(AddAcademicAdminDTO addAcademicAdminDTO) {

        User user = new User();
        AcademicAdmin academicAdmin = new AcademicAdmin();
        ResponseStatus rs = new ResponseStatus();
        StringBuilder message = new StringBuilder();

        if (addAcademicAdminDTO != null) {
            if (userRepo.findByUsername(addAcademicAdminDTO.getUser_name()) != null) {
                message.append("Username ");
            }
            if (userRepo.findByEmail(addAcademicAdminDTO.getEmail()) != null) {
                message.append("Email ");
            }
            if (!StringUtils.isBlank(message)) {
                message.append("is existed");
                rs.setMessage(message.toString());
                rs.setState(false);
                return rs;
            }
            try {
                if (userRepo.findByUsername(addAcademicAdminDTO.getUser_name()) == null) {
                    if (userRepo.findByEmail(addAcademicAdminDTO.getEmail()) == null) {
                        if (userRepo.findByPhone(addAcademicAdminDTO.getPhone()) == null) {
                            user.setUsername(addAcademicAdminDTO.getUser_name());
                            user.setFullname(addAcademicAdminDTO.getFull_name());
                            user.setPassword(passwordEncoder.encode(addAcademicAdminDTO.getPassword()));
                            user.setEmail(addAcademicAdminDTO.getEmail());
                            user.setPhone(addAcademicAdminDTO.getPhone());
                            user.setAddress(addAcademicAdminDTO.getAddress());
                            user.setActive(addAcademicAdminDTO.isActive());
                            userRepo.save(user);

                            academicAdmin.setUserId(userRepo.findByUsername(addAcademicAdminDTO.getUser_name()).getId());
                            academicAdmin.setRoleId(2L);
                            academicAdminRepo.save(academicAdmin);
                            rs.setMessage("Ok");
                            rs.setState(true);
                        }
                    }
                } else {
                    rs.setMessage("Failure");
                    rs.setState(false);
                }
            } catch (Exception ex) {
                rs.setMessage("Failure");
                rs.setState(false);
            }
        }
        return rs;
    }

    @Override
    public AcademicAdminDTO viewProfile(AcademicAdminDTO academicAdminDTO) {
        return null;
    }

    @Override
    public ResponseStatus editAcad(AddAcademicAdminDTO addAcademicAdminDTO) {
        User user = new User();
        ResponseStatus rs = new ResponseStatus();
        StringBuilder message = new StringBuilder();

        if (addAcademicAdminDTO != null) {
            if (userRepo.findByUsername(addAcademicAdminDTO.getUser_name()) != null) {
                message.append("Username ");
            }
            if (userRepo.findByEmail(addAcademicAdminDTO.getEmail()) != null) {
                message.append("Email ");
            }
            if (!StringUtils.isBlank(message)) {
                message.append("is existed");
                rs.setMessage(message.toString());
                rs.setState(false);
                return rs;
            }

            try {
                if (userRepo.findByUsername(addAcademicAdminDTO.getUser_name()) == null) {
                    if (userRepo.findByEmail(addAcademicAdminDTO.getEmail()) == null) {
                        user.setId(addAcademicAdminDTO.getId());
                        user.setUsername(userRepo.findById(addAcademicAdminDTO.getId()).get().getUsername());
                        user.setFullname(addAcademicAdminDTO.getFull_name());
                        user.setPassword(userRepo.findById(addAcademicAdminDTO.getId()).get().getPassword());
                        user.setEmail(userRepo.findById(addAcademicAdminDTO.getId()).get().getEmail());
                        user.setPhone(addAcademicAdminDTO.getPhone());
                        user.setAddress(addAcademicAdminDTO.getAddress());
                        user.setActive(addAcademicAdminDTO.isActive());
                        userRepo.save(user);
                        rs.setMessage("Ok");
                        rs.setState(true);
                    }
                } else {
                    rs.setMessage("Failure");
                    rs.setState(false);
                }
            } catch (Exception ex) {
                rs.setMessage("Failure");
                rs.setState(false);
            }
        }
        return rs;
    }

    @Override
    public ResponseStatus deleteAcad(Long id) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            if (id != null) {
                userRepo.deactiveAca(id);
                responseStatus.setState(true);
                responseStatus.setMessage("Success");
            } else {
                responseStatus.setState(false);
                responseStatus.setMessage("Failure");
            }
            return responseStatus;
        } catch (Exception e) {
            responseStatus.setState(false);
            responseStatus.setMessage("Failure");
            return responseStatus;
        }
    }

    @Override
    public ResponseStatus addCourse(Course course) {
        ResponseStatus rs = new ResponseStatus();
        if (course != null) {
            try {
                courseRepo.save(course);
                rs.setMessage("Ok");
                rs.setState(true);
            } catch (Exception ex) {
                rs.setMessage("Failure");
                rs.setState(false);
            }
        }
        return rs;
    }

    @Override
    public ResponseStatus editCourse(CourseDTO courseDTO) {
        ResponseStatus rs = new ResponseStatus();
        Course course = new Course();
        if (courseDTO != null) {
            try {
                course.setId(courseDTO.getId());
                course.setLevelId(courseDTO.getLevelId());
                course.setName(courseDTO.getCourse_name());
                course.setCreatedAt(courseRepo.findById(courseDTO.getId()).get().getUpdatedAt());
                String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(timeStamp, formatter);
                course.setUpdatedAt(localDateTime);
                course.setNumberSlot(courseDTO.getNumberSlot());
                courseRepo.save(course);
                rs.setMessage("Ok");
                rs.setState(true);
            } catch (Exception ex) {
                rs.setMessage("Failure");
                rs.setState(false);
            }
        }
        return rs;
    }

    @Override
    public List<Course> getCourse() {
        List<Course> list = new ArrayList<>();
        try {
            list = courseRepo.findAll();
        } catch (Exception ex) {
            return null;
        }
        return list;
    }

    @Override
    public SearchResultDTO<CourseDTO> getCoursePaging(CourseDTO courseDTO) {
        List<CourseDTO> dataResult;
        SearchResultDTO<CourseDTO> searchResult = new SearchResultDTO<>();
        try {
            Integer totalRecord = courseCustomRepo.getTotal(courseDTO).size();
            dataResult = courseCustomRepo.doSearch(courseDTO);
            if (dataResult != null && !dataResult.isEmpty()) {
                searchResult.setCode("0");
                searchResult.setSuccess(true);
                searchResult.setTitle("Success");
                searchResult.setMessage("Success");
                searchResult.setResultData(dataResult);
                searchResult.setTotalRecordNoLimit(totalRecord);
            } else {
                searchResult.setCode("0");
                searchResult.setSuccess(false);
                searchResult.setTitle("Failure");
                searchResult.setMessage("Failure");
                searchResult.setResultData(Collections.emptyList());
                searchResult.setTotalRecordNoLimit(0);
            }
            return searchResult;
        } catch (Exception e) {
            searchResult.setCode("0");
            searchResult.setSuccess(false);
            searchResult.setTitle("Failure");
            searchResult.setMessage("Failure");
            searchResult.setResultData(Collections.emptyList());
            searchResult.setTotalRecordNoLimit(0);
            return searchResult;
        }
    }

    @Override
    public Course getCourseById(Long id) {
        try {
            return courseRepo.findById(id).get();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<ClassDTO> getClassByCourseId(Long id) {
        try {
            return classCustomRepo.getClasses(id);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public SearchResultDTO<QuizDTO> getQuizPaging(QuizDTO quizDTO) {
        List<QuizDTO> dataResult;
        SearchResultDTO<QuizDTO> searchResult = new SearchResultDTO<>();
        try {
            Integer totalRecord = quizCustomRepo.getTotal(quizDTO).size();
            dataResult = quizCustomRepo.doSearch(quizDTO);
            if (dataResult != null && !dataResult.isEmpty()) {
                searchResult.setCode("0");
                searchResult.setSuccess(true);
                searchResult.setTitle("Success");
                searchResult.setMessage("Success");
                searchResult.setResultData(dataResult);
                searchResult.setTotalRecordNoLimit(totalRecord);
            } else {
                searchResult.setCode("0");
                searchResult.setSuccess(false);
                searchResult.setTitle("Failure");
                searchResult.setMessage("Failure");
                searchResult.setResultData(Collections.emptyList());
                searchResult.setTotalRecordNoLimit(0);
            }
            return searchResult;
        } catch (Exception e) {
            searchResult.setCode("0");
            searchResult.setSuccess(false);
            searchResult.setTitle("Failure");
            searchResult.setMessage("Failure");
            searchResult.setResultData(Collections.emptyList());
            searchResult.setTotalRecordNoLimit(0);
            return searchResult;
        }
    }
}