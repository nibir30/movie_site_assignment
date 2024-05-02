package com.assignment.movie.serviceImpl;

import com.assignment.movie.data.ReqData.AddCastReqData;
import com.assignment.movie.data.ResData.core.ResponseBaseData;
import com.assignment.movie.model.CastModel;
import com.assignment.movie.repository.CastRepository;
import com.assignment.movie.service.CastService;
import com.assignment.movie.util.IdGenerator;
import com.assignment.movie.util.ResponseUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CastServiceImpl implements CastService {
    @Autowired
    CastRepository castRepository;

    @Override
    public ResponseBaseData<?> addCast(AddCastReqData addCastReqData) {
        if (checkStringNullOrEmpty(addCastReqData.getFullName())) {
            return ResponseUtils.validationError("Cast name is mandatory!");
        } else if (checkStringNullOrEmpty(addCastReqData.getImagePath())) {
            return ResponseUtils.validationError("Cast image is mandatory!");
        } else if (addCastReqData.getDob() == null) {
            return ResponseUtils.validationError("Cast Date of Birth is mandatory!");
        }
        try {
            CastModel newCast = new CastModel();
            newCast.setCastId(IdGenerator.generateId());
            BeanUtils.copyProperties(addCastReqData, newCast);
            newCast.setInsertTime(LocalDateTime.now());
            CastModel savedCast = castRepository.save(newCast);
            return ResponseUtils.dataSuccess("Successfully added a cast", newCast);
        } catch (Exception ex) {
            return ResponseUtils.exceptionError("Could not save cast", ex.getMessage());
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
