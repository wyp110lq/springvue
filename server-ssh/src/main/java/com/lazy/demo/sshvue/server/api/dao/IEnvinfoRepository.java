package com.lazy.demo.sshvue.server.api.dao;

import com.lazy.demo.sshvue.server.api.entity.TEnvinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: wyp
 * @Description:
 * @Date: Created in 下午 3:32 2021/8/26 0026
 */
@Repository
public interface IEnvinfoRepository extends JpaRepository<TEnvinfoEntity ,Long>, JpaSpecificationExecutor<TEnvinfoEntity> {
}
