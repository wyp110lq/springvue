package com.lazy.demo.sshvue.server.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lazy.demo.sshvue.server.api.dto.PageDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author: wyp
 * @Description:测试环境配置信息实体
 * @Date: Created in 下午 2:55 2021/8/26 0026
 */
@Entity
@Data
@Table(name = "t_env_info")
public class TEnvinfoEntity {

    /**
     * 主键id
     */
    @Id
    @Column(name = "fid")
    private Long fid;
    /**
     * 编号
     */
    @Column(name = "fnum")
    private Long fnum;

    /**
     * ip地址
     */
    @Column(name = "fipaddr")
    private String fipaddr;
    /**
     * acs版本
     */
    @Column(name = "facsversion")
    private String facsversion;

    /**
     * sofa版本
     */
    @Column(name = "fsofaversion")
    private String fsofaversion;
    /**
     * 代码路径
     */
    @Column(name = "fcodepath")
    private String fcodepath;
    /**
     * SSH地址
     */
    @Column(name = "fsshaddr")
    private String fsshaddr;
    /**
     * 数据库地址
     */
    @Column(name = "fdatabaseaddr")
    private String fdatabaseaddr;
    /**
     * 配置说明
     */
    @Column(name = "fsetinfo")
    private String fsetinfo;
    /**
     * 负责人
     */
    @Column(name = "fleader")
    private String fleader;
    /**
     * 用途
     */
    @Column(name = "fuse")
    private String fuse;
    /**
     * 控制台地址
     */
    @Column(name = "fconsoleaddr")
    private String fconsoleaddr;
    /**
     * jenkins地址
     */
    @Column(name = "fjenkinsaddr")
    private String fjenkinsaddr;
    /**
     * 数据库创建时间
     */
    @Column(name = "fcreate_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fcreateTime;
    /**
     * 最后修改时间
     */
    @Column(name = "flast_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime flastUpdateTime;

    @Transient
    private PageDto paging;




}
