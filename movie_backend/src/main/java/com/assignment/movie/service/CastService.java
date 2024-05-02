package com.assignment.movie.service;

import com.assignment.movie.data.ReqData.AddCastReqData;
import com.assignment.movie.data.ResData.core.ResponseBaseData;
import com.assignment.movie.model.CastModel;
import org.springframework.stereotype.Service;

@Service
public interface CastService {
    ResponseBaseData<?> addCast(AddCastReqData addCastReqData);

//    ResponseBaseData<?> addTag(TagReqData tagReqData, Long userId);
//
//    ResponseBaseData<?> getAllTags();
}
