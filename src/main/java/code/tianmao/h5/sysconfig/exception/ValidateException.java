package code.tianmao.h5.sysconfig.exception;


/**
 * <p>类简述：数据对象验证异常</p>
 * <p>
 * <p>描述：使用{@link org.springframework.validation.annotation.Validated}注解校验的错误，需要使用该异常包装后抛出</p>
 * <p>
 * <p>补充：数据对象的国际化格式为attr.数据对象名.属性</p>
 *
 * @author wiiyaya
 */
public class ValidateException extends RuntimeException {

    private static final long serialVersionUID = 7450363518285869297L;

}
