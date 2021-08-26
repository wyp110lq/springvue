package com.lazy.demo.sshvue.server.api.service;

import com.lazy.demo.sshvue.server.api.dto.EnvinfoQueryDto;
import com.lazy.demo.sshvue.server.api.dto.WebResultDto;
import com.lazy.demo.sshvue.server.api.entity.TEnvinfoEntity;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @Author: wyp
 * @Description: 定义测试环境信息页面操作接口
 * @Date: Created in 下午 3:47 2021/8/26 0026
 */
public interface IEnvinfoService {

    WebResultDto<List<TEnvinfoEntity>> findByConditions(EnvinfoQueryDto queryDto, PageRequest pageable);

    /*
    保存数据
     */
    void savaData(TEnvinfoEntity entity);
    /*
    删除所有数据
     */

    void deleteAll(List<Long> ids);



}
