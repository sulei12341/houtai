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
package code.tianmao.h5.utils;

/**
 * <p>类简述：数据库特殊字符过滤</p>
 * <p>
 * <p>描述：</p>
 * <p>
 * <p>补充：</p>
 *
 * @author wiiyaya
 */
public class SqlFilter {

    public static final char DEFALT_ESCAPE_CHAR = '/';

    private static final String DB_LIKE = "%";
    private static final char[] ESCAPE_CHAR = {'%', '_', '/'};
    private static final String[] ESCAPE = {DB_LIKE, "_", "/"};
    private static final String[] REPLACEMENT = {"/%", "/_", "//"};

    /**
     * 过滤数据库模糊匹配的数据
     *
     * @param param 需要匹配的参数
     * @return 过滤后的参数
     */
    public static String filterForLike(String param) {
        if (StringUtilPlus.containsAny(param, ESCAPE_CHAR)) {
            return DB_LIKE + StringUtilPlus.replaceEach(param, ESCAPE, REPLACEMENT) + DB_LIKE;
        }
        return DB_LIKE + param + DB_LIKE;
    }

    /**
     * 将逗号分隔的数据转换为正则表达式
     *
     * @param docSplitStr 需要转换的参数
     * @return 转换后的正则表达式
     */
    public static String filterForMatches(String docSplitStr) {
        return StringUtilPlus.L_PT + StringUtilPlus.COMMA + docSplitStr.replaceAll(StringUtilPlus.COMMA, ",)|(,") + StringUtilPlus.COMMA + StringUtilPlus.R_PT;
    }
}
