package com.lazy.demo.sshvue.server.api.controller.envinfo;

import com.lazy.demo.sshvue.server.api.dto.EnvinfoQueryDto;
import com.lazy.demo.sshvue.server.api.dto.ResponseDto;
import com.lazy.demo.sshvue.server.api.entity.TEnvinfoEntity;
import com.lazy.demo.sshvue.server.api.service.IEnvinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wyp
 * @Description:测试环境地址配置，控制器
 * @Date: Created in 下午 4:06 2021/8/26 0026
 */
@RestController
public class EnvinfoController {

    @Autowired
    private IEnvinfoService iEnvinfoService;
    private static final Logger logger = LoggerFactory.getLogger(EnvinfoController.class);

    @PostMapping("/queyEnvinfo")
    public ResponseDto getEnvinfo(@RequestBody EnvinfoQueryDto queryDto) {

        //排序可以改为从前端传递
        Sort sort = Sort.by(Sort.Order.desc("flast_update_time"));

        return
                ResponseDto.success(iEnvinfoService.findByConditions(queryDto,
                        PageRequest.of(queryDto.getPaging().getCurrentPage() - 1, queryDto.getPaging().getPageSize(), sort)));

    }


    @PutMapping("/savaEnvinfo")
    public ResponseDto putExample(@RequestBody TEnvinfoEntity entity) {

        iEnvinfoService.savaData(entity);
        return ResponseDto.success(null);
    }

}
