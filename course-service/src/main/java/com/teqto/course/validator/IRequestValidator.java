package com.teqto.course.validator;

import javax.servlet.http.HttpServletRequest;

import com.teqto.course.entity.User;

public interface IRequestValidator {

	public User getUserFromRequest(HttpServletRequest request);
}
