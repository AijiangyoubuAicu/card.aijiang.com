/*
 * Copyright (c) 2021. 广州凡岛网络科技有限公司。
 * 版权©️所有，请勿随意删除、修改此头部，切勿以任何方式外泄源代码、设计图、数据库等资料！违者后果自负
 *
 *   .--.,                               ,---,
 * ,--.'  \                  ,---,     ,---.'|               ,---.
 * |  | /\/              ,-+-. /  |    |   | :              '   ,'\
 * :  : :    ,--.--.    ,--.'|'   |    |   | |   ,--.--.   /   /   |
 * :  | |-, /       \  |   |  ,"' |  ,--.__| |  /       \ .   ; ,. :
 * |  : :/|.--.  .-. | |   | /  | | /   ,'   | .--.  .-. |'   | |: :
 * |  |  .' \__\/: . . |   | |  | |.   '  /  |  \__\/: . .'   | .; :
 * '  : '   ," .--.; | |   | |  |/ '   ; |:  |  ," .--.; ||   :    |
 * |  | |  /  /  ,.  | |   | |--'  |   | '/  ' /  /  ,.  | \   \  /
 * |  : \ ;  :   .'   \|   |/      |   :    :|;  :   .'   \ `----'
 * |  |,' |  ,     .-./'---'        \   \  /  |  ,     .-./
 * `--'    `--`---'                  `----'    `--`---'
 *
 *                   让 更 美 的 生 活 触 手 可 及
 */

package com.aijiang.card.infrastructure.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlusMapper 扫描配置类
 */
@Configuration
@MapperScan({"com.aijiang.card.infrastructure.mapper"})
public class MybatisMapperConfig {
	
	/**
	 * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
		return interceptor;
	}

}
