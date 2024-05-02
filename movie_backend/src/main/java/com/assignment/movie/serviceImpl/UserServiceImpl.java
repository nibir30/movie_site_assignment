package com.assignment.movie.serviceImpl;

import com.assignment.movie.data.ReqData.AddUserReqData;
import com.assignment.movie.data.ResData.core.ResponseBaseData;
import com.assignment.movie.model.UserModel;
import com.assignment.movie.repository.UserRepository;
import com.assignment.movie.service.UserService;
import com.assignment.movie.util.IdGenerator;
import com.assignment.movie.util.ResponseUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseBaseData<?> addUser(AddUserReqData addUserReqData) {
        if (checkStringNullOrEmpty(addUserReqData.getFirstName())
                || checkStringNullOrEmpty(addUserReqData.getLastName())) {
            return ResponseUtils.validationError("Name is mandatory!");
        } else if (checkStringNullOrEmpty(addUserReqData.getEmail())) {
            return ResponseUtils.validationError("Email is mandatory!");
        } else if (addUserReqData.getDob() == null) {
            return ResponseUtils.validationError("Date of Birth is mandatory!");
        }
        try {
            UserModel newUser = new UserModel();
            if (addUserReqData.getId() == null) {
                addUserReqData.setId(IdGenerator.generateId());
            }
            BeanUtils.copyProperties(addUserReqData, newUser);
            newUser.setInsertTime(LocalDateTime.now());
            UserModel savedUser = userRepository.save(newUser);
            return ResponseUtils.dataSuccess("Successfully added a user", savedUser);
        } catch (Exception ex) {
            return ResponseUtils.exceptionError("Could not save a user", ex.getMessage());
        }
    }

    public Boolean checkStringNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
