package code.tianmao.h5.sysconfig.mybatis.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @author Junpeng.Su
 * @date 2016/12/15
 */
public interface SelectPageMapper<T, D> {
    @SelectProvider(
            type = BaseSelectPageProvider.class,
            method = "dynamicSQL"
    )
    Page<D> selectPage(T var1);
}
