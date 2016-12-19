package code.tianmao.h5.sysconfig.mybatis.Interceptor;

import code.tianmao.h5.dto.UserDto;
import code.tianmao.h5.sysconfig.mybatis.annotation.CreatedBy;
import code.tianmao.h5.sysconfig.mybatis.annotation.CreatedDate;
import code.tianmao.h5.sysconfig.mybatis.annotation.LastModifiedBy;
import code.tianmao.h5.sysconfig.mybatis.annotation.LastModifiedDate;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Properties;

/**
 * @author Junpeng.Su
 * @date 2016/11/18
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}) })
public class AuditingInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        Object parameter = invocation.getArgs()[1];
        Field[] fields = parameter.getClass().getFields();
        Date currentDate = new Date();
        Subject subject = SecurityUtils.getSubject();
        //取身份信息
        UserDto userDto = (UserDto) subject.getPrincipal();
        if(SqlCommandType.UPDATE==sqlCommandType) {
            for (Field field : fields) {
                if (AnnotationUtils.getAnnotation(field, LastModifiedBy.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter,userDto.getId());
                    field.setAccessible(false);
                }
                if (AnnotationUtils.getAnnotation(field, LastModifiedDate.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter,currentDate);
                    field.setAccessible(false);
                }
            }
        } else if(SqlCommandType.INSERT==sqlCommandType){
            for (Field field : fields) {
                if (AnnotationUtils.getAnnotation(field, CreatedBy.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter,userDto.getId());
                    field.setAccessible(false);
                }
                if (AnnotationUtils.getAnnotation(field, CreatedDate.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter,currentDate);
                    field.setAccessible(false);
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}