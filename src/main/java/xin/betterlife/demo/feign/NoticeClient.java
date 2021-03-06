/**
 * Copyright (c) 2018-2028, Steven Chen ιζθΆ (icegroup@163.com).
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
package xin.betterlife.demo.feign;

import xin.betterlife.demo.entity.Notice;
import xin.betterlife.demo.mapper.NoticeMapper;
import lombok.AllArgsConstructor;
import xin.betterlife.core.tool.api.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Notice Feign
 *
 * @author Steven Chen
 */
@ApiIgnore()
@RestController
@AllArgsConstructor
public class NoticeClient implements INoticeClient {

	private final NoticeMapper mapper;

	@Override
	@GetMapping(TOP)
	public R<List<Notice>> top(Integer number) {
		return R.data(mapper.topList(number));
	}

}
