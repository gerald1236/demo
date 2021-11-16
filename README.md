# 开发规范

## 1. 数据库规范
1. 绝大多数规范同《Java开发手册（嵩山版）》，下述规则仅作为其中部分规则的修改和补充，而原有其他规则也必须同时准守。
2. 所有表格需要以’tg_’作为前缀，中间跟上该表对应的‘服务名称_’，如果该表涉及多个模块，则中间为‘common_’。 
> 如`tg_study_material`、`tg_partner_user`、`tg_common_user`等等
3. 所有业务表都需要有`id`字段，且必须以`id`字段作为主键，类型为`char(32)`，存储内容为去除‘-’的uuid；（关联表除外）——（9. 【强制】表必备三字段：id, create_time,       update_time。 ）
4. 所有业务表都需要有`create_time`(`timestamp`)、`updated_time`(`timestamp`)、`created_by`(`char(32)`)、`updated_by`(`char(32)`)、`is_deleted`(`unsigned tinyint`)、`version`(`int`)字段，其中所有字段不可为空。其中create_time、updated_time、created_by、updated_by字段，通过mybatisplus的自动填充功能进行注入，is_deleted通过mybatisplus的TableLogic注解自动注入，version通过mybatisplus的Version注解自动注入。——（9. 【强制】表必备三字段：id, create_time,       update_time。 ）
5. 所有表和所有字段，新增时必须存在对应的注释，如果表、字段修改后，注释也必须一并更新。
```sql
# 例子:
CREATE TABLE `tgs_food_composition1`  (
                                          `id` char(32) NOT NULL COMMENT 'ID号',
                                          `food_code` varchar(32) NOT NULL COMMENT '食物编码',
                                          `food_name` varchar(90)  NULL DEFAULT NULL COMMENT '食物名称',
                                          `food_type` varchar(64)  NULL DEFAULT NULL COMMENT '食品类型',
                                          `edible` decimal(8, 3) NULL DEFAULT NULL COMMENT '食部',
                                          `version` int NULL DEFAULT NULL COMMENT '乐观锁',
                                          `created_by` char(32) NOT NULL COMMENT '创建人',
                                          `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                          `updated_by` char(32)  NOT NULL COMMENT '更新人',
                                          `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                          `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否软删',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '食材营养信息表' ROW_FORMAT = DYNAMIC;

```

## 2. 数据库版本控制
1. Flyway（待补充）

##  3. 工程开发规范
1. 直接暴露给外界可访问的服务目前有且仅有partner、custom、business、rider、operation这五个服务，这五个服务，为了规避循环依赖的问题，不对内提供api接口进行调用。
2. 所有内部服务，都应该封装一个service-api包，提供给内部其他服务进行调用。
3. Controller层中只进行各类基本参数校验，或者不复用的业务简单处理，禁止将复杂业务处理写入Controller中。
4. 在Service层中，禁止循环注入，如两个Service存在相互调用的情况，应将该逻辑提取出来，放入更高一层的Service中。
5. 所有依赖注入禁止使用@Autowired，而是统一在类上使用@AllArgsConstructor注解
6. 在所有内部服务中，应该以‘/版本号/服务名’为开头，而在对外提供的服务中，应该直接以‘/服务名’为开头
7. 所有表格分页查询，当前页变量统一为current，每页条数变量统一为size，开始时间变量统一为startTime，结束时间变量统一为endTime。