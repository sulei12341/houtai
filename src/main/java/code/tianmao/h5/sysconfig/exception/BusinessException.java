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
package code.tianmao.h5.sysconfig.exception;

import java.util.Arrays;

/**
 * <p>类简述：系统业务异常</p>
 * <p>
 * <p>描述：所有和业务相关的异常均由改类包装抛出，可指定错误代码以及参数</p>
 * <p>
 * <p>补充：</p>
 *
 * @author wiiyaya
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = 2485329619448041725L;

    private final Object[] arguments;

    private final String code;

    public BusinessException(String code, Object... arguments) {
        this.arguments = arguments;
        this.code = code;
    }

    public Object[] getArguments() {
        return Arrays.copyOf(arguments, arguments.length);
    }

    public String getCode() {
        return code;
    }

}
