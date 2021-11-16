/**
 * Copyright (c) 2018-2028, Steven Chen 陈文超 (icegroup@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xin.betterlife.demo.launcher;

import xin.betterlife.common.constant.LauncherConstant;
import xin.betterlife.core.launch.constant.NacosConstant;
import xin.betterlife.core.launch.service.LauncherService;
import xin.betterlife.core.launch.utils.PropsUtil;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

/**
 * 启动参数拓展
 *
 * @author Steven Chen
 */
public class DemoLauncherServiceImpl implements LauncherService {

	@Override
	public void launcher(SpringApplicationBuilder builder, String appName, String profile) {
		Properties props = System.getProperties();
		PropsUtil.setProperty(props, "spring.cloud.nacos.config.ext-config[0].data-id", NacosConstant.dataId("tg-demo", profile));
		PropsUtil.setProperty(props, "spring.cloud.nacos.config.ext-config[0].group", NacosConstant.NACOS_CONFIG_GROUP);
		PropsUtil.setProperty(props, "spring.cloud.nacos.config.ext-config[0].refresh", NacosConstant.NACOS_CONFIG_REFRESH);
		// 自定义命名空间
		// PropsUtil.setProperty(props, "spring.cloud.nacos.config.namespace", LauncherConstant.NACOS_NAMESPACE);
		// PropsUtil.setProperty(props, "spring.cloud.nacos.discovery.namespace", LauncherConstant.NACOS_NAMESPACE);
	}

	@Override
	public int getOrder() {
		return 20;
	}
}
