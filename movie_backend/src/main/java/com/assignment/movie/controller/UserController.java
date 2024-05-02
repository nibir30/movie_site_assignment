package com.assignment.movie.controller;

import com.assignment.movie.controller.common.UserApiUrlConstants;
import com.assignment.movie.data.ReqData.AddUserReqData;
import com.assignment.movie.data.ResData.core.ResponseBaseData;
import com.assignment.movie.service.UserService;
import com.assignment.movie.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = UserApiUrlConstants.REGISTER)
    @ResponseBody
    public ResponseBaseData<?> addUser(@RequestBody AddUserReqData addUserReqData) {
        try {
            return userService.addUser(addUserReqData);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseUtils.exceptionError("Unable to add user", ex.getMessage());
        }
    }

}
