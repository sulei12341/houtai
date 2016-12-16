/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package code.tianmao.h5.controller;

import code.tianmao.h5.sysconfig.exception.ExceptionController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>类简述：全局异常控制器</p>
 * <p>
 * <p>描述：</p>
 * <p>
 * <p>补充：</p>
 *
 * @author wiiyaya
 */
@ControllerAdvice
@Controller
public class BackendExceptionController extends ExceptionController {

    private static final MappingJackson2JsonView DEFAULT_JSON_VIEW = new MappingJackson2JsonView();

    protected ModelAndView prepareExceptionInfo(HttpServletRequest request, HttpStatus httpStatus, String errorCode, String errorMessage) {
        Map<String, Object> models = new LinkedHashMap<>();
        models.put("errorCode", errorCode);
        models.put("errorMessage", errorMessage);
        ModelAndView modelAndView = new ModelAndView();
        if (noNeedWrapper(request)) {
            modelAndView.setView(DEFAULT_JSON_VIEW);
            modelAndView.addAllObjects(models);
            return modelAndView;
        } else {
            modelAndView.setViewName("error");
            modelAndView.addAllObjects(models);
            return modelAndView;
        }
    }

    private boolean noNeedWrapper(HttpServletRequest request) {
        String xmlHttpRequest = request.getHeader("X-Requested-With");
        String noWrapperParameter = StringUtils.defaultString(request.getParameter("noSiteMeshWapper"));
        return "XMLHttpRequest".equalsIgnoreCase(xmlHttpRequest)
                || noWrapperParameter.equalsIgnoreCase("true")
                || noWrapperParameter.equalsIgnoreCase("yes")
                || noWrapperParameter.equals("1");
    }

}
