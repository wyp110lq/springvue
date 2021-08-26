package com.lazy.demo.sshvue.server.api.dto;

import lombok.Data;

/**
 * @Author: wyp
 * @Description:测试环境配置信息 Dto
 * @Date: Created in 下午 3:25 2021/8/26 0026
 */
@Data
public class EnvinfoQueryDto {

    private static final long serialVersionUID = -98456537689L;

    private PageDto paging;

    private Long fnum;

    private String fipaddr;

    private String facsversion;

    private String fsofaversion;

    private String fcodepath;

    private String fsshaddr;

    private String fdatabaseaddr;

    private String fsetinfo;

    private String fleader;

    private String fuse;

    private String fconsoleaddr;

    private String fjenkinsaddr;

}
