package com.lazy.demo.sshvue.server.api.service.impl;

import com.lazy.demo.sshvue.server.api.dao.IEnvinfoRepository;
import com.lazy.demo.sshvue.server.api.dto.EnvinfoQueryDto;
import com.lazy.demo.sshvue.server.api.dto.ExampleQueryDto;
import com.lazy.demo.sshvue.server.api.dto.WebResultDto;
import com.lazy.demo.sshvue.server.api.entity.TEnvinfoEntity;
import com.lazy.demo.sshvue.server.api.entity.TExampleEntity;
import com.lazy.demo.sshvue.server.api.service.IEnvinfoService;
import com.lazy.demo.sshvue.server.api.service.IUniqueService;
import com.lazy.demo.sshvue.server.api.utils.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wyp
 * @Description:
 * @Date: Created in 下午 3:51 2021/8/26 0026
 */
@Service
public class EnvinfoServiceImpl implements IEnvinfoService {

    @Autowired
    private IEnvinfoRepository iEnvinfoRepository;

    @Autowired
    private IUniqueService iUniqueService;

    /**
     * 动态生成where语句
     */
    private Specification<TEnvinfoEntity> doCreatedCondition(final EnvinfoQueryDto entity) {
        return (Specification<TEnvinfoEntity>) (root, query, cb) -> {
            List<Predicate> predicate = new ArrayList<>();
            if (!AssertUtils.isEmpty(entity.getFipaddr())) {
                predicate.add(cb.like(root.get("fipaddr"), "%" + entity.getFipaddr().trim() + "%"));
            }
            if (!AssertUtils.isEmpty(entity.getFacsversion())) {
                predicate.add(cb.like(root.get("facsversion"), "%" + entity.getFacsversion().trim() + "%"));
            }
            Predicate[] pre = new Predicate[predicate.size()];
            return query.where(predicate.toArray(pre)).getRestriction();
        };
    }

    @Override
    public WebResultDto<List<TEnvinfoEntity>> findByConditions(EnvinfoQueryDto queryDto, PageRequest pageable) {
        WebResultDto<List<TEnvinfoEntity>> dto = new WebResultDto<>();
        Page<TEnvinfoEntity> page = iEnvinfoRepository.findAll(this.doCreatedCondition(queryDto), pageable);
        dto.setTotalPage(page.getTotalPages())
                .setCurrentPage(page.getPageable().getPageNumber())
                .setPageSize(page.getPageable().getPageSize())
                .setCount(page.getTotalElements());
        dto.setData(page.getContent());
        return dto;
    }

    @Override
    public void savaData(TEnvinfoEntity entity) {
        entity.setFlastUpdateTime(LocalDateTime.now());
        if (entity.getFid() == null) {
            entity.setFid(iUniqueService.getPrimaryKey());
        }
        if (entity.getFcreateTime() == null) {
            entity.setFcreateTime(entity.getFlastUpdateTime());
        }
        iEnvinfoRepository.save(entity);

    }

    @Override
    public void deleteAll(List<Long> ids) {

        return;

    }
}
