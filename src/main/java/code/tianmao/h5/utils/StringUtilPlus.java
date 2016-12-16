package code.tianmao.h5.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public final class StringUtilPlus extends StringUtils {

    public static final String PERCENT = "%";
    public static final String SLASH = "/";//back slash\
    public static final String SPACE_SLASH = " / ";
    public static final String DOT = ".";
    public static final String HYPHEN = "-";//dash
    public static final String SPACE_HYPHEN = " - ";
    public static final String UNDER_SCORE = "_";//under line
    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String L_PT = "(";//parenthesis
    public static final String R_PT = ")";
    public static final String ENTER = "\n";
    public static final String REGEX_LAST_COMMA = ",$";

    private StringUtilPlus() {

    }


    public static String defaultString(final Number num) {
        return num == null ? EMPTY : defaultString(num.toString());
    }

    public static String leftPad(final Number num, final int size, final char padChar) {
        return leftPad(defaultString(num), size, padChar);
    }

    /**
     * 如果找到非法字符则返回true,如果没找到则返回false
     *
     * @param value 字符串
     * @return 是否含有非法字符
     */
    public static boolean stripXSS(String value) {
        boolean result = false;
        if (value != null) {
            value = value.replaceAll(" ", "");
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();
            //如果找到则为true
            if (result) {
                return true;
            }

            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();
            if (result) {
                return true;
            }

            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();
            if (result) {
                return true;
            }

            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();
            if (result) {
                return true;
            }

            scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();
            if (result) {
                return true;
            }

            scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();
            if (result) {
                return true;
            }

            scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();
            if (result) {
                return true;
            }

            scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();
            if (result) {
                return true;
            }

            scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();
            if (result) {
                return true;
            }

            scriptPattern = Pattern.compile("alert", Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();
            if (result) {
                return true;
            }
        }
        return result;
    }
}
