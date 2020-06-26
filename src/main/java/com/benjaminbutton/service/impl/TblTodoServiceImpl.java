package com.benjaminbutton.service.impl;

import com.benjaminbutton.bean.TblTodo;
import com.benjaminbutton.mapper.TblTodoMapper;
import com.benjaminbutton.service.base.TblTodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 待办事项 服务实现类
 * </p>
 *
 * @author wwx
 * @since 2020-06-24
 */
@Service
public class TblTodoServiceImpl extends ServiceImpl<TblTodoMapper, TblTodo> implements TblTodoService {

}
