package com.benjaminbutton.mapper;

import com.benjaminbutton.bean.TblCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 企业档案 Mapper 接口
 * </p>
 *
 * @author wwx
 * @since 2020-06-24
 */
@Component
public interface TblCompanyMapper extends BaseMapper<TblCompany> {
    List<TblCompany> selectCompany();
}
