package com.zcx.service;

import com.zcx.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author：卿抒z
 * @Package：com.zcx.service
 * @Project：blog
 * @name：TypeService
 * @Date：2023/2/27 11:23
 * @Filename：TypeService
 */
public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    Type updateType(Long id,Type type);

    void deleteType(Long id);

}
