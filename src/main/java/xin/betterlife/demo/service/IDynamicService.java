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
package xin.betterlife.demo.service;

import xin.betterlife.demo.entity.Notice;
import xin.betterlife.core.mp.base.BaseService;

import java.util.List;

/**
 * 服务类
 *
 * @author Steven Chen
 */
public interface IDynamicService extends BaseService<Notice> {

	/**
	 * master数据源的列表
	 *
	 * @return
	 */
	List<Notice> masterList();

	/**
	 * slave数据源的列表
	 *
	 * @return
	 */
	List<Notice> slaveList();

}
