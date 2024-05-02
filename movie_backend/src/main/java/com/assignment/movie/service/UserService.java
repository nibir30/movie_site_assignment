package com.assignment.movie.service;

import com.assignment.movie.data.ReqData.AddUserReqData;
import com.assignment.movie.data.ResData.core.ResponseBaseData;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseBaseData<?> addUser(AddUserReqData addUserReqData);

//    ResponseBaseData<?> addTag(TagReqData tagReqData, Long userId);
//
//    ResponseBaseData<?> getAllTags();
}
