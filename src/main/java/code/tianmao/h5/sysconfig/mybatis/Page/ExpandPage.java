package code.tianmao.h5.sysconfig.mybatis.Page;

import code.tianmao.h5.utils.BeanUtilPlus;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author Junpeng.Su
 * @date 2016/12/16
 */
public class ExpandPage<D> extends Page<D> {

    public List setContentList(Class entityClass) {
        List<D> result = super.getResult();
        return  BeanUtilPlus.copyAs(result, entityClass);
    }


}
